package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.ExpenseCategoryNewButton;
import pages.ExpenseCategoryPage;
import pages.LoginPage;

public class ExpenseCategoryNewButtonTest extends Base {
	LoginPage LoginPageObj;
	ExpenseCategoryPage ExpenseCategoryPageObj;
	ExpenseCategoryNewButton ExpenseCategoryNewButtonObj;
	
	@Test(description="Click new button and verify",groups= {"SmokeTest"},priority=0)
	public void verifyClickNewButton() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ExpenseCategoryPageObj=new ExpenseCategoryPage(driver);
		ExpenseCategoryNewButtonObj=new ExpenseCategoryNewButton(driver);
		LoginPageObj.loginToApp();
		ExpenseCategoryPageObj.clickExpenseCategory();
		ExpenseCategoryNewButtonObj.clickNewButton();
	}
	@Test(description="Check and verify color of save button",groups= {"RegressionTest"},priority=1)
	public void verifySaveButtonColor() throws IOException, InterruptedException {
		LoginPageObj=new LoginPage(driver);
		ExpenseCategoryPageObj=new ExpenseCategoryPage(driver);
		ExpenseCategoryNewButtonObj=new ExpenseCategoryNewButton(driver);
		LoginPageObj.loginToApp();
		ExpenseCategoryPageObj.clickExpenseCategory();
		ExpenseCategoryNewButtonObj.clickNewButton();
		ExpenseCategoryNewButtonObj.saveButtonColor();
	}
	@Test(description="Provide expense category title and save",groups= {"RegressionTest"},priority=1)
	public void verifyClickSaveWithTitle() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ExpenseCategoryPageObj=new ExpenseCategoryPage(driver);
		ExpenseCategoryNewButtonObj=new ExpenseCategoryNewButton(driver);
		LoginPageObj.loginToApp();
		ExpenseCategoryPageObj.clickExpenseCategory();
		ExpenseCategoryNewButtonObj.clickNewButton();
		ExpenseCategoryNewButtonObj.clickSaveWithTitle();
	}
	@Test(priority=3)
	public void verifyDuplicateTitleValidation() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ExpenseCategoryPageObj=new ExpenseCategoryPage(driver);
		ExpenseCategoryNewButtonObj=new ExpenseCategoryNewButton(driver);
		LoginPageObj.loginToApp();
		ExpenseCategoryPageObj.clickExpenseCategory();
		ExpenseCategoryNewButtonObj.clickNewButton();
		ExpenseCategoryNewButtonObj.duplicateTitleValidation(ExpenseCategoryNewButton.inputText);
	}

}
