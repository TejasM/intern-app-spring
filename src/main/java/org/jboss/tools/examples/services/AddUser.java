package org.jboss.tools.examples.services;

import javax.validation.constraints.Pattern;

public class AddUser {
	
	@Pattern(regexp="[A-Za-z]+ [A-Za-z]", message="Your name can only have letters")
	private String name;
	
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}", message="Invalid email Address.")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
