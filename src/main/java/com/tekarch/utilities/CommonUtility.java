package com.tekarch.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class CommonUtility {
	
	public String sTestDataFilePath = System.getProperty("user.dir")+"/src/main/resources/testdata.properties";
	public String sConfigFilePath = System.getProperty("user.dir")+"/src/main/java/com/tekarch/properties/config.properties";
	public String sLog4jFilePath =System.getProperty("user.dir")+"/src/main/java/com/tekarch/properties/log4j.properties";
	
	Properties property  = new Properties();
	FileInputStream file = null;
	public void loadPropertyFiles(String sPath) {
		try {
		 file = new FileInputStream(sPath);
		property.load(file);
		System.getProperties().putAll(property);
		
		}catch(Exception a) {
		}
	}
	public void loadLog4jProperty(String sPath) {
		try {
			FileInputStream file = new FileInputStream(sPath);
			property.load(file);
			PropertyConfigurator.configure(property);
		
		}catch(Exception a) {
		}
	}
	
	public String getUserName() {
		return System.getProperty("username");
	}
	public String getPassword() {
		return System.getProperty("password");
	}
	public String getinvalidPassword() {
		return System.getProperty("invalidpwd");
	}
	
	public String getEnvironment() {
		return System.getProperty("Environment");
	}
	public String getBrowserName() {
		return System.getProperty("Browser");
	}
	public String getUrl() {
		return System.getProperty("url");
	}
}
