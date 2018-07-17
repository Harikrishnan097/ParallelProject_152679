package com.ewallet.bean;

public class AccountDetails {
	private int account_no;
	private double balance;
	public CustomerDetails details;
	public CustomerDetails getDetails() {
		return details;
	}
	public void setDetails(CustomerDetails details) {
		this.details = details;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
