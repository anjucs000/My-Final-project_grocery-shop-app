package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageExpenseFromDashboard;

public class ManageExpenseFromDashboardTest extends Base {
	LoginPage object1;
	ManageExpenseFromDashboard object2;
	@Test
	public void verifyTodaysDateInDateField() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageExpenseFromDashboard(driver);
		object1.loginToApp();
		object2.checkTodaysDateInDateField();
	}
	@Test
	public void verifyCreateNewExpenseRecord() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageExpenseFromDashboard(driver);
		object1.loginToApp();
		object2.createNewExpenseRecord();
	}
	@Test
	public void verifySelectDateFromCalendar() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageExpenseFromDashboard(driver);
		object1.loginToApp();
		object2.createExpenseRecordByselectDateFromCalendar();
	}

}
