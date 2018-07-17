package com.ewallet.bean;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountDetailsTest {
AccountDetails det = new AccountDetails();
	@Test
	public void testGetDetails() {
		//fail("Not yet implemented");
		assertNotSame(1, det.getDetails());
		assertEquals(null, det.getDetails());
		assertNull(det.getDetails());
		
	}

	@Test
	public void testGetAccount_no() {
		//fail("Not yet implemented");
		det.setAccount_no(1001);
		assertEquals(1001, det.getAccount_no());
		assertNotEquals(1, det.getAccount_no());

	}

	@Test
	public void testGetBalance() {
		//fail("Not yet implemented");
		det.setBalance(1000.0);
		
		assertNotEquals(1, det.getBalance());
		assertNotSame(1, det.getBalance());
		
		
	}

}
