package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage LoginPageObj;
	ManageDeliveryBoyPage ManageDeliveryBoyPageObj;
	
	@Test(dataProvider="NewDeliveryBoyRecord",dataProviderClass=com.obsqura.dataproviderUtility.DataProviderUtility.class,description="Click new button and verify",groups= {"RegressionTest"},priority=0)
	public void VerifyCreateNewDeliveryBoy(String name,String email,String phoneNumber,String address) throws IOException {
		LoginPageObj=new LoginPage(driver);
		ManageDeliveryBoyPageObj=new ManageDeliveryBoyPage(driver);
		LoginPageObj.loginToApp();
		ManageDeliveryBoyPageObj.createNewDeliveryBoy(name, email, phoneNumber, address);
	}

}
