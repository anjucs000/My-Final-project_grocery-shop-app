package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.ExpenseCategoryPage;
import pages.LoginPage;

public class ExpenseCategoryPageTest extends Base{
	LoginPage LoginPageObj;
	ExpenseCategoryPage ExpenseCategoryPageObj;
	@Test(description="Click expense category and verify",groups= {"RegressionTest"},priority=0)
	public void verifyClickExpenseCategory() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ExpenseCategoryPageObj=new ExpenseCategoryPage(driver);
		LoginPageObj.loginToApp();
		ExpenseCategoryPageObj.clickExpenseCategory();
		
	}
}
