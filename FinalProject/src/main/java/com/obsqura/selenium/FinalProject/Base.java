package com.obsqura.selenium.FinalProject;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.ScreenshotUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Base {
	public WebDriver driver;
	public Properties prop,prop1;
	public FileInputStream fs,fs1;
	public ScreenshotUtility scrshot;   
		
		@BeforeMethod
		public void initialiseBrowser() {
			prop=new Properties();
			try {
				fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.CONFIGfILE);
			} catch (Exception e) {
			}
			try {
				prop.load(fs);
			} catch (Exception e) {
			}
			prop1=new Properties();
			try {
				fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.TESTDATAFILE);
			} catch (Exception e) {
			}
			try {
				prop1.load(fs);
			} catch (Exception e) {
			}
		}
	@BeforeMethod
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+constants.Constants.CHROMEDRIVER);
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void browserQuit(ITestResult iTestResult) throws IOException
	{
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenshotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}