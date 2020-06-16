package com.tekarch.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tekarch.pageobjects.CalculatorPO;
import com.tekarch.pageobjects.LoginPO;
import com.tekarch.utilities.TestBase;

public class CalculatorTC extends TestBase {

	Logger log = Logger.getLogger(getClass().getName());
	public CalculatorPO calpo;
	
	@BeforeTest
	public void setUpPageObjects() {
		browserUtil.udfOpenUrl(commonUtil.getUrl());
	}
	@Test(priority=1)
	public void login() throws Exception {
		LoginPO loginpo = new LoginPO(driver);
		loginpo.login(commonUtil.getUserName(), commonUtil.getPassword());
	}
	
	@Test(priority=2,groups = "Sanity")
	public void openCalculatorTab() throws Exception {
		calpo = new CalculatorPO(driver);
		calpo.openCalculatorTab();
	}
	
	
	@Test(priority=3,groups = "Sanity")
	public void checkAddition() {
		int result = calpo.additionOperation();
		log.info("Addition Result "+ result);
		Assert.assertSame(calpo.getResultValue(), result);
	}
	
	@Test(priority=4,groups = "Sanity")
	public void checkSubtraction() {
		int result = calpo.subtractionOperation();
		log.info("Subtraction Result "+ result);
		Assert.assertSame(calpo.getResultValue(), result);
	}
	
	@Test(priority=5,groups = "Sanity")
	public void checkMultiplication() {
		int result = calpo.multiplicationOperation();
		log.info("Multiplication Result "+ result);
		Assert.assertSame(calpo.getResultValue(), result);
	}
	
	@Test(priority=6,groups = "Sanity")
	public void checkDivision() {
		int result = calpo.divisionOperation();
		log.info("Division Result "+ result);
		Assert.assertSame(calpo.getResultValue(), result);
	} 
}
