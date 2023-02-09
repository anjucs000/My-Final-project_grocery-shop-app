package com.obsqura.selenium.FinalProject;

import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.selenium.FinalProjectBase.Base;
import pages.LoginPageWithDataprovider;

public class LoginPageWithDataproviderTest extends Base{
	LoginPageWithDataprovider LoginPageWithDataproviderObj;
	@Test(dataProvider="LoginPage",dataProviderClass=com.obsqura.dataproviderUtility.DataProviderUtility.class,description="Create new delivery boy information",groups= {"SmokeTest"},priority=0)
	public void verifyLogin(String un,String pw) throws IOException {
		LoginPageWithDataproviderObj=new LoginPageWithDataprovider(driver);
		LoginPageWithDataproviderObj.loginToApp(un, pw);
	}
}