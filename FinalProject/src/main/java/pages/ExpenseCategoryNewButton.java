package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ExpenseCategoryNewButton {
	public WebDriver driver;
	
	public ExpenseCategoryNewButton(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
		private WebElement newButton;
		
		@FindBy(xpath="//input[@id='name']")
		private WebElement titleField;
		
		@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']//parent::div[@class='card-footer center']")
		private WebElement saveButtton;
		
		@FindBy(xpath="//a[@class='btn btn-default btn-fix']//parent::div[@class='card-footer center']")
		private WebElement resetButton;
		
		public static String inputText=FakerUtility.generateSingleData();
		
		public void clickNewButton() {
			Boolean flag;
			PageUtility.clickOnElement(newButton);
			Assert.assertTrue(titleField.isDisplayed(), "Title field is not visible in the page");
			Assert.assertTrue(saveButtton.isDisplayed(), "Save button is not visible in the page");
			Assert.assertTrue(resetButton.isDisplayed(), "Reset button is not visible in the page");
			flag=true;
			Assert.assertTrue(flag, "Required elements in the page is not displaying");
		}
		public void saveButtonColor() throws InterruptedException, IOException {
			
			String actualColorOfSaveButton;
			String expectedColorOfSaveButton=ExcelUtility.getTestData(2, 1, constants.Constants.TESTDATAFILE, "Expense_Category");
			WaitUtility.waitForElement(driver, saveButtton);
			actualColorOfSaveButton=PageUtility.getBackgroundColorCSSValue(saveButtton);
			Assert.assertEquals(actualColorOfSaveButton, expectedColorOfSaveButton, "Actual and Expected color mismatches");
		}
		public void clickSaveWithTitle() throws IOException {
			boolean flag = true;
			PageUtility.enterText(titleField, inputText);
			PageUtility.clickOnElement(saveButtton);
			if(titleField.isDisplayed()) {
				flag=false;
			}
			Assert.assertFalse(flag, "The data cannot be saved");
		}
		public void duplicateTitleValidation(String inputText) {
			boolean flag=false;
			String titleFieldText;
			PageUtility.enterText(titleField, inputText);
			PageUtility.clickOnElement(saveButtton);
			titleFieldText=titleField.getAttribute("value");
			if(titleFieldText.equalsIgnoreCase(inputText)) {
				flag=true;
			}
			Assert.assertTrue(flag, "Data saved,duplicate entry validation failed");
		}
		
}

