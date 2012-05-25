package org.jboss.tools.examples.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Entity
@Table(name="INTERNS", uniqueConstraints={@UniqueConstraint(columnNames = "EMAIL")})
public class Intern {
	
	@Pattern(regexp="[A-Za-z' ]+[A-Za-z]", message="Your name can only have letters and must be the full name")
	private String name;
	
	@Id
	@Column(name="EMAIL")
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}", message="Invalid email Address.")
	private String email;
	
	public Intern() {
		// TODO Auto-generated constructor stub
	}

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
	
	public String toString(){
		return this.name;
	}

}
