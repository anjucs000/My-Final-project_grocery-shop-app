package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageSliderPage;

public class ManageSliderTest extends Base {
	LoginPage LoginPageObj;
	ManageSliderPage ManageSliderPageObj;
	
	@Test(description="Add a new slider and save",groups= {"SmokeTest","RegressionTest"},priority=0)
	public void verifyAddSlider() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageSliderPageObj=new ManageSliderPage(driver);
		LoginPageObj.loginToApp();
		ManageSliderPageObj.addSlider();
	}
	@Test(description="Navigate back to home page",groups= {"SmokeTest"},priority=1)
	public void verifyNavigateBackToHome() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageSliderPageObj=new ManageSliderPage(driver);
		LoginPageObj.loginToApp();
		ManageSliderPageObj.addSlider();
		ManageSliderPageObj.navigateBackToHome();
	}
	

}
