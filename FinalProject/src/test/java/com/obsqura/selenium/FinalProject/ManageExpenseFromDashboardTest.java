package com.obsqura.selenium.FinalProject;

import org.testng.annotations.Test;

import pages.ManageExpenseFromDashboard;

public class ManageExpenseFromDashboardTest extends Base {
	
	ManageExpenseFromDashboard object1;
	@Test
	public void verifyTodaysDateInDateField() {
		object1=new ManageExpenseFromDashboard(driver);
		object1.checkTodaysDateInDateField();
	}

}
