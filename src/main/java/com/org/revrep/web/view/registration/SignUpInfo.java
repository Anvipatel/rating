package com.org.revrep.web.view.registration;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Anvi P
 *
 */
public class SignUpInfo {

	@NotEmpty
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
