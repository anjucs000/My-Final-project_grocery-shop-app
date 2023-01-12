package com.obsqura.selenium.FinalProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Base {
	public WebDriver driver;
	public Properties prop,prop1;
	public FileInputStream fs,fs1;
		
		@BeforeMethod
		public void initialiseBrowser() {
			prop=new Properties();
			try {
				fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.CONFIGfILE);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				prop.load(fs);
			} catch (Exception e) {
				// TODO: handle exception
			}
			prop1=new Properties();

			try {
				fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.TESTDATAFILE);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				prop1.load(fs);
			} catch (Exception e) {
				// TODO: handle exception
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
	/*@AfterMethod
	public void closeBrowser() {
		driver.close();
	}*/
}