package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOrdersFromDashboard {
	public WebDriver driver;
	public ManageOrdersFromDashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement manageOrders;
	
	@FindBy(xpath="//a[text()='Change Status']")
	WebElement changeStatusField;
	
	@FindBy(xpath="//a[text()='Change Delivery Date']")
	WebElement changeDeliveryDateField;
	
	@FindBy(xpath="//a[text()='Assign Delivery Boy']")
	WebElement assignDeliveryBoyField;
	
	@FindBy(xpath="//a[@class='btn btn-block btn-outline-info btn-sm']")
	WebElement viewButton;
	
	@FindBy(xpath="//h1[text()='Order Details']")
	WebElement orderDetailsHeading;
	
	@FindBy(xpath="//span[@id='back']")
	WebElement backButton;
	
	@FindBy(xpath="//h1[text()='List Orders']")
	WebElement listOrdersheading;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[@data-dismiss='alert']")
	WebElement closeButtonOfAlert;
	
	
	public void checkStatusColumnOptionColors() throws IOException {
		String actualChangeStatusColor = null,actualDeliveryDateColor=null,actualAssignDeliveryBoyField=null;
		String expectedChangeStatusColor=ExcelUtility.getTestData(0, 1, constants.Constants.TESTDATAFILE, "Manage_Orders");
		String expectedDeliveryDateColor=ExcelUtility.getTestData(1, 1, constants.Constants.TESTDATAFILE, "Manage_Orders");
		String expectedAssignDeliveryBoyField=ExcelUtility.getTestData(2, 1, constants.Constants.TESTDATAFILE, "Manage_Orders");
		boolean flag = false;
		PageUtility.clickOnElement(manageOrders);
		WaitUtility.waitForVisibilityOfWebelement(driver, changeStatusField);
		WaitUtility.waitForVisibilityOfWebelement(driver, changeDeliveryDateField);
		WaitUtility.waitForVisibilityOfWebelement(driver, assignDeliveryBoyField);
		actualChangeStatusColor=PageUtility.getBackgroundColorCSSValue(changeStatusField);
		actualDeliveryDateColor=PageUtility.getBackgroundColorCSSValue(changeDeliveryDateField);
		actualAssignDeliveryBoyField=PageUtility.getBackgroundColorCSSValue(assignDeliveryBoyField);
		if(actualChangeStatusColor.equals(expectedChangeStatusColor) 
		&& actualDeliveryDateColor.equals(expectedDeliveryDateColor) 
		&& actualAssignDeliveryBoyField.equals(expectedAssignDeliveryBoyField))
			{
				flag=true;
			}
		Assert.assertTrue(flag, "Actual and Expected colors of one or all of the buttons are not equal");
	}
	public void clickViewButton() {
		PageUtility.clickOnElement(viewButton);
		Assert.assertTrue(PageUtility.checkFieldDisplayed(orderDetailsHeading), "Navigation to Order details page failed");
	}
	public void clickBackButtonFromViewScreen() {
		PageUtility.clickOnElement(backButton);
		Assert.assertTrue(PageUtility.checkFieldDisplayed(listOrdersheading), "Navigate back to List orders page failed");
	}
	public void deleteOrder() {
		PageUtility.clickOnElement(deleteButton);
		driver.switchTo().alert().accept();
		Assert.assertTrue(PageUtility.checkFieldDisplayed(closeButtonOfAlert), "Delete order failed");
	}
	
	
}
