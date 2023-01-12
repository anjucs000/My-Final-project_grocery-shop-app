package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ExpenseCategoryNewButton;
import pages.ExpenseCategoryPage;
import pages.LoginPage;

public class ExpenseCategoryNewButtonTest extends Base {
	LoginPage object1;
	ExpenseCategoryPage object2;
	ExpenseCategoryNewButton object3;
	
	@Test(priority=0)
	public void verifyClickNewButton() throws IOException {
		object1=new LoginPage(driver);
		object2=new ExpenseCategoryPage(driver);
		object3=new ExpenseCategoryNewButton(driver);
		object1.loginToApp();
		object2.clickExpenseCategory();
		object3.clickNewButton();
	}
	@Test(priority=1)
	public void verifyClickSaveWithoutTitle() throws IOException {
		object1=new LoginPage(driver);
		object2=new ExpenseCategoryPage(driver);
		object3=new ExpenseCategoryNewButton(driver);
		object1.loginToApp();
		object2.clickExpenseCategory();
		object3.clickNewButton();
		object3=new ExpenseCategoryNewButton(driver);
		object3.clickSaveWithoutTitle();
	}
	@Test(priority=1)
	public void verifyClickSaveWithTitle() throws IOException {
		object1=new LoginPage(driver);
		object2=new ExpenseCategoryPage(driver);
		object3=new ExpenseCategoryNewButton(driver);
		object1.loginToApp();
		object2.clickExpenseCategory();
		object3.clickNewButton();
		object3.clickSaveWithTitle();
	}

}
