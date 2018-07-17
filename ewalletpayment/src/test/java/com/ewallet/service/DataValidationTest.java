package com.ewallet.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataValidationTest {
DataValidation validate = new DataValidation();
	@Test
	public void testValidateadhaarnumber() {
		//fail("Not yet implemented");
		assertEquals(true,validate.validateadhaarnumber("997209876543") );
		assertFalse(validate.validateadhaarnumber("9972"));
		assertTrue(validate.validateadhaarnumber("987654321147"));
		assertSame(true,validate.validateadhaarnumber("999876543213") );
		assertNotSame(false,validate.validateadhaarnumber("999876543213") );
		
	}

	@Test
	public void testValidateemailid() {
		//fail("Not yet implemented");
		assertEquals(true,validate.validateemailid("google@gmail.com") );
		assertNotNull(validate.validateemailid("google@gmail.com"));
		assertTrue(validate.validateemailid("goo@gmail.com"));
	}

	@Test
	public void testValidatephonenumber() {
		//fail("Not yet implemented");
		assertEquals(true,validate.validatephonenumber("9988776654"));
		assertFalse(validate.validatephonenumber("9333"));
		assertTrue(validate.validatephonenumber("7894561236"));
		assertNotNull(validate.validatephonenumber("9222415172"));
	}

	@Test
	public void testValidatecustomername() {
	//	fail("Not yet implemented");
		assertNotNull(validate.validatecustomername("capge"));
		assertTrue(validate.validatecustomername("customer1"));
	}

	@Test
	public void testValidategender() {
		//fail("Not yet implemented");
		assertNotNull(validate.validatecustomername("male"));
		assertTrue(validate.validatecustomername("female"));
		
		
	}

	@Test
	public void testValidateage() {
		//fail("Not yet implemented");
		assertEquals(true, validate.validateage(11));
		assertNotEquals(false, validate.validateage(12));
		//assertNotEquals(1, validate.validateage(11));
	}

}
