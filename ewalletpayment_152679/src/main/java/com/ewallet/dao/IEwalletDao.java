package com.ewallet.dao;

import java.util.List;

import com.ewallet.bean.AccountDetails;

public interface IEwalletDao {
	AccountDetails login(String username, String password);

	int createAccount(AccountDetails adetails);

	int deposit(double amount);

	void showbalance();

	int fundtransfer(int account_number, double amount);

	void printtransaction();

}
