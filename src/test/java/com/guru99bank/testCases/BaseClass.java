package com.guru99bank.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public String baseURL="http://demo.guru99.com/v4/";
	public String username="mngr265426";
	public String password="AzUdUde";
	public static WebDriver driver;
	public static Logger log;

	@BeforeClass
	public void setUp()
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		log=Logger.getLogger("Guru99BankDemo_V1");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
