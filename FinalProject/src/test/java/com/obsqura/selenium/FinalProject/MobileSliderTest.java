package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageExpenseFromDashboard;
import pages.MobileSliderPage;

public class MobileSliderTest extends Base{
	LoginPage LoginPageObj;
	MobileSliderPage MobileSliderPageObj;
	@Test(description="Verify headers of table",groups= {"RegressionTest"},priority=0)
	public void verifyCheckColumnHeaders() throws IOException {
		LoginPageObj=new LoginPage(driver);
		MobileSliderPageObj=new MobileSliderPage(driver);
		LoginPageObj.loginToApp();
		MobileSliderPageObj.checkColumnHeaders();
	}
	@Test(description="Verify colors of buttons",groups= {"SmokeTest"},priority=1)
	public void verifyCheckButtonColors() throws IOException {
		LoginPageObj=new LoginPage(driver);
		MobileSliderPageObj=new MobileSliderPage(driver);
		LoginPageObj.loginToApp();
		MobileSliderPageObj.checkButtonColors();
	}
	@Test(description="Add a new slider and save",groups= {"SmokeTest"},priority=2)
	public void VerifyAddNewSlider() throws IOException {
		LoginPageObj=new LoginPage(driver);
		MobileSliderPageObj=new MobileSliderPage(driver);
		LoginPageObj.loginToApp();
		MobileSliderPageObj.addNewSlider();
	}

}
