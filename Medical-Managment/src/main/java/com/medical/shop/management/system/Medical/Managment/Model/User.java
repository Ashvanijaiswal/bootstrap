package com.medical.shop.management.system.Medical.Managment.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class User {

	@NotEmpty(message = "userId  is required")
	private String user_id;
	@NotEmpty(message = "name is required")
	private String user_name;
	@NotEmpty(message = "Email is required")
	@Email
	private String email_id;
	@NotEmpty(message = "Phone number is required")
	//@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Mobile number is invalid")
	private String contact_number;
	@NotEmpty(message="password not be less than 8 character")
	@Size(min = 8, max = 64)
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String user_id, String user_name, String email_id, String contact_number, String password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email_id = email_id;
		this.contact_number = contact_number;
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", email_id=" + email_id + ", contact_number="
				+ contact_number + ", password=" + password + "]";
	}

}
