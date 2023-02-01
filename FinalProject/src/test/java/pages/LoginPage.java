package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInButton;
	
	public void loginToApp() throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(0, 0, constants.Constants.TESTDATAFILE, "TC1");
		PageUtility.enterText(userNameField, ExcelUtility.getTestData(0, 0, constants.Constants.TESTDATAFILE, "Login"));
		PageUtility.enterText(passwordField, ExcelUtility.getTestData(1, 0, constants.Constants.TESTDATAFILE, "Login"));
		PageUtility.clickOnElement(signInButton);
		actualTitle=driver.getTitle();
		WaitUtility.waitForTitleContains(driver, actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Actual and Expected titles are not equal");
	}
}
