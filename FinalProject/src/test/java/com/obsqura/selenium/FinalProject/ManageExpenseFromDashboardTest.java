package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageExpenseFromDashboard;

public class ManageExpenseFromDashboardTest extends Base {
	LoginPage LoginPageObj;
	ManageExpenseFromDashboard ManageExpenseFromDashboardObj;
	@Test(description="Check if the date field have today's date by default",groups= {"SmokeTest"},priority=1)
	public void verifyTodaysDateInDateField() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageExpenseFromDashboardObj=new ManageExpenseFromDashboard(driver);
		LoginPageObj.loginToApp();
		ManageExpenseFromDashboardObj.checkTodaysDateInDateField();
	}
	@Test(description="Create a new expense record and save",groups= {"RegressionTest"},priority=0)
	public void verifyCreateNewExpenseRecord() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageExpenseFromDashboardObj=new ManageExpenseFromDashboard(driver);
		LoginPageObj.loginToApp();
		ManageExpenseFromDashboardObj.createNewExpenseRecord();
	}
	@Test(description="Select another date from calendar and save",groups= {"RegressionTest"},priority=2)
	public void verifySelectDateFromCalendar() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageExpenseFromDashboardObj=new ManageExpenseFromDashboard(driver);
		LoginPageObj.loginToApp();
		ManageExpenseFromDashboardObj.createExpenseRecordByselectDateFromCalendar();
	}

}
