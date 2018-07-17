package com.ewallet.service;

import java.util.List;

import com.ewallet.bean.AccountDetails;
import com.ewallet.dao.EwalletDao;

public class EwalletService {
	EwalletDao dao= new EwalletDao();
	
	public int login(String username,String password)
	{
		return dao.login(username,password); 
		
		
		
		
	}
	public int  createAccount(AccountDetails adetails) {
		
		
		
		return dao.createAccount(adetails);
	}
	public int deposit(double amount) {
		return dao.deposit(amount);
		
		
	}
	public int withdraw(double amount) {
		return dao.withdraw(amount);
	}
	public void showbalance(int account_number) {
		dao.showbalance(account_number);
	}
	public int fundtransfer(int account_number,double amount) {
		return dao.fundtransfer(account_number,amount);
		
	}
	public List printtransaction() {
		return dao.printtransaction();
	}
}
