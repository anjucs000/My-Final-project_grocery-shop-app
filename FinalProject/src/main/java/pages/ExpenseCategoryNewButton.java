package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PageUtility;

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
		
		@FindBy(xpath="//ul[@class='pagination pagination-sm m-0 float-right']//child::li")
		private List<WebElement> pagination;
		
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//child::tr")
		private List<WebElement> tableRows;
		
		@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
		private WebElement duplicateEntryMessage;
		
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
		private WebElement successEntryMessage;
		
		
		public void clickNewButton() {
			Boolean flag;
			PageUtility.clickOnElement(newButton);
			Assert.assertTrue(titleField.isDisplayed(), "Title field is not visible in the page");
			Assert.assertTrue(saveButtton.isDisplayed(), "Save button is not visible in the page");
			Assert.assertTrue(resetButton.isDisplayed(), "Reset button is not visible in the page");
			flag=true;
			Assert.assertTrue(flag, "Required elements in the page is not displaying");
		}
		public void clickSaveWithoutTitle() {
			String titleFieldValue,actualAlert,expectedAlert="Please fill out this field";
			titleFieldValue=PageUtility.getElementText(titleField);
			Assert.assertTrue(titleFieldValue.isEmpty(), "The title field is not empty");
			PageUtility.clickOnElement(saveButtton);
			actualAlert=driver.switchTo().alert().getText();
			Assert.assertEquals(actualAlert, expectedAlert, "Actual and expected Alerts are not equal");
		}
		public void clickSaveWithTitle() {
			String titleFieldValue,inputText="Test",actualAlert,expectedAlertForSuccessEntry="Expense Category Created Successfully",titleFromTable;
			String expectedAlertForDuplicateEntry="Category already exists.";
			int totalPageSize=0,totalRowsInPage=0;
			titleFieldValue=PageUtility.getElementText(titleField);
			Assert.assertTrue(titleFieldValue.isEmpty(), "The title field is not empty");
			PageUtility.enterText(titleField, inputText);
			PageUtility.clickOnElement(saveButtton);
			totalPageSize=pagination.size();
			int rowSize=tableRows.size();
			for(int i=0;i<totalPageSize;i++) {
				//for(int j=1;j<rowSize;j++)
				for(WebElement data:tableRows) 
				{
					titleFromTable=data.getText();
					//actualAlert=driver.switchTo().alert().getText();
					if(titleFromTable.contains(inputText)){
							actualAlert=duplicateEntryMessage.getText();
							Assert.assertEquals(actualAlert, expectedAlertForDuplicateEntry, "The input category is not available in the table");
					}
					else if(!titleFromTable.contains("Title")){
						actualAlert=successEntryMessage.getText();
						Assert.assertEquals(actualAlert, expectedAlertForSuccessEntry, "The input category is available in the table");
					}
				}
			}
				
		}
	

}
