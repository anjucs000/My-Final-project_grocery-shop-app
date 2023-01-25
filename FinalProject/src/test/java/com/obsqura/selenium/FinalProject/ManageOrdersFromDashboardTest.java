package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOrdersFromDashboard;
import pages.SideMenuItemsNavigation;

public class ManageOrdersFromDashboardTest extends Base {
	LoginPage object1;
	ManageOrdersFromDashboard object2;
	
	@Test
	public void verifyStatusColumnOptionColors() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageOrdersFromDashboard(driver);
		object1.loginToApp();
		object2.checkStatusColumnOptionColors();
	}
}

