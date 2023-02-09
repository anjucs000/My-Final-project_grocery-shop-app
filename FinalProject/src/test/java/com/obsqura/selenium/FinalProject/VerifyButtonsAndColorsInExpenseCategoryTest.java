package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.ExpenseCategoryPage;
import pages.LoginPage;
import pages.VerifyButtonsAndColorsInExpenseCategory;

public class VerifyButtonsAndColorsInExpenseCategoryTest extends Base{
	LoginPage LoginPageObj;
	ExpenseCategoryPage ExpenseCategoryPageObj;
	VerifyButtonsAndColorsInExpenseCategory VerifyButtonsAndColorsInExpenseCategoryObj;
	
	@Test(description="Check background color",groups= {"RegressionTest"},priority=0)
	public void verifyFindBackgroundColor() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ExpenseCategoryPageObj=new ExpenseCategoryPage(driver);
		VerifyButtonsAndColorsInExpenseCategoryObj=new VerifyButtonsAndColorsInExpenseCategory(driver);
		LoginPageObj.loginToApp();
		ExpenseCategoryPageObj.clickExpenseCategory();
		VerifyButtonsAndColorsInExpenseCategoryObj.findBackgroundColor();
	}
	

}
