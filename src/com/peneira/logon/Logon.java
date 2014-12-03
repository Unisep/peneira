package com.peneira.logon;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.Constants;
import org.brickred.socialauth.util.SocialAuthUtil;

@SessionScoped
@ManagedBean(name="logon")
public class Logon implements Serializable {

	private SocialAuthManager manager;
	private String originalURL;
	private String providerID;
	private Profile profile;

	public Logon() {
	}

	public String socialConnect() {
		try {
			// Put your keys and secrets from the providers here
			Properties props = System.getProperties();
			if (providerID.equals("twitter")) {
				props.put("twitter.com.consumer_key", "0XD1VsKqVhj4xRYxUFI9Dgh6Y");
				props.put("twitter.com.consumer_secret",
				        "llK7FjZFq0tTXYGpqIumTcm6yXTFzivnRiyoccB85N7WYffyEc");
				providerID = Constants.TWITTER;
			} else {
				props.put("googleapis.com.consumer_key",
				        "58165383551-q4a07du824mkmj29s61c7p5on5f5i9fk.apps.googleusercontent.com");
				props.put("googleapis.com.consumer_secret",
				        "58165383551-q4a07du824mkmj29s61c7p5on5f5i9fk@developer.gserviceaccount.com");
				providerID = Constants.GOOGLE_PLUS;
			}

			// Define your custom permission if needed
			// Initiate required components
			SocialAuthConfig config = SocialAuthConfig.getDefault();
			config.load(props);
			this.manager = new SocialAuthManager();
			this.manager.setSocialAuthConfig(config);
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			        .getExternalContext().getSession(true);
			session.setAttribute("authManager", this.manager);
			// 'successURL' is the page you'll be redirected to on successful
			// login
			String successURL = "http://localhost:8080/Peneira/dash.jsf";
			String authenticationURL = this.manager.getAuthenticationUrl(providerID, successURL);
			FacesContext.getCurrentInstance().getExternalContext().redirect(authenticationURL);

			return authenticationURL;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public void pullUserInfo() {
		try {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			        .getExternalContext().getSession(true);
			this.manager = (SocialAuthManager) session.getAttribute("authManager");
			ExternalContext externalContext = FacesContext.getCurrentInstance()
			        .getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			Map<String, String> paramsMap = SocialAuthUtil.getRequestParametersMap(request);

			if (this.manager != null) {
				AuthProvider provider = this.manager.connect(paramsMap);
				this.profile = provider.getUserProfile();

				System.out.println("User's Social profile: " + profile);
				System.out.println(profile.getFirstName());

				FacesContext.getCurrentInstance().getExternalContext().redirect(originalURL);
			} else
				FacesContext.getCurrentInstance().getExternalContext()
				        .redirect(externalContext.getRequestContextPath() + "home.xhtml");
		} catch (Exception ex) {
			System.out.println("UserSession - Exception: " + ex.toString());
		}
	}

	public void logOut() {
		try {
			// Disconnect from the provider
			manager.disconnectProvider(providerID);
			// Invalidate session
			ExternalContext externalContext = FacesContext.getCurrentInstance()
			        .getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			this.invalidateSession(request);
			// Redirect to home page
			FacesContext.getCurrentInstance().getExternalContext()
			        .redirect(externalContext.getRequestContextPath() + "home.jsf");

		} catch (IOException ex) {
			System.out.println("UserSessionBean - IOException: " + ex.toString());
		}
	}

	private void invalidateSession(HttpServletRequest request) {

	}

	public SocialAuthManager getManager() {
		return manager;
	}

	public void setManager(SocialAuthManager manager) {
		this.manager = manager;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getProviderID() {
		return providerID;
	}

	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}