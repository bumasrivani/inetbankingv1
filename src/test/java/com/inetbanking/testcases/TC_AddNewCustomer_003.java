package com.inetbanking.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCust;
import com.inetbanking.pageobjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws Exception {
		AddCust addcust=new AddCust(driver); 
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("provided username");
		lp.setPassword(password);
		logger.info("provide password");
		lp.clickSubmit();

		Thread.sleep(1000);
		addcust.clickAddNewCust();
		logger.info("clicked on new customer");
		addcust.custName("uma");
		addcust.custgender("f");
		addcust.custdob("20", "10", "99");
		addcust.custaddress("DNo 1234 XYZ Colony");
		addcust.custcity("hyd");
		addcust.custstate("TS");
		addcust.custpinno("523011");
		addcust.custmobilenum("9874563210");
		addcust.custmailid(randomString().concat("@gmail.com"));
		addcust.custpwd("abcdef");
		logger.info("entered all customer details");
		addcust.clickonSubmit();
		logger.info("validation started");
		Thread.sleep(1000);
		
		System.out.println("after validatin started");
		if(isAlertPresent()==true) {
			captureScreen(driver, "addNewCustomer");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info(driver.switchTo().alert().getText());
		}else {
			
			Assert.assertTrue(true);
			logger.info("Doesn't find any alert");
		}
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Test Case passed");
		}else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test Case failed");
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
