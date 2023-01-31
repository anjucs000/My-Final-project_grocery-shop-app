package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")
	private WebElement manageDeliveryBoyButton;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement nameField;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNumberField;
	
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement addressField;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[@class='close']")
	private WebElement closeButtonInAlert;
	
	public void createNewDeliveryBoy(String name,String email,String phoneNumber,String address) {
		PageUtility.ScrollByHighValue(driver);
		WaitUtility.waitForVisibilityOfWebelement(driver, manageDeliveryBoyButton);
		PageUtility.clickOnElement(manageDeliveryBoyButton);
		WaitUtility.waitForVisibilityOfWebelement(driver, newButton);
		PageUtility.clickOnElement(newButton);
		WaitUtility.waitForVisibilityOfWebelement(driver, nameField);
		WaitUtility.waitForVisibilityOfWebelement(driver, emailField);
		PageUtility.enterText(nameField, name);
		PageUtility.enterText(emailField, email);
		PageUtility.enterText(phoneNumberField, phoneNumber);
		PageUtility.enterText(addressField, address);
		PageUtility.enterText(userNameField, FakerUtility.generateUserName());
		PageUtility.ScrollBy(driver);
		PageUtility.enterText(passwordField, FakerUtility.generateUserName());
		PageUtility.clickOnElement(saveButton);
		Assert.assertTrue(closeButtonInAlert.isDisplayed(), "New delivery boy save failed");
	}
}
