package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageLocationPage;

public class ManageLocationTest extends Base{
	
	LoginPage object1;
	ManageLocationPage object2;
	
	@Test
	public void verifyLocationAndDeliveryChargeFieldsDisplayedOrNot() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageLocationPage(driver);
		object1.loginToApp();
		object2.locationAndDeliveryChargeFieldsDisplayedOrNot();;
	}
	
	@Test
	@Parameters({"countryValue","location","deliveryCharge"})
	public void verifycreateNewLocation(String countryValue,String location,String deliveryCharge) throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageLocationPage(driver);
		object1.loginToApp();
		object2.locationAndDeliveryChargeFieldsDisplayedOrNot();
		object2.createNewLocation(countryValue, location, deliveryCharge);
	}

}
