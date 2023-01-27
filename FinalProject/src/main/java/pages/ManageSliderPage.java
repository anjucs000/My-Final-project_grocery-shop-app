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

public class ManageSliderPage {
	public WebDriver driver;
	public ManageSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']//parent::li")
	private WebElement manageSliderSidemenu;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@id='link']")
	private WebElement linkField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider' and text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home']//parent::li[@class='breadcrumb-item']")
	private WebElement homeButton;
	
	@FindBy(xpath="//button[@class='close']")
	private WebElement closeButtonInAlert;
	
	public void addSlider() {
		PageUtility.clickOnElement(manageSliderSidemenu);
		PageUtility.clickOnElement(newButton);
		PageUtility.enterText(linkField, FakerUtility.generateSingleData());
		PageUtility.clickOnElement(saveButton);
		Assert.assertTrue(closeButtonInAlert.isDisplayed(), "New Slider information not saved");
	}
	public void navigateBackToHome() throws IOException {
		String actualUrl,expectedUrl=ExcelUtility.getTestData(0, 1, constants.Constants.TESTDATAFILE, "Manage_Slider");
		PageUtility.clickOnElement(homeButton);
		actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual and Expected URLs are not equal");
	}
	

}
