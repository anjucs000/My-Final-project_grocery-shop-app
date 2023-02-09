package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;

public class LoginPageTest extends Base{
	LoginPage LoginPageObj;
	@Test(description="Login to app and verify title",groups= {"SmokeTest"},priority=0)
	public void verifyLogin() throws IOException {
		LoginPageObj=new LoginPage(driver);
		LoginPageObj.loginToApp();
	}
}