package pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageExpenseFromDashboard {
	public WebDriver driver;
	public ManageExpenseFromDashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/expense']")
	private WebElement manageExpenseButton;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Expense/add']")
	private WebElement newButton;
	
	@FindBy(id="ex_date")
	private WebElement dateField;
	
	@FindBy(id="user_id")
	private WebElement userField;
	
	@FindBy(id="ex_cat")
	private WebElement categoryField;
	
	@FindBy(id="order_id")
	private WebElement orderIdField;
	
	@FindBy(id="purchase_id")
	private WebElement purchaseIdField;
	
	@FindBy(id="ex_type")
	private WebElement expenseTypeField;
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement amountField;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement remarksField;
	
	@FindBy(xpath="//input[@name='userfile']")
	private WebElement uploadFileField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement alertCloseButton;
	
		public void checkTodaysDateInDateField() {
			String expectedSystemDate;
			String actualDate;
			PageUtility.ScrollBy(driver);
			WaitUtility.waitForVisibilityOfWebelement(driver, manageExpenseButton);
			WaitUtility.waitForElementClickable(driver, manageExpenseButton);
			PageUtility.clickOnElement(manageExpenseButton);
			WaitUtility.waitForVisibilityOfWebelement(driver, newButton);
			PageUtility.clickOnElement(newButton);
			actualDate=dateField.getAttribute("value");
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			expectedSystemDate= dateFormat.format(date);
			Assert.assertEquals(actualDate, expectedSystemDate, "Actual date and current system dates are not same");
		}
		public void createNewExpenseRecord() throws IOException {
			boolean flag = false;
			PageUtility.ScrollBy(driver);
			WaitUtility.waitForVisibilityOfWebelement(driver, manageExpenseButton);
			WaitUtility.waitForElementClickable(driver, manageExpenseButton);
			PageUtility.clickOnElement(manageExpenseButton);
			WaitUtility.waitForVisibilityOfWebelement(driver, newButton);
			PageUtility.clickOnElement(newButton);
			Select user=new Select(userField);
			Select category=new Select(categoryField);
			Select orderId=new Select(orderIdField);
			Select purchaseid=new Select(purchaseIdField);
			Select expenseType=new Select(expenseTypeField);
			user.selectByIndex(FakerUtility.generateIndex());
			category.selectByIndex(FakerUtility.generateIndex());
			orderId.selectByIndex(FakerUtility.generateIndex());
			purchaseid.selectByIndex(FakerUtility.generateIndex());
			expenseType.selectByVisibleText(ExcelUtility.getTestData(0, 1, constants.Constants.TESTDATAFILE, "Manage_Expense"));
			PageUtility.enterText(amountField, FakerUtility.generateAmount());
			PageUtility.enterText(remarksField, FakerUtility.generateStringData());
			uploadFileField.sendKeys(constants.Constants.UPLOAD_FILE);
			PageUtility.ScrollBy(driver);
			PageUtility.clickOnElement(saveButton);
			WaitUtility.waitForVisibilityOfWebelement(driver, alertCloseButton);
			if(alertCloseButton.isDisplayed()) {
				flag=true;
			}
			Assert.assertTrue(flag, "New Expense record save failed");
		}
		public void createExpenseRecordByselectDateFromCalendar() throws IOException {
			boolean flag = false;
			PageUtility.ScrollBy(driver);
			WaitUtility.waitForVisibilityOfWebelement(driver, manageExpenseButton);
			WaitUtility.waitForElementClickable(driver, manageExpenseButton);
			PageUtility.clickOnElement(manageExpenseButton);
			WaitUtility.waitForVisibilityOfWebelement(driver, newButton);
			PageUtility.clickOnElement(newButton);
			Select user=new Select(userField);
			Select category=new Select(categoryField);
			Select orderId=new Select(orderIdField);
			Select purchaseid=new Select(purchaseIdField);
			Select expenseType=new Select(expenseTypeField);
			user.selectByIndex(FakerUtility.generateIndex());
			dateField.clear();
			dateField.sendKeys(FakerUtility.generateDate());
			category.selectByIndex(FakerUtility.generateIndex());
			orderId.selectByIndex(FakerUtility.generateIndex());
			purchaseid.selectByIndex(FakerUtility.generateIndex());
			expenseType.selectByVisibleText(ExcelUtility.getTestData(0, 1, constants.Constants.TESTDATAFILE, "Manage_Expense"));
			PageUtility.enterText(amountField, FakerUtility.generateAmount());
			PageUtility.enterText(remarksField, FakerUtility.generateStringData());
			uploadFileField.sendKeys(constants.Constants.UPLOAD_FILE);
			PageUtility.ScrollBy(driver);
			PageUtility.clickOnElement(saveButton);
			WaitUtility.waitForVisibilityOfWebelement(driver, alertCloseButton);
			if(alertCloseButton.isDisplayed()) {
				flag=true;
			}
			Assert.assertTrue(flag, "New Expense record save failed");
			
		}
	}
	
