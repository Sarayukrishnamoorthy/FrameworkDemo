package com.tekarch.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility{


	public static WebDriver driver = null;
	
	/*
	 * launch browser parameters: browserName Supported browsers are chrome,
	 * firefox, IE
	 */
	public void launchBrowser(String sBrowser){
		
		// open specific browser
		if(sBrowser.startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(sBrowser.startsWith("fi")) {
			driver = new FirefoxDriver();
		} else if (sBrowser.startsWith("in")) {
			driver = new InternetExplorerDriver();
		}

		// implicit wait for all elements.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //maximize the window
		driver.manage().window().maximize(); 
		
	}
	
	public void udfOpenUrl(String url) {
		//driver.get("https://qa-tekarch.firebaseapp.com/"); 
		driver.get(url); 
	}

	public void quitBrowser(){
		driver.quit();
	}
	public void udfSendKeys(WebElement ele, String sData) {
		ele.clear();
		ele.sendKeys(sData);
	}
	public void udfClick(WebElement ele) {
		ele.click();
	}
	public String udfGetKeys(WebElement ele) {
		return ele.getText();
	}
	public void waitForVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void udfAlertDismiss() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch(Exception e) {
			
		}
	}
	
	public String jsGetText(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String sText = (String) jse.executeScript("return arguments[0].value;",ele);
		
		return sText;
	}
	
	public void udfAlertAccept() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch(Exception e) {
			
		}
	}
	public boolean udfIsAlertPresent() {
		boolean bIsPresent = false;
		try {
			driver.switchTo().alert();
			bIsPresent = true;
		} catch(Exception e) {
			
		}
		
		return bIsPresent;
	}
	
	public void udfClear(WebElement ele) {
		if (ele.isEnabled())
			ele.clear();
	}
}
