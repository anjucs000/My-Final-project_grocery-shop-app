package com.obsqura.selenium.FinalProject;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewspage;

public class ManageNewsTest extends Base{
	LoginPage object1;
	ManageNewspage object2;
	
/*	@Test
	public void VerifyEnterAndSaveNews() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageNewspage(driver);
		object1.loginToApp();
		object2.enterAndSaveNews();
	}*/
	
	@Test
	public void updateNewsAndSave() throws IOException {
		object1=new LoginPage(driver);
		object2=new ManageNewspage(driver);
		object1.loginToApp();
		object2.updateNewsAndSave();
	}

}
