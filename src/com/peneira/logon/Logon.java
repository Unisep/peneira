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

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.Constants;
import org.brickred.socialauth.util.SocialAuthUtil;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
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
				props.put("googleapis.com.consumer_secret", "i5fUsv0B842-uxCGMRppPh9X");
				providerID = Constants.GOOGLE_PLUS;
			}

			// Define your custom permission if needed
			// Initiate required components
			SocialAuthConfig config = SocialAuthConfig.getDefault();
			config.load(props);
			manager = new SocialAuthManager();
			manager.setSocialAuthConfig(config);

			// 'successURL' is the page you'll be redirected to on successful
			// login
			ExternalContext externalContext = FacesContext.getCurrentInstance()
			        .getExternalContext();
			String successURL = "http://localhost:8080/Peneira/dash.jsf";
			String authenticationURL = manager.getAuthenticationUrl(providerID, successURL);
			FacesContext.getCurrentInstance().getExternalContext().redirect(authenticationURL);

			return authenticationURL;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String pullUserInfo() {
		try {
			// Pull user's data from the provider
			ExternalContext externalContext = FacesContext.getCurrentInstance()
			        .getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			Map<String, String> map = SocialAuthUtil.getRequestParametersMap(request);

			if (this.manager != null) {
				AuthProvider provider = manager.connect(map);
				this.profile = provider.getUserProfile();
				// Do what you want with the data (e.g. persist to the database,
				// etc.)
				System.out.println("User's Social profile: " + profile);
				// Redirect the user back to where they have been before logging
				// in

				FacesContext.getCurrentInstance().getExternalContext().redirect(originalURL);
			} else {
				FacesContext.getCurrentInstance().getExternalContext()
				        .redirect(externalContext.getRequestContextPath() + "index.jsf");
			}

			return null;
		} catch (Exception ex) {
			System.out.println("UserSession - Exception: " + ex.toString());
			return null;
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