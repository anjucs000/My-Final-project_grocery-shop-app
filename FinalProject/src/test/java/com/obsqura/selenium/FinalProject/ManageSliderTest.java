package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageSliderPage;

public class ManageSliderTest extends Base {
	LoginPage object1;
	ManageSliderPage object2;
	
	@Test
	public void verifyAddSlider() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageSliderPage(driver);
		object1.loginToApp();
		object2.addSlider();
	}
	@Test
	public void verifyNavigateBackToHome() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageSliderPage(driver);
		object1.loginToApp();
		object2.addSlider();
		object2.navigateBackToHome();
	}
	

}
