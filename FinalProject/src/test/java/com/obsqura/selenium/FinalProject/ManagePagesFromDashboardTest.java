package com.obsqura.selenium.FinalProject;


import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagePagesFromDashBoardPage;

public class ManagePagesFromDashboardTest extends Base{
	LoginPage object1;
	ManagePagesFromDashBoardPage object2;
	
	@Test
	public void verifySearchInvalidData() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManagePagesFromDashBoardPage(driver);
		object1.loginToApp();
		object2.searchInvalidData();
	}
	@Test
	public void verifySearchValidData() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManagePagesFromDashBoardPage(driver);
		object1.loginToApp();
		object2.searchValidData();
		
	}

}
