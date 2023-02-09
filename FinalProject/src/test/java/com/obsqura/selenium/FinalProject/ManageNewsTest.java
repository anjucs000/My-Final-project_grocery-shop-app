package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageNewspage;

public class ManageNewsTest extends Base{
	LoginPage LoginPageObj;
	ManageNewspage ManageNewspageObj;
	
	@Test(description="Create new news record and save",groups= {"RegressionTest"},priority=0)
	public void VerifyEnterAndSaveNews() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageNewspageObj=new ManageNewspage(driver);
		LoginPageObj.loginToApp();
		ManageNewspageObj.enterAndSaveNews();
	}
}
