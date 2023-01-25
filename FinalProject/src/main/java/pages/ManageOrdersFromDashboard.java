package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PageUtility;

public class ManageOrdersFromDashboard {
	public WebDriver driver;
	public ManageOrdersFromDashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")
	WebElement manageOrders;
	
	@FindBy(xpath="(//a[text()='Change Status'])[1]//ancestor::tr")
	WebElement changeStatusField;
	
	@FindBy(xpath="(//a[text()='Change Delivery Date'])[1]")
	WebElement changeDeliveryDateField;
	
	@FindBy(xpath="(//a[text()='Assign Delivery Boy'])[1]")
	WebElement assignDeliveryBoyField;
	
	public void checkStatusColumnOptionColors() {
		PageUtility.clickOnElement(manageOrders);
		String actualChangeStatusColor = null, expectedChangeStatusColor="rgba(40, 167, 69, 1)";
		String actualDeliveryDateColor = null ,expectedDeliveryDateColor="rgba(0, 123, 255, 1)";
		String actualAssignDeliveryBoyField = null ,expectedAssignDeliveryBoyField="rgba(255, 193, 7, 1)";
		boolean flag = false;
		actualChangeStatusColor=PageUtility.getBackgroundColorCSSValue(changeStatusField);
		actualDeliveryDateColor=PageUtility.getBackgroundColorCSSValue(changeDeliveryDateField);
		actualAssignDeliveryBoyField=PageUtility.getBackgroundColorCSSValue(assignDeliveryBoyField);
		if(actualChangeStatusColor.equals(expectedChangeStatusColor) 
				&& actualDeliveryDateColor.equals(expectedDeliveryDateColor) 
				&& actualAssignDeliveryBoyField.equals(expectedAssignDeliveryBoyField)) {
					flag=true;
				}
				Assert.assertTrue(true, "Actual and Expected colors of one or all of the buttons are not equal");
				Assert.assertTrue(flag);
	}
}
