package br.com.peneira.bean.atlhete;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

import javax.annotation.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;

@SuppressWarnings("serial")
@ManagedBean
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
			props.put("graph.facebook.com.consumer_key", "873747422659195");
			props.put("graph.facebook.com.consumer_secret", "27e73a8c1495ddeb25459434784bb515");
			// Define your custom permission if needed
			props.put("graph.facebook.com.custom_permissions",
			        "publish_stream,email,user_birthday,user_location,offline_access");
			// Initiate required components
			SocialAuthConfig config = SocialAuthConfig.getDefault();

			config.load(props);

			manager = new SocialAuthManager();
			manager.setSocialAuthConfig(config);
			// 'successURL' is the page you'll be redirected to on successful
			// login
			ExternalContext externalContext = FacesContext.getCurrentInstance()
			        .getExternalContext();
			String successURL = externalContext.getRequestContextPath()
			        + "socialLoginSuccess.xhtml";
			String authenticationURL = manager.getAuthenticationUrl("facebook", successURL);
			FacesContext.getCurrentInstance().getExternalContext().redirect(authenticationURL);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/index";
	}

	public void pullUserInfo() {
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
			        .redirect(externalContext.getRequestContextPath() + "home.xhtml");
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