import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessagingConfig {

	@Value("${messaging.username}")
	@NotNull
	private String username;

	@Value("${messaging.password}")
	@NotNull
	private String password;

	@Value("${messaging.initialFactory}")
	@NotNull
	private String initialFactory;

	@Value("${messaging.url}")
	@NotNull
	private String url;

	@Value("${messaging.queueFactory}")
	@NotNull
	private String queueFactory;

	@Value("${messaging.securityPrincipal}")
	@NotNull
	private String securityPrincipal;

	@Value("${messaging.securityCredentials}")
	@NotNull
	private String securityCredentials;

	@Value("${messaging.usernameILE}")
	@NotNull
	private String usernameILE;

	@Value("${messaging.passwordILE}")
	@NotNull
	private String passwordILE;

	@Value("${messaging.urlILE}")
	@NotNull
	private String urlILE;

	@Value("${messaging.queueFactoryILE}")
	@NotNull
	private String queueFactoryILE;

	@Value("${messaging.securityPrincipalILE}")
	@NotNull
	private String securityPrincipalILE;

	@Value("${messaging.securityCredentialsILE}")
	@NotNull
	private String securityCredentialsILE;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInitialFactory() {
		return initialFactory;
	}

	public void setInitialFactory(String initialFactory) {
		this.initialFactory = initialFactory;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQueueFactory() {
		return queueFactory;
	}

	public void setQueueFactory(String queueFactory) {
		this.queueFactory = queueFactory;
	}

	public String getSecurityPrincipal() {
		return securityPrincipal;
	}

	public void setSecurityPrincipal(String securityPrincipal) {
		this.securityPrincipal = securityPrincipal;
	}

	public String getSecurityCredentials() {
		return securityCredentials;
	}

	public void setSecurityCredentials(String securityCredentials) {
		this.securityCredentials = securityCredentials;
	}

	public String getUsernameILE() {
		return usernameILE;
	}

	public void setUsernameILE(String usernameILE) {
		this.usernameILE = usernameILE;
	}

	public String getPasswordILE() {
		return passwordILE;
	}

	public void setPasswordILE(String passwordILE) {
		this.passwordILE = passwordILE;
	}

	public String getUrlILE() {
		return urlILE;
	}

	public void setUrlILE(String urlILE) {
		this.urlILE = urlILE;
	}

	public String getQueueFactoryILE() {
		return queueFactoryILE;
	}

	public void setQueueFactoryILE(String queueFactoryILE) {
		this.queueFactoryILE = queueFactoryILE;
	}

	public String getSecurityPrincipalILE() {
		return securityPrincipalILE;
	}

	public void setSecurityPrincipalILE(String securityPrincipalILE) {
		this.securityPrincipalILE = securityPrincipalILE;
	}

	public String getSecurityCredentialsILE() {
		return securityCredentialsILE;
	}

	public void setSecurityCredentialsILE(String securityCredentialsILE) {
		this.securityCredentialsILE = securityCredentialsILE;
	}

}
