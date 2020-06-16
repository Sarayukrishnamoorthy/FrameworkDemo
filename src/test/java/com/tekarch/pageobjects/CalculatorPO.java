package com.tekarch.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

public class CalculatorPO extends TestBase{
Logger log = Logger.getLogger(getClass().getName());

public CalculatorPO(WebDriver driver) {
	TestBase.driver = driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath = "//a[contains(text(),'Calculator')]")
	WebElement calculatorTab;
	public void openCalculatorTab() {
		browserUtil.waitForVisibility(calculatorTab);
		browserUtil.udfClick(calculatorTab);
	}
	
	@FindBy(xpath= "//body//input[2]")
	WebElement numSeven;
	@FindBy(xpath="//body//input[5]")
	WebElement opAdd;
	@FindBy(xpath="//body//input[12]")
	WebElement numThree;
	@FindBy(xpath="//body//input[16]")
	WebElement equalTo;
	public int additionOperation() {
		browserUtil.waitForVisibility(numSeven);
		browserUtil.udfClick(numSeven);
		browserUtil.udfClick(opAdd);
		browserUtil.udfClick(numThree);
		browserUtil.udfClick(equalTo);
		return (7+3);
	}
	
	@FindBy(xpath="//body//input[9]")
	WebElement opSub;
	public int subtractionOperation() {
		browserUtil.waitForVisibility(numSeven);
		clearPreviousValue();
		browserUtil.udfClick(numSeven);
		browserUtil.udfClick(opSub);
		browserUtil.udfClick(numThree);
		browserUtil.udfClick(equalTo);
		
		return (7-3);
	}
	
	@FindBy(xpath="//body//input[13]")
	WebElement opMul;
	public int multiplicationOperation() {
		browserUtil.waitForVisibility(numSeven);
		clearPreviousValue();
		browserUtil.udfClick(numSeven);
		browserUtil.udfClick(opMul);
		browserUtil.udfClick(numThree);
		browserUtil.udfClick(equalTo);
		
		return (7*3);
	}
	
	@FindBy(xpath="//body//input[17]")
	WebElement opDiv;
	@FindBy(xpath="//body//input[4]")
	WebElement numNine;
	public int divisionOperation() {
		browserUtil.waitForVisibility(numNine);
		clearPreviousValue();
		browserUtil.udfClick(numNine);
		browserUtil.udfClick(opDiv);
		browserUtil.udfClick(numThree);
		browserUtil.udfClick(equalTo);
		
		return (9/3);
	}
	
	@FindBy(xpath="//input[@id='display']")
	WebElement displayValue;
	public int getResultValue() {
		String sResult =  browserUtil.jsGetText(displayValue);
		int iResult = Integer.parseInt(sResult);
		
		return iResult;
	}
	
	@FindBy(xpath="//input[@id='clearButton']")
	WebElement clearButton;
	public void clearPreviousValue() {
		browserUtil.udfClick(clearButton);
	}
}
