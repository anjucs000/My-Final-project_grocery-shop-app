package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.PushNotificationsPage;

public class PushNotificationsTest extends Base{
	LoginPage LoginPageObj;
	PushNotificationsPage PushNotificationsPageObj;
	
	@Test(description="Verify page title",groups= {"RegressionTest","SmokeTest"},priority=0)
	public void verifyCheckTitleOfPage() throws IOException {
		LoginPageObj=new LoginPage(driver);
		PushNotificationsPageObj=new PushNotificationsPage(driver);
		LoginPageObj.loginToApp();
		PushNotificationsPageObj.checkTitleOfPage();
	}
	@Test(description="Send notification and verify",groups= {"SmokeTest"},priority=1)
	public void verifySendNotification() throws IOException, InterruptedException {
		LoginPageObj=new LoginPage(driver);
		PushNotificationsPageObj=new PushNotificationsPage(driver);
		LoginPageObj.loginToApp();
		PushNotificationsPageObj.checkTitleOfPage();
		PushNotificationsPageObj.sendNotification();
	}
	@Test(description="Reset notification and verify",groups= {"RegressionTest"},priority=2)
	public void verifyResetNotification() throws IOException, InterruptedException {
		LoginPageObj=new LoginPage(driver);
		PushNotificationsPageObj=new PushNotificationsPage(driver);
		LoginPageObj.loginToApp();
		PushNotificationsPageObj.checkTitleOfPage();
		PushNotificationsPageObj.resetData();
	}
	

}
