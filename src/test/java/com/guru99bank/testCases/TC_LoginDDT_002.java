package com.guru99bank.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageObjects.LoginPageObjs;
import com.guru99bank.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException 
	{
		LoginPageObjs lp = new LoginPageObjs(driver);
		lp.setUserName(user);
		log.info("UserName Entered");
		lp.setPassword(pwd);
		log.info("Password Entered");
		lp.clickSubmit();
		log.info("Clicked on Submit in Login Page");
		if (isAlertPresent() == true) 
		{
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login failed");
		}
		else 
		{
			Assert.assertTrue(true);
			log.info("Login Passed");
			lp.clickLogout();
			log.info("Clicked on Log Out");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() // user defined method created to check alert is presetn or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException 
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/guru99bank/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) 
		{
			for (int j = 0; j < colcount; j++) 
			{
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return logindata;
	}
}
