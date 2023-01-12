package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageExpenseOptions;

public class ManageExpenseOptionsTest extends Base {
	ManageExpenseOptions object1;
	LoginPage object2;
	@Test
	public void verifyExpenseManageOptions() throws IOException {
		object1=new ManageExpenseOptions(driver);
		object2=new LoginPage(driver);
		object2.loginToApp();
		object1.clickManageExpense();
	}
	

}
