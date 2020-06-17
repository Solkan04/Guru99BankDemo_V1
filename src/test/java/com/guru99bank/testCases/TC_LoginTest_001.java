package com.guru99bank.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageObjects.LoginPageObjs;


public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(baseURL);
		LoginPageObjs lpo=new LoginPageObjs(driver);
		lpo.setUserName(username);
		lpo.setPassword(password);
		lpo.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
