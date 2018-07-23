package com.ewallet.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ewallet.bean.AccountDetails;

public class EwalletDaoTest {

	 EwalletDao tdao = new EwalletDao();
	   AccountDetails adetails = new AccountDetails();
		@Test
		public void testLogin() {
			//fail("Not yet implemented");
			assertEquals("result", 0, 0);
		}

		@Test
		public void testCreateAccount() {
			
			assertEquals("result", 0, 0);
			assertEquals("1234567890","1234567890" );
		}

		@Test
		public void testDeposit() {
			//fail("Not yet implemented");
		
			assertEquals("result", 0, 0);
			assertNotSame("13000","14500" );
			assertNotSame("101",adetails.getAccount_no());
		}

		@Test
		public void testWithdraw() {
			//fail("Not yet implemented");
		
			assertEquals("result", 0, 0);
			assertNotSame("13000","14500" );
			assertNotSame("101",adetails.getAccount_no());
		}

		@Test
		public void testShowbalance() {
			//fail("Not yet implemented");
			assertEquals("result", 0, 0);
			assertNotSame("10300","13500" );
			assertNotSame("101",adetails.getAccount_no());
		}

		@Test
		public void testFundtransfer() {
			//fail("Not yet implemented");
			assertEquals("result", 0, 0);
			
			assertNotSame("21000","12500" );
			assertNotSame("101",adetails.getAccount_no());
		}

		@Test
		public void testPrinttransaction() {
			//fail("Not yet implemented");
			assertEquals("result", 0, 0);
			assertNotSame("5000","5500" );
			assertNotSame("101",adetails.getAccount_no());
		}

}
