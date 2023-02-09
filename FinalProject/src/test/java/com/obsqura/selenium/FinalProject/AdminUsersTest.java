package com.obsqura.selenium.FinalProject;

import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.selenium.FinalProjectBase.Base;
import pages.AdminUsersPage;
import pages.LoginPage;


public class AdminUsersTest extends Base{
	LoginPage LoginPageObj;
	AdminUsersPage AdminUsersPageObj;
	@Test(description="Verify column headers",groups= {"SmokeTest"},priority=0)
	public void verifyCheckColumnHeaders() throws IOException {
		LoginPageObj=new LoginPage(driver);
		AdminUsersPageObj=new AdminUsersPage(driver);
		LoginPageObj.loginToApp();
		AdminUsersPageObj.checkUsernameAndPasswordFieldEmpty();
	}
	@Test(description="Create a new user",groups= {"RegressionTest"},priority=1)
	public void verifyCreateNewUser() throws IOException {
		LoginPageObj=new LoginPage(driver);
		AdminUsersPageObj=new AdminUsersPage(driver);
		LoginPageObj.loginToApp();
		AdminUsersPageObj.checkUsernameAndPasswordFieldEmpty();
		AdminUsersPageObj.createNewUser();
	}
	@Test(description="Reset the data",groups= {"RegressionTest"},priority=2)
	public void verifyResetData() throws IOException {
		LoginPageObj=new LoginPage(driver);
		AdminUsersPageObj=new AdminUsersPage(driver);
		LoginPageObj.loginToApp();
		AdminUsersPageObj.checkUsernameAndPasswordFieldEmpty();
		AdminUsersPageObj.resetData();
	}
}
