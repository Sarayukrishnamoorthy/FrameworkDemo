package com.tekarch.reports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tekarch.utilities.BrowserUtility;


public class ExtendReportManager {
	public static ExtentReports reports;
	public static ExtentTest testLog;
	static String sReportName = "TekarchAutomationReport.html";
	static String sPathOfImage = System.getProperty("user.dir")+"//TekarchReport";
	public static ExtentReports createInstance() {
		String sPath = sPathOfImage + "//" + sReportName;
		reports = new ExtentReports(sPath);

		return reports;
	}
	public static String udfTakeScreenShot(String sScreenShotName) throws Exception{
		TakesScreenshot ts = (TakesScreenshot)BrowserUtility.driver; 
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(sPathOfImage + "//"+sScreenShotName+".png");
		FileUtils.copyFile(Source, dest);
		
		return sPathOfImage;
	}

	public void deleteAndCreateReportFolder() {
		File extendReportDir = new File(sPathOfImage);
		if (extendReportDir.exists()) {
			extendReportDir.delete();
			extendReportDir.mkdir();
		} else {
			extendReportDir.mkdir();
		}
	}
}
