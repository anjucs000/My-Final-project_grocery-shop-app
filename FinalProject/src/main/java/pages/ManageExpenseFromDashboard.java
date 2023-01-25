package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

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
	
		public void checkTodaysDateInDateField() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,350)", "");
			js.executeScript("arguments[0].scrollIntoView()", manageExpenseButton);
			PageUtility.clickOnElement(manageExpenseButton);
			PageUtility.clickOnElement(newButton);
			//need to add steps to check date field have today' date?
		}
	}
	
