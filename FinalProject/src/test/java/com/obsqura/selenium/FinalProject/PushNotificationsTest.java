package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PushNotificationsPage;

public class PushNotificationsTest extends Base{
	LoginPage object1;
	PushNotificationsPage object2;
	
	@Test(groups= {"group1","group2"})
	public void verifyCheckTitleOfPage() throws IOException {
		object1=new LoginPage(driver);
		object2=new PushNotificationsPage(driver);
		object1.loginToApp();
		object2.checkTitleOfPage();
	}
	@Test(groups= {"group1"})
	public void verifySendNotification() throws IOException, InterruptedException {
		object1=new LoginPage(driver);
		object2=new PushNotificationsPage(driver);
		object1.loginToApp();
		object2.checkTitleOfPage();
		object2.sendNotification();
	}
	@Test(groups= {"group2"})
	public void verifyResetNotification() throws IOException, InterruptedException {
		object1=new LoginPage(driver);
		object2=new PushNotificationsPage(driver);
		object1.loginToApp();
		object2.checkTitleOfPage();
		object2.resetData();
	}
	

}
