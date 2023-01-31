package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageExpenseFromDashboard;
import pages.MobileSliderPage;

public class MobileSliderTest extends Base{
	LoginPage object1;
	MobileSliderPage object2;
	@Test
	public void verifyCheckColumnHeaders() throws IOException {
		object1=new LoginPage(driver);
		object2=new MobileSliderPage(driver);
		object1.loginToApp();
		object2.checkColumnHeaders();
	}
	@Test
	public void verifyCheckButtonColors() throws IOException {
		object1=new LoginPage(driver);
		object2=new MobileSliderPage(driver);
		object1.loginToApp();
		object2.checkButtonColors();
	}
	@Test
	public void VerifyAddNewSlider() throws IOException {
		object1=new LoginPage(driver);
		object2=new MobileSliderPage(driver);
		object1.loginToApp();
		object2.addNewSlider();
	}

}
