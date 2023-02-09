package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageOrdersFromDashboard;

public class ManageOrdersFromDashboardTTest extends Base {
	LoginPage LoginPageObj;
	ManageOrdersFromDashboard ManageOrdersFromDashboardObj;
	
	@Test(description="Verify status column options colors",groups= {"SmokeTest"},priority=0)
	public void verifyStatusColumnOptionColors() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageOrdersFromDashboardObj=new ManageOrdersFromDashboard(driver);
		LoginPageObj.loginToApp();
		ManageOrdersFromDashboardObj.checkStatusColumnOptionColors();
	}
	
	@Test(description="Click view button and verify",groups= {"RegressionTest"},priority=1)
	public void verifyClickViewButton() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageOrdersFromDashboardObj=new ManageOrdersFromDashboard(driver);
		LoginPageObj.loginToApp();
		ManageOrdersFromDashboardObj.checkStatusColumnOptionColors();
		ManageOrdersFromDashboardObj.clickViewButton();
	}
	@Test(description="Click back button from view screen and verify",groups= {"SmokeTest"},priority=2)
	public void verifyClickBackButtonFromViewScreen() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageOrdersFromDashboardObj=new ManageOrdersFromDashboard(driver);
		LoginPageObj.loginToApp();
		ManageOrdersFromDashboardObj.checkStatusColumnOptionColors();
		ManageOrdersFromDashboardObj.clickViewButton();
		ManageOrdersFromDashboardObj.clickBackButtonFromViewScreen();
	}
	@Test(description="Delete order and verify",groups= {"SmokeTest"},priority=3)
	public void verifyDeleteOrder() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageOrdersFromDashboardObj=new ManageOrdersFromDashboard(driver);
		LoginPageObj.loginToApp();
		ManageOrdersFromDashboardObj.checkStatusColumnOptionColors();
		ManageOrdersFromDashboardObj.deleteOrder();
	}
}

