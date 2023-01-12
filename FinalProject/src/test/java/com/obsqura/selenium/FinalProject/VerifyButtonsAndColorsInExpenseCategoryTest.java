package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ExpenseCategoryPage;
import pages.LoginPage;
import pages.VerifyButtonsAndColorsInExpenseCategory;

public class VerifyButtonsAndColorsInExpenseCategoryTest extends Base{
	LoginPage object1;
	ExpenseCategoryPage object2;
	VerifyButtonsAndColorsInExpenseCategory object3;
	@Test
	public void verifyFindBackgroundColor() throws IOException {
		object1=new LoginPage(driver);
		object2=new ExpenseCategoryPage(driver);
		object3=new VerifyButtonsAndColorsInExpenseCategory(driver);
		object1.loginToApp();
		object2.clickExpenseCategory();
		object3.findBackgroundColor();
	}
	

}
