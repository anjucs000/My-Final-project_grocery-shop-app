package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPageWithDataprovider {
	public WebDriver driver;
	public LoginPageWithDataprovider(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInButton;
	
	public void loginToApp(String userName,String password) throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(0, 0, constants.Constants.TESTDATAFILE, "TC1");
		PageUtility.enterText(userNameField,userName);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(signInButton);
		actualTitle=driver.getTitle();
		WaitUtility.waitForTitleContains(driver, actualTitle);
		SoftAssert softAssertObj = new SoftAssert();
		softAssertObj.assertEquals(actualTitle, expectedTitle, "Login failed,Invalid username and password");
		softAssertObj.assertAll();
	}
}
