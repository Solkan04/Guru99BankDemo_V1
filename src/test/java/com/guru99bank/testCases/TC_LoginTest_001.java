package com.guru99bank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageObjects.LoginPageObjs;


public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		LoginPageObjs lpo=new LoginPageObjs(driver);
		lpo.setUserName(username);
		log.info("Entered Username");
		lpo.setPassword(password);
		log.info("Entered Password");
		lpo.clickSubmit();
		log.info("Clicked on Submit in Login Page");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("Login Test is Passed");
		}
		else
		{
			captureScreen(driver, "TC_LoginTest_001");
			Assert.assertTrue(false);
			log.info("Login Test is Failed");
		}
	}
}
