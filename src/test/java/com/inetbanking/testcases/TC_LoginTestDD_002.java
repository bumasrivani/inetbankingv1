package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginTestDD_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String uname,String pwd) throws  Exception {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("provided username");
		lp.setPassword(pwd);
		logger.info("provided password");
		lp.clickSubmit();
		Thread.sleep(1000);
		
		if(isAlertPresent()==true) {
			captureScreen(driver, "loginDDT");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
			logger.info("login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clicklogOut();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
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
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path= System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testdata\\testdata.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return logindata;
	}
	
	

}
