package com.ewallet.bean;

public class CustomerDetails {
	private String customer_name;
	private int age;
	private String gender;
	private String phone_number;
	private String adhaar_number;

	public String getAdhaar_number() {
		return adhaar_number;
	}

	private String email_id;
	private String password;

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setAdhaar_number(String adhaar_number) {
		this.adhaar_number = adhaar_number;
	}

	private String username;

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
