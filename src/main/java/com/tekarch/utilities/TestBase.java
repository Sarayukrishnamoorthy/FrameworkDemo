package com.tekarch.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.tekarch.reports.ExtendReportManager;

@Listeners(com.tekarch.listeners.TestListener.class)
public class TestBase {

	public static CommonUtility commonUtil = new CommonUtility();
	public static BrowserUtility browserUtil = new BrowserUtility();
	public static ExtendReportManager extendReport = new ExtendReportManager();
	public static WebDriver driver;
	
	@BeforeSuite
	public void initDependencies() throws Exception {
		// property file loading
		commonUtil.loadPropertyFiles(commonUtil.sTestDataFilePath);
		commonUtil.loadPropertyFiles(commonUtil.sConfigFilePath);
		commonUtil.loadLog4jProperty(commonUtil.sLog4jFilePath);
		// clear previous tests screen shots in reports
		extendReport.deleteAndCreateReportFolder();
		
		browserUtil.launchBrowser(commonUtil.getBrowserName());
		driver = BrowserUtility.driver;
	}
	@AfterSuite
	public void closeDependencies() {
		browserUtil.quitBrowser();
	}
}
