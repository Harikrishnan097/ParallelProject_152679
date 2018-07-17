package com.ewallet.service;

import java.util.List;

import com.ewallet.bean.AccountDetails;

public interface IEwalletService {
   
	int login(String username,String password);
	int createAccount(AccountDetails adetails);
	int deposit(double amount);
	int withdraw(double amount);
	int fundtransfer(int account_number,double amount);
	List printtransaction();
}
