package com.tekarch.testcases;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tekarch.pageobjects.LoginPO;
import com.tekarch.utilities.TestBase;


public class LoginTC extends TestBase {
	Logger log = Logger.getLogger(getClass().getName());
	public LoginPO loginpo;
	
	@BeforeTest
	public void setUpPageObjects() {
		browserUtil.udfOpenUrl(commonUtil.getUrl());
		loginpo = new LoginPO(driver);
	}
	
	@Test(priority = 1,dataProvider="getInvalidCredentials")
	public void checkInvalidLogin(String sUsername, String sPwd) throws Exception{
		log.info("checkInvalidLogin Method "+ sUsername +" "+ sPwd);
		loginpo.login(sUsername, sPwd);
		if (browserUtil.udfIsAlertPresent())
			browserUtil.udfAlertAccept();
		assertEquals(loginpo.isLoginSuccess(), false);
	}
	
	@DataProvider(name="getInvalidCredentials")
	public Object[][] invalidLoginCredentials() {
		return new Object[][] {{commonUtil.getUserName(), commonUtil.getinvalidPassword()}};
	}

	
	@Test(priority = 2,dataProvider="getValidCredentials",groups="Sanity")
	public void checkValidLogin(String sUsername, String sPwd) throws Exception{
		log.info("checkValidLogin Method "+ sUsername +" "+ sPwd);
		loginpo.login(sUsername, sPwd);
		assertEquals(loginpo.isLoginSuccess(), true);
	}
	
	@Test(priority = 3)
	public void checkLogout() {
		if (loginpo.isLoginSuccess()) {
			loginpo.Logout();
		}
	}
	
	@DataProvider(name="getValidCredentials")
	public Object[][] validLoginCredentials() {
		return new Object[][] {{commonUtil.getUserName(), commonUtil.getPassword()}};
	}
}
