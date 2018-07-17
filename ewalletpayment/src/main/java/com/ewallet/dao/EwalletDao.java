package com.ewallet.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ewallet.bean.AccountDetails;

public class EwalletDao {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	double balance;int flag=0;
	AccountDetails  acdetails = new AccountDetails();
  public static  Map<Integer,AccountDetails> map1 = new HashMap<Integer, AccountDetails>();
 public static  List<String> transactions= new ArrayList<String>();
	
	public int login(String username,String password)
	{
		for(Integer key:map1.keySet()) {
			
			acdetails=map1.get(key)	;
			if(acdetails.getDetails().getUsername().equals(username)&&(acdetails.getDetails().getPassword().equals(password)))
					{
				return 1;
				        
				
					}
		}
	
		return 0;
	}
	public int createAccount(AccountDetails adetails) {
		
		map1.put(adetails.getAccount_no(), adetails);
/*
    	for (Integer key : map1.keySet()) {
    	    System.out.println("Key = " + key);
    	}

    	
    	for (AccountDetails value : map1.values()) {
    	    System.out.println("value = " + value.getAccount_no()+""+value.getBalance());
    	}*/
		
		return 1;
		
		
	}
	
	public int deposit(double amount) {
		
		balance=acdetails.getBalance()+amount;
		acdetails.setBalance(balance);
		
		//System.out.println(" your balance is"+acdetails.getBalance());
		//System.out.println(acdetails.getBalance());
		String deposit=" THE AMOUNT"+amount+"IS DEPOSITED";
		transactions.add(deposit);
		
		return 1;
		
		
	}
	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		
		if(amount<acdetails.getBalance()) {
		balance=acdetails.getBalance()-amount;
		acdetails.setBalance(balance);		
		//System.out.println(" your balance is"+balance);
		System.out.println(acdetails.getBalance());
	   String withdraw="THE AMOUNT  "+amount+"IS WITHDRAWN";
     	transactions.add(withdraw);
		}else
		{
			System.out.println("amount provided is more than balance");
		}
		return 0;
	}
	public void showbalance(int account_number)
	{
    
		for(Integer key:map1.keySet()) {
			
			   acdetails=map1.get(key)	;
			   if(acdetails.getAccount_no()==account_number) {
				   System.out.println("YOUR BALANCE IS"+acdetails.getBalance());
			   }
			
		}
		
		
		
	}
	public int fundtransfer(int account_number, double amount) {
		// TODO Auto-generated method stub
if(acdetails.getBalance()>amount) {
		for(Integer key:map1.keySet()) {
			
			   acdetails=map1.get(key)	;
			   if(acdetails.getAccount_no()==account_number) {
				  balance= acdetails.getBalance()+amount;
				  acdetails.setBalance(balance);
				  flag=1;
			   }
			   if(flag==0) {
				   
				   balance=acdetails.getBalance()-amount;
					acdetails.setBalance(balance);	
					String transfer="THE AMOUNT   "+amount+"  IS TRANSFERED TO THIS ACCOUNT NUMBER   "+  account_number+ "   ";
					transactions.add(transfer);
						
			   }
			
		}}
else
{
	System.err.println("Cant transfer the amount the amount you enter is more thant balance");
}
		
		
		
		return 0;
	}
	public List printtransaction() {
		return transactions;
		// TODO Auto-generated method stub
		
	}
	
	
}
