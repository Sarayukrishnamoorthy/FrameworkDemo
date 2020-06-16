package com.tekarch.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

public class LoginPO extends TestBase {

	Logger log = Logger.getLogger(getClass().getName());
	
	@FindBy(id = "email_field")
	WebElement emailField;
	@FindBy(xpath = "//input[@placeholder='Password...']")
	WebElement pwdField;
	@FindBy(xpath= "//button[contains(text(),'Login to Account')]")
	WebElement loginButton;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutTab;
	
	public LoginPO(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void login(String sUserName, String sPwd) throws Exception {
		log.info("login clicked");
		browserUtil.waitForVisibility(emailField);
		browserUtil.udfSendKeys(emailField, sUserName);
		browserUtil.udfSendKeys(pwdField, sPwd);
		browserUtil.udfClick(loginButton);
	}
	public boolean isLoginPage() {
		boolean isSuccess = false;
		try {
			browserUtil.waitForVisibility(emailField);
			if (emailField.isDisplayed()) {
				isSuccess = true;
			}
		} catch (Exception e) {
			
		}
		return isSuccess;
	}
	
	public boolean isLoginSuccess() {
		boolean isSuccess = false;
		try {
			browserUtil.waitForVisibility(logoutTab);
			if (logoutTab.isDisplayed()) {
				isSuccess = true;
			}
		} catch (Exception e) {
			
		}
		return isSuccess;
	}
	public void Logout() {
		log.info("logout clicked");
		if (isLoginSuccess()) {
			browserUtil.udfClick(logoutTab);
			browserUtil.waitForVisibility(emailField);
		}
	}
}
