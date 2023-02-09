package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.FakerUtility;
import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement adminUsersButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameField;

	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//select[@id='user_type']")
	private WebElement userTypeField;
	
	@FindBy(xpath="(//button[@type='submit' and @class='btn btn-block-sm btn-danger'])[2]")
	private WebElement saveButton;
	
	@FindBy(xpath="(//a[text()='Reset'])[2]")
	private WebElement resetButton;
	
	@FindBy(xpath="//button[@class='close']")
	private WebElement closeButtonInAlert;
	
	public void checkUsernameAndPasswordFieldEmpty() {
		String userName,passWord;
		boolean flag=false;
		PageUtility.clickOnElement(adminUsersButton);
		PageUtility.clickOnElement(newButton);
		userName=userNameField.getText();
		passWord=passwordField.getText();
		if(userName.isEmpty()&& passWord.isEmpty()) {
			flag=true;
		}
		Assert.assertTrue(flag, "Username and Password fields are not empty");
	}
	public void createNewUser() {
		Select userType=new Select(userTypeField);
		PageUtility.enterText(userNameField, FakerUtility.generateUserName());
		PageUtility.enterText(passwordField, FakerUtility.generateUserName());
		userType.selectByIndex(FakerUtility.generateIndexforAdminUser());
		PageUtility.clickOnElement(saveButton);
		Assert.assertTrue(PageUtility.checkFieldDisplayed(closeButtonInAlert), "User creation failed");
	}
	public void resetData() {
		Select userType=new Select(userTypeField);
		PageUtility.enterText(userNameField, FakerUtility.generateUserName());
		PageUtility.enterText(passwordField, FakerUtility.generateUserName());
		userType.selectByIndex(FakerUtility.generateIndexforAdminUser());
		PageUtility.clickOnElement(resetButton);
		Assert.assertFalse(PageUtility.checkFieldDisplayed(saveButton), "Reset data failed");
	}
}
