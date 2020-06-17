package com.guru99bank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageObjects.LoginPageObjs;
import com.guru99bank.pageObjects.NewCustomerPageObjs;

public class TC_NewCustomer_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPageObjs lpo = new LoginPageObjs(driver);
		lpo.setUserName(username);
		log.info("UserName is Entered");
		lpo.setPassword(password);
		log.info("Passsword is Entered");
		lpo.clickSubmit();
		Thread.sleep(3000);

		NewCustomerPageObjs ncpo = new NewCustomerPageObjs(driver);
		ncpo.clickAddNewCustomer();

		log.info("Providing Customer Details....");
		ncpo.custName("Mahesh");
		ncpo.custGender("male");
		ncpo.custDOB("04", "11", "1991");
		Thread.sleep(5000);
		ncpo.custAddress("INDIA");
		ncpo.custCity("HYD");
		ncpo.custState("KA");
		ncpo.custPinNo("500098");
		ncpo.custTelePhoneNo("9738043697");

		String email = randomString() + "@gmail.com";
		ncpo.custEmailId(email);
		ncpo.custPassword("abcdef");
		ncpo.custSubmit();
		Thread.sleep(3000);

		log.info("Customer Registration Validation Started....");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) 
		{
			Assert.assertTrue(true);
			log.info("Test Case-TC_NewCustomer-003 is Passed....");
		}
		else 
		{
			log.info("Test Case-TC_NewCustomer-003 is Failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
