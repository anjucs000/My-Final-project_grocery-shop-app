package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewspage {
	
	public WebDriver driver;
	public ManageNewspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")
	private WebElement manageContent;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//parent::li")
	private WebElement manageNews;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement newButton;
	
	@FindBy(xpath="//textarea[@id='news']")
	private WebElement enterTheNewsField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr")
	private List<WebElement> tableRows;
	
	public void enterAndSaveNews() throws IOException {
		String actualAlertMessage,expectedAlertMessage=ExcelUtility.getTestData(0, 1, constants.Constants.TESTDATAFILE, "Manage_News");
		PageUtility.clickOnElement(manageContent);
		WaitUtility.waitForElement(driver, manageNews);
		WaitUtility.waitForElementClickable(driver, manageNews);
		PageUtility.clickOnElement(manageNews);
		PageUtility.clickOnElement(newButton);
		PageUtility.enterText(enterTheNewsField, FakerUtility.generateSingleData());
		PageUtility.clickOnElement(saveButton);
		actualAlertMessage=successAlert.getText();
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage), "Saving news failed");
	}
	
}
