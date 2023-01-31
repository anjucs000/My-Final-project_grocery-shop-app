package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.FakerUtility;
import utilities.PageUtility;

public class ManageLocationPage {
		public WebDriver driver;
		public ManageLocationPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class='small-box-footer']")
		private WebElement manageLocation;
		
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/add']")
		private WebElement newButton;
		
		@FindBy(xpath="//select[@id='country_id']")
		private WebElement countryField;
		
		@FindBy(xpath="//select[@id='st_id']")
		private WebElement stateField;
		
		@FindBy(xpath="//input[@id='location']")
		private WebElement locationField;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement saveButton;
		
		@FindBy(xpath="//button[@class='close']")
		private WebElement alertCloseButton;
		
		@FindBy(xpath="//input[@id='delivery']")
		private WebElement deliveryChargeField;
		
		public void locationAndDeliveryChargeFieldsDisplayedOrNot() {
			PageUtility.clickOnElement(manageLocation);
			PageUtility.clickOnElement(newButton);
			Assert.assertTrue(PageUtility.checkFieldDisplayed(locationField), "Location field is not displayed");
			Assert.assertTrue(PageUtility.checkFieldDisplayed(locationField), "Location field is not displayed");
		}
		
		public void createNewLocation(String countryValue,String location,String deliveryCharge) {
			Select state=new Select(stateField);
			Select country=new Select(countryField);
			country.selectByVisibleText(countryValue);
			state.selectByIndex(FakerUtility.generateIndex());
			PageUtility.enterText(locationField, location);
			PageUtility.enterText(deliveryChargeField, deliveryCharge);
			PageUtility.clickOnElement(saveButton);
			Assert.assertTrue(PageUtility.checkFieldDisplayed(alertCloseButton), "New Location saving failed");

		}
	

}
