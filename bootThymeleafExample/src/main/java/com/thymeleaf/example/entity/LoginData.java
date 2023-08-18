package com.thymeleaf.example.entity;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import jakarta.validation.constraints.AssertTrue;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;

public class LoginData {

	@NotNull(message = "Username can't empty.")
	@Size(min = 3, max = 6, message = "Username length should be between 3 to 6 characters.")
	private String userName;

	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter valid email id.")
	private String email;

	@AssertTrue
	private boolean isChecked;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + ", isChecked=" + isChecked + "]";
	}

}
