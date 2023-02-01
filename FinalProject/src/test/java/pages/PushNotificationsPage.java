package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class PushNotificationsPage {
	public WebDriver driver;
	public PushNotificationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications']//parent::li")
	private WebElement pushNotificationButton;
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleField;
	
	@FindBy(xpath="//input[@id='description']")
	private WebElement descriptionField;
	
	@FindBy(xpath="//button[@name='create']")
	private WebElement sendButton;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	private WebElement resetButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	
	public void checkTitleOfPage() throws IOException {
		String expectedTitle=ExcelUtility.getTestData(0, 1, constants.Constants.TESTDATAFILE, "Push_Notifications"),actualTitle;
		PageUtility.clickOnElement(pushNotificationButton);
		actualTitle=driver.getTitle();
		WaitUtility.waitForTitleContains(driver, actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected "+expectedTitle);
	}
	
	public void sendNotification() throws InterruptedException, IOException {
		String actualAlert,expectedAlert=ExcelUtility.getTestData(1, 1, constants.Constants.TESTDATAFILE, "Push_Notifications");
		boolean flag=false;
		PageUtility.enterText(titleField, FakerUtility.generateSingleData());
		PageUtility.enterText(descriptionField,FakerUtility.generateSingleData());
		PageUtility.clickOnElement(sendButton);
		WaitUtility.waitForElement(driver, alert);
		actualAlert=alert.getText();
		if(actualAlert.contains(expectedAlert)) {
			flag=true;
		}
		Assert.assertTrue(flag,"Send notification failed");
	}
	public void resetData() throws InterruptedException {
		String title,description;
		boolean flag=false;
		PageUtility.enterText(titleField,FakerUtility.generateSingleData());
		PageUtility.enterText(descriptionField, FakerUtility.generateSingleData());
		PageUtility.clickOnElement(resetButton);
		title=titleField.getText();
		description=descriptionField.getText();
		if(title.isEmpty()&& description.isEmpty()) {
			flag=true;
		}
		Assert.assertTrue(flag,"Data reset failed");
	}
}
