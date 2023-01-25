package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class CreateNewExpenseRecord {
	public WebDriver driver;
	public CreateNewExpenseRecord(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/expense']")
	private WebElement manageExpenseButton;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Expense/add']")
	private WebElement newButton;
	
	@FindBy(xpath="//select[@class='form-control selectpicker']//parent::div[@class='col-md-6 form-group']")
	private WebElement userField;
	
	@FindBy(id="ex_date")
	private WebElement dateField;
	
	@FindBy(xpath="//select[@id='ex_cat']")
	private WebElement categoryField;
	
	@FindBy(id="order_id")
	private WebElement orderIdField;
	
	@FindBy(id="purchase_id")
	private WebElement purchaseIdField;
	
	@FindBy(name="ex_type")
	private WebElement expenseTypeField;
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement amountField;
	
	@FindBy(xpath="//textarea[@name='remarks']")
	private WebElement remarksField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
		public void createExpenseRecordAndSave() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,350)", "");
			js.executeScript("arguments[0].scrollIntoView()", manageExpenseButton);
			PageUtility.clickOnElement(manageExpenseButton);
			PageUtility.clickOnElement(newButton);
			Select objectForUser=new Select(userField);
			//code to provide datefield value
			Select objectForCategory=new Select(categoryField);
			Select objectForOrderId=new Select(orderIdField);
			Select objectForPurchaseId=new Select(orderIdField);
			Select objectForExpenseType=new Select(expenseTypeField);
			objectForUser.selectByIndex(10);
			objectForCategory.selectByVisibleText("abc");
			objectForOrderId.selectByValue("56");
			objectForPurchaseId.selectByIndex(20);
			objectForExpenseType.selectByVisibleText("Debit Bank");
			PageUtility.enterText(amountField, "100");
			PageUtility.clickOnElement(saveButton);
			
			//code to find the message appears on top while saveing
		}

}
