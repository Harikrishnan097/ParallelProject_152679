package com.ewallet.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import com.ewallet.bean.AccountDetails;
import com.ewallet.bean.CustomerDetails;
import com.ewallet.service.DataValidation;
import com.ewallet.service.EwalletService;

public class EwalletUI {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice;
		int choice2;
		DataValidation validate = new DataValidation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		do {
			System.out.println(ANSI_PURPLE + "-------------------------------------------------------" + ANSI_RESET);
			System.out.println(ANSI_PURPLE + "                WELCOME TO EWALLET PAYMENT ($)" + ANSI_RESET);
			System.out.println(ANSI_PURPLE + "-------------------------------------------------------" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   1.CREATE ACCOUNT" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   2.LOGIN" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   3.LOGOUT" + ANSI_RESET);

			System.out.println(ANSI_PURPLE + "ENTER YOUR CHOICE" + ANSI_RESET);
			choice = in.nextInt();
			switch (choice) {

			case 1:
				EwalletService service = new EwalletService();
				CustomerDetails details = new CustomerDetails();
				AccountDetails adetails = new AccountDetails();

				try {
					System.out.println("ENTER THE CUSTOMER NAME(should not be empty)");
					String customer_name = br.readLine();
					System.out.println("ENTER THE GENDER(male/female)");
					String gender = br.readLine();
					System.out.println("ENTER THE AGE(should not be empty)");
					String age = br.readLine();
					System.out.println("ENTER THE ADHAAR NO(12 digit should be there)");
					String adhaar_number = br.readLine();
					System.out.println("ENTER THE PHONE NUMBER(10 digit number should be there)");
					String phone_number = br.readLine();
					System.out.println("ENTER THE EMAIL ID(exmple:abc@gmail.com)");
					String email_id = br.readLine();
					System.out.println("ENTER THE USERNAME");
					String username = br.readLine();
					System.out.println("ENTER THE PASSWORD");
					String password = br.readLine();
					int account_number = rand.nextInt(900000) + 100000;
					details.setCustomer_name(customer_name);
					details.setGender(gender);
					details.setAge(Integer.parseInt(age));
					details.setEmail_id(email_id);
					details.setPhone_number(phone_number);
					details.setAdhaar_number(adhaar_number);
					details.setUsername(username);
					details.setPassword(password);

					adetails.setAccount_no(account_number);
					adetails.setDetails(details);
					boolean isValidName = validate.validatecustomername(customer_name);
					boolean isValidGender = validate.validategender(gender);
					boolean isValidAge = validate.validateage(Integer.parseInt(age));
					boolean isValidEmail = validate.validateemailid(email_id);
					boolean isValidPhoneNumber = validate.validatephonenumber(phone_number);
					boolean isValidAdhaarNumber = validate.validateadhaarnumber(adhaar_number);

					if (isValidAdhaarNumber && isValidAge && isValidEmail && isValidGender && isValidName
							&& isValidPhoneNumber) {
						/*
						 * if (service.createAccount(adetails) == 1) {
						 * System.out.println("Sucessfully the account is created....");
						 * System.out.println("YOUR ACCOUNT NO IS " + ANSI_PURPLE + account_number +
						 * ANSI_RESET);
						 * 
						 * } else { System.out.println("not created");}
						 */
						service.createAccount(adetails);

					} else {
						System.out.println("invalid data");
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case 2:
				EwalletService service2 = new EwalletService();

				try {

					System.out.println("ENTER YOUR USER NAME TO LOGIN");
					String username;
					username = br.readLine();
					System.out.println("ENTER YOUR   PASSWORD");
					String password = br.readLine();
					if (service2.login(username, password) == 1) {
						do {
							System.out.println(ANSI_PURPLE + "-------------------------------------------------------"
									+ ANSI_RESET);
							System.out.println(ANSI_BLUE + "3:DEPOSIT" + ANSI_RESET);
							System.out.println(ANSI_BLUE + "4:WITHDRAW" + ANSI_RESET);
							System.out.println(ANSI_BLUE + "5:SHOW BALANCE" + ANSI_RESET);
							System.out.println(ANSI_BLUE + "6:FUND TRANSFER" + ANSI_RESET);
							System.out.println(ANSI_BLUE + "7:PRINT TRANSACTIONS" + ANSI_RESET);
							System.out.println(ANSI_BLUE + "8:LOGOUT" + ANSI_RESET);
							System.out.println(ANSI_PURPLE + "-------------------------------------------------------"
									+ ANSI_RESET);

							System.out.println("ENTER THE CHOICE");
							choice2 = in.nextInt();
							switch (choice2) {

							case 3:
								EwalletService service3 = new EwalletService();

								System.out.println("ENTER THE AMOUNT TO DEPOSIT");
								double amount = in.nextDouble();
								/*
								 * System.out.println("ENTER THE USER NAME TO LOGIN"); username = br.readLine();
								 * System.out.println("ENTER THE PASSWORD"); password = br.readLine();
								 */

								/* if (service3.login(username, password) == 1) { */
								if (service3.deposit(amount) == 1) {
									System.out.println("AMOUNT SUCESSFULLY DEPOSITED");
								}

								// }
								else {
									System.out.println("INVALID USERNAME OR LOGIN");
								}

								break;
							case 4:

								EwalletService service4 = new EwalletService();
								System.out.println("ENTER THE AMOUNT TO WITHDRAW");
								double wamount = in.nextDouble();
								/*
								 * System.out.println("ENTER THE USER NAME TO LOGIN"); username = br.readLine();
								 * System.out.println("ENTER THE PASSWORD"); password = br.readLine();
								 */

								// if (service4.login(username, password) == 1) {
								if (service4.withdraw(wamount) == 0) {
									System.out.println("AMOUNT IS WITHDRAWN");
								}
								// }
								break;
							case 5:
								int account_number;
								EwalletService service5 = new EwalletService();
								/*
								 * System.out.println("enter the account number"); int account_number =
								 * in.nextInt();
								 */
								service5.showbalance();

								break;
							case 6:
								EwalletService service6 = new EwalletService();
								System.out.println(" ENTER THE ACCOUNT NUMBER OF RECEIVER ACCOUNT");
								account_number = in.nextInt();
								System.out.println("ENTER THE AMOUNT TO TRANSFER");
								double famount = in.nextDouble();
								/*
								 * System.out.println("ENTER THE USER NAME TO LOGIN"); username = br.readLine();
								 * System.out.println("ENTER THE PASSWORD"); password = br.readLine();
								 */
								// if (service6.login(username, password) == 1) {
								if (service6.fundtransfer(account_number, famount) == 0) {
									System.out.println("AMOUNT TRANSFERED.....");
								} else {
									System.out.println("AMOUNT NOT TRANSFERED");
								}
								// }

								break;

							case 7:
								EwalletService service7 = new EwalletService();
								System.out.println("THE TRANSACTIONS ARE");
								service7.printtransaction();
								break;

							case 8:
								break;

							}

						} while (choice2 != 8);

					} else {
						System.out.println("INVALID USERNAME OR PASSWORD");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case 3:
				break;

			}
		} while (choice != 3);

	}

}
