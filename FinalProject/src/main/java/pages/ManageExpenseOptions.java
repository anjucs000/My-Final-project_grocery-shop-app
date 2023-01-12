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
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpenseButton;
	@FindBy(xpath="//li[@class='nav-item has-treeview menu-open']//ul")
	private List<WebElement> manageExpenseButtonList;
	
	public ManageExpenseOptions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickManageExpense() {
		//driver.findElement(By.xpath("//i[@class='nav-icon fas fa-money-bill-alt']"));
		//driver.findElement(By.xpath("//i[@class='nav-icon fas fa-money-bill-alt']")).click();
		//manageExpenseButton.click();
		//WaitUtility.waitForInvisibilityOfWebelementList(driver, manageExpenseButtonList);
		int count=0;
		PageUtility.clickOnElement(manageExpenseButton);
		WaitUtility.waitForInvisibilityOfWebelementList(driver, manageExpenseButtonList);
		List<WebElement> elements=manageExpenseButtonList;
		//List<WebElement> elements=driver.findElements(By.xpath("(//li[@class='nav-item has-treeview menu-open']//ul)"));
		for(WebElement items:elements) {
			String hrefAttribute=items.getAttribute("href");
			if(hrefAttribute.contains("groceryapp")) {
				count=count+1;
			}
		}
		if(count==3) {
			Assert.assertTrue(true, "The number of options under Manage Expense is not equal to 3");
		}	
	}
}
