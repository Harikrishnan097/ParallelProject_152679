package com.ewallet.service;

public class DataValidation {

	public boolean validateadhaarnumber(String adhaar_number) {

		if ((adhaar_number.length() == 12)) {

			return true;

		}

		else {
			System.out.println("invalid adhaar number");
			return false;

		}
	}

	public boolean validateemailid(String email_id) {

		if (email_id.endsWith(".com")) {

			return true;
		}

		else {
			System.err.println("invalid email id");
			return false;

		}
	}

	public boolean validatephonenumber(String phone_number) {

		if (phone_number.length() == 10) {

			return true;
		}

		else {
			System.err.println("phone number invalid");
			return false;
		}
	}

	public boolean validatecustomername(String customer_name) {

		if (!(customer_name.isEmpty())) {

			return true;
		}

		else {
			System.out.println("Customer name is empty");
			return false;
		}
	}

	public boolean validategender(String gender) {

		if ((gender.equals("male")) || (gender.equals("female"))) {

			return true;
		} else {
			System.err.println("invalid gender entry");
			return false;
		}

	}

	public boolean validateage(int age) {

		if (age > 0) {

			return true;
		} else {
			System.err.println("invalid age entry");
			return false;
		}

	}
}
