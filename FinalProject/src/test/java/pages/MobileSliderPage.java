package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class MobileSliderPage {
	public WebDriver driver;
	public MobileSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider' and @class='small-box-footer']")
	private WebElement mobileSliderButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr")
	private List<WebElement> tableRows;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Mobileslider/add']")
	private WebElement newButton;
	
	@FindBy(id="cat_id")
	private WebElement categoryField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[@class='close']")
	private WebElement closeButtonInAlert;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement editButton;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement deleteButton;
	
	public void checkColumnHeaders() throws IOException {
		String firstRow;
		boolean flag=false;
		PageUtility.ScrollByHighValue(driver);
		PageUtility.ScrollByHighValue(driver);
		WaitUtility.fluentWaitForElementToBeClickable(driver, mobileSliderButton);
		WaitUtility.fluentWaitForElementToBeClickable(driver, mobileSliderButton);
		PageUtility.clickOnElement(mobileSliderButton);
		List<WebElement> rowElements=tableRows;
		firstRow=rowElements.get(0).getText();
		if((firstRow.contains(ExcelUtility.getTestData(1, 0, constants.Constants.TESTDATAFILE, "Mobile_Slider"))) 
				&& (firstRow.contains(ExcelUtility.getTestData(1, 1, constants.Constants.TESTDATAFILE, "Mobile_Slider")))
				&& firstRow.contains(ExcelUtility.getTestData(1, 2, constants.Constants.TESTDATAFILE, "Mobile_Slider")))
				{
					flag=true;
				}
		Assert.assertTrue(flag, "First row of table does not contains Image,Status and Action");
	}
	
	public void checkButtonColors() throws IOException {
		String actualColorOfEditButton,actualColorOfDeleteButton,expectedColorOfEditButton,expectedColorOfDeleteButton;
		boolean flag=false;
		expectedColorOfEditButton=ExcelUtility.getTestData(2, 1, constants.Constants.TESTDATAFILE, "Mobile_Slider");
		expectedColorOfDeleteButton=ExcelUtility.getTestData(3, 1, constants.Constants.TESTDATAFILE, "Mobile_Slider");
		PageUtility.ScrollByHighValue(driver);
		WaitUtility.fluentWaitForElementToBeClickable(driver, mobileSliderButton);
		WaitUtility.fluentWaitForElementToBeClickable(driver, mobileSliderButton);
		PageUtility.clickOnElement(mobileSliderButton);
		WaitUtility.waitForVisibilityOfWebelement(driver, editButton);
		WaitUtility.waitForVisibilityOfWebelement(driver, deleteButton);
		actualColorOfEditButton=PageUtility.getBackgroundColorCSSValue(editButton);
		actualColorOfDeleteButton=PageUtility.getBackgroundColorCSSValue(deleteButton);
		if(actualColorOfEditButton.equals(expectedColorOfEditButton) && actualColorOfDeleteButton.equals(expectedColorOfDeleteButton)) {
			flag=true;
		}
		Assert.assertTrue(flag, "Actual and Expected colors are not equal");
	}
	public void addNewSlider() {
		PageUtility.ScrollByHighValue(driver);
		WaitUtility.fluentWaitForElementToBeClickable(driver, mobileSliderButton);
		WaitUtility.fluentWaitForElementToBeClickable(driver, mobileSliderButton);
		PageUtility.clickOnElement(mobileSliderButton);
		WaitUtility.waitForVisibilityOfWebelement(driver, newButton);
		PageUtility.clickOnElement(newButton);
		Select category=new Select(categoryField);
		category.selectByVisibleText("Grocery & Staples");
		PageUtility.clickOnElement(saveButton);
		Assert.assertTrue(PageUtility.checkFieldDisplayed(closeButtonInAlert), "New Slider save failed");
	}

}
