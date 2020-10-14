package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCust{
	WebDriver driver;
	public AddCust(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(xpath="//input[@value='f']")
	@CacheLookup
	WebElement rdgender;
	
	@FindBy(xpath="//input[@name='dob']")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(xpath="//input[@name='state']")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(xpath="//input[@name='pinno']")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	@CacheLookup
	WebElement txtmobilenum;
	
	@FindBy(xpath="//input[@name='emailid']")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement btnsubmit;
	
	public void clickAddNewCust() {
		lnkNewCustomer.click();
	}
	
	public void custName(String custname) {
		txtCustomerName.sendKeys(custname);
	}
	
	public void custgender(String gender) {
		rdgender.click();
	}
	
	public void custdob(String dd,String mm,String yy) {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String address) {
		txtaddress.sendKeys(address);
	}
	
	public void custcity(String city) {
		txtcity.sendKeys(city);
	}
	
	public void custstate(String state) {
		txtstate.sendKeys(state);
	}
	
	public void custpinno(String pinno) {
		txtpinno.sendKeys(String.valueOf(pinno));
	}
	
	public void custmobilenum(String mobilenum) {
		txtmobilenum.sendKeys(mobilenum);
	}
	
	public void custmailid(String mailid) {
		txtemailid.sendKeys(mailid);
	}
	
	public void custpwd(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	
	public void clickonSubmit() {
		btnsubmit.click();
	}
}
