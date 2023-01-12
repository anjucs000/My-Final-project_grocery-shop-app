package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginPageTest extends Base{
	LoginPage obj;
	@Test
	public void verifyLogin() throws IOException {
		obj=new LoginPage(driver);
		obj.loginToApp();
	}
}