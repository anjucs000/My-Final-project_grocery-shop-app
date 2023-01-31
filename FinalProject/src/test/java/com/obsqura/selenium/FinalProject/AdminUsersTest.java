package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.MobileSliderPage;

public class AdminUsersTest extends Base{
	LoginPage object1;
	AdminUsersPage object2;
	@Test
	public void verifyCheckColumnHeaders() throws IOException {
		object1=new LoginPage(driver);
		object2=new AdminUsersPage(driver);
		object1.loginToApp();
		object2.checkUsernameAndPasswordFieldEmpty();
	}
	
	@Test
	public void verifyCreateNewUser() throws IOException {
		object1=new LoginPage(driver);
		object2=new AdminUsersPage(driver);
		object1.loginToApp();
		object2.checkUsernameAndPasswordFieldEmpty();
		object2.createNewUser();
	}
	@Test
	public void verifyResetData() throws IOException {
		object1=new LoginPage(driver);
		object2=new AdminUsersPage(driver);
		object1.loginToApp();
		object2.checkUsernameAndPasswordFieldEmpty();
		object2.resetData();
	}

}
