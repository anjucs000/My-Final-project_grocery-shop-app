package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageLocationPage;

public class ManageLocationTest extends Base{
	
	LoginPage LoginPageObj;
	ManageLocationPage ManageLocationPageObj;
	
	@Test(description="Check if location and elivery charge fields displayed",groups= {"RegressionTest"},priority=0)
	public void verifyLocationAndDeliveryChargeFieldsDisplayedOrNot() throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageLocationPageObj=new ManageLocationPage(driver);
		LoginPageObj.loginToApp();
		ManageLocationPageObj.locationAndDeliveryChargeFieldsDisplayedOrNot();;
	}
	@Test(description="Create new location and save",groups= {"SmokeTest"},priority=1)
	@Parameters({"countryValue","location","deliveryCharge"})
	public void verifycreateNewLocation(String countryValue,String location,String deliveryCharge) throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageLocationPageObj=new ManageLocationPage(driver);
		LoginPageObj.loginToApp();
		ManageLocationPageObj.locationAndDeliveryChargeFieldsDisplayedOrNot();
		ManageLocationPageObj.createNewLocation(countryValue, location, deliveryCharge);
	}

}
