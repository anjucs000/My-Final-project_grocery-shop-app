package com.obsqura.selenium.FinalProject;


import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManagePagesFromDashBoardPage;

public class ManagePagesFromDashboardTest extends Base{
	LoginPage LoginPageObj;
	ManagePagesFromDashBoardPage ManagePagesFromDashBoardPageObj;
	
	@Test(description="Search a valid data from table",groups= {"RegressionTest"},priority=1)
	public void verifySearchInvalidData() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManagePagesFromDashBoardPageObj=new ManagePagesFromDashBoardPage(driver);
		LoginPageObj.loginToApp();
		ManagePagesFromDashBoardPageObj.searchInvalidData();
	}
	@Test(description="Search an invalid data from table",groups= {"SmokeTest"},priority=2)
	public void verifySearchValidData() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManagePagesFromDashBoardPageObj=new ManagePagesFromDashBoardPage(driver);
		LoginPageObj.loginToApp();
		ManagePagesFromDashBoardPageObj.searchValidData();
		
	}

}
