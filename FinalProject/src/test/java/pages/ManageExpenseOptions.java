package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageExpenseOptions {
	public WebDriver driver;
	public ManageExpenseOptions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpenseButton;
	
	@FindBy(xpath="//li[@class='nav-item has-treeview menu-open']//ul")
	private List<WebElement> manageExpenseButtonList;
	
	public void clickManageExpense() {
		int count=0;
		PageUtility.clickOnElement(manageExpenseButton);
		WaitUtility.waitForVisibilityOfAllElements(driver, manageExpenseButtonList);
		count=manageExpenseButtonList.size();
		Assert.assertTrue((count==3), "The number of options under Manage Expense is not equal to 3");	
	}
}
