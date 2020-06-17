package com.guru99bank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPageObjs 
{
	WebDriver ldriver;	
	public NewCustomerPageObjs(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	public void clickAddNewCustomer() 
	{
		lnkAddNewCustomer.click();		
	}

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	public void custName(String cname) 
	{
		txtCustomerName.sendKeys(cname);	
	}

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;
	public void custGender(String cgender) 
	{
		rdGender.click();
	}

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;
	public void custDOB(String mm,String dd,String yy) 
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);		
	}

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;
	public void custAddress(String caddress) 
	{
		txtaddress.sendKeys(caddress);
	}

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;
	public void custCity(String ccity) 
	{
		txtcity.sendKeys(ccity);
	}

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;
	public void custState(String cstate) 
	{
		txtstate.sendKeys(cstate);
	}

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;
	public void custPinNo(String cpinno) 
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;
	public void custTelePhoneNo(String ctelephoneno) 
	{
		txttelephoneno.sendKeys(ctelephoneno);
	}

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;
	public void custEmailId(String cemailid) 
	{
		txtemailid.sendKeys(cemailid);
	}

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;
	public void custPassword(String cpassword) 
	{
		txtpassword.sendKeys(cpassword);
	}

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	public void custSubmit()
	{
		btnSubmit.click();
	}
}
