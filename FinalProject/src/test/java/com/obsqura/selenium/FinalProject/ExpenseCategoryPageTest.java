package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ExpenseCategoryPage;
import pages.LoginPage;

public class ExpenseCategoryPageTest extends Base{
	LoginPage object1;
	ExpenseCategoryPage object2;
	@Test
	public void verifyClickExpenseCategory() throws IOException {
		object1=new LoginPage(driver);
		object2=new ExpenseCategoryPage(driver);
		object1.loginToApp();
		object2.clickExpenseCategory();
		
	}
}
