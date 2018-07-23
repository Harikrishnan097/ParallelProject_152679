package com.ewallet.bean;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerDetailsTest {
	CustomerDetails cd = new CustomerDetails();
	@Test
	public void testGetCustomer_name() {
		//fail("Not yet implemented");
		cd.setCustomer_name("abc");
		assertEquals("abc", cd.getCustomer_name());
		assertNotEquals("bcd", cd.getCustomer_name());
	}

	@Test
	public void testGetAge() {
		//fail("Not yet implemented");
		cd.setAge(22);
		assertEquals(22, cd.getAge());
		assertNotEquals(21, cd.getAge());
	}

	@Test
	public void testGetGender() {
		//fail("Not yet implemented");
		cd.setGender("male");
		assertEquals("male", cd.getGender());
	}

	@Test
	public void testGetPhone_number() {
		//fail("Not yet implemented");
		cd.setPhone_number("1234");
	assertNotEquals(0, cd.getPhone_number());
	}

	@Test
	public void testGetAdhaar_number() {
		//fail("Not yet implemented");
		cd.setAdhaar_number("1000");
		assertNotEquals(0, cd.getAdhaar_number());
	}

	@Test
	public void testGetEmail_id() {
		//fail("Not yet implemented");
		cd.setEmail_id("k@k.com");
		assertEquals("k@k.com", cd.getEmail_id());
		assertNotEquals("kkk", cd.getEmail_id());
	}

	@Test
	public void testGetPassword() {
		//fail("Not yet implemented");
		cd.setPassword("1234");
		assertNotEquals("k@k.com", cd.getPassword());
		
	}

	@Test
	public void testGetUsername() {
		//fail("Not yet implemented");
		cd.setPassword("user");
		assertNotEquals("123", cd.getPassword());
	}

}
