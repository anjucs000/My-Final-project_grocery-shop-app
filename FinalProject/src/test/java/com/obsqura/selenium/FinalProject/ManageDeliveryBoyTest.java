package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.selenium.FinalProjectBase.Base;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage object1;
	ManageDeliveryBoyPage object2;
	
	@Test(dataProvider="NewDeliveryBoyRecord",dataProviderClass=com.obsqura.dataproviderUtility.DataProviderUtility.class)
	public void VerifyCreateNewDeliveryBoy(String name,String email,String phoneNumber,String address) throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageDeliveryBoyPage(driver);
		object1.loginToApp();
		object2.createNewDeliveryBoy(name, email, phoneNumber, address);
	}

}
