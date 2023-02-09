package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageExpenseOptions;

public class ManageExpenseOptionsTest extends Base {
	LoginPage LoginPageObj;
	ManageExpenseOptions ManageExpenseOptionsObj;
	@Test(description="Verify expense manage options",groups= {"SmokeTest"},priority=0)
	public void verifyExpenseManageOptions() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageExpenseOptionsObj=new ManageExpenseOptions(driver);
		LoginPageObj.loginToApp();
		ManageExpenseOptionsObj.clickManageExpense();
	}
	

}
