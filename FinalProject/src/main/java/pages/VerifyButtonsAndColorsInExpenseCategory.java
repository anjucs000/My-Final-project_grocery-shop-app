package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PageUtility;

public class VerifyButtonsAndColorsInExpenseCategory {
	public WebDriver driver;
	public VerifyButtonsAndColorsInExpenseCategory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;

	public void findBackgroundColor() {
		Boolean flag=false;
		String actualBackgroundColorOfNewButton,expectedBackgroundColorOfNewButton="rgba(220, 53, 69, 1)";
		String actualBackgroundColorOfSearchButton,expectedBackgroundColorOfSearchButton="rgba(0, 123, 255, 1)";
		String actualBackgroundColorOfResetButton,expectedlBackgroundColorOfResetButton="rgba(255, 193, 7, 1)";
		//actualBackgroundColorOfNewButton=newButton.getCssValue("background-color");
		actualBackgroundColorOfNewButton=PageUtility.getBackgroundColorCSSValue(newButton);
		//actualBackgroundColorOfSearchButton=searchButton.getCssValue("background-color");
		actualBackgroundColorOfSearchButton=PageUtility.getBackgroundColorCSSValue(searchButton);
		//actualBackgroundColorOfResetButton=resetButton.getCssValue("background-color");
		actualBackgroundColorOfResetButton=PageUtility.getBackgroundColorCSSValue(resetButton);
		if(actualBackgroundColorOfNewButton.equals(expectedBackgroundColorOfNewButton) 
		&& actualBackgroundColorOfSearchButton.equals(expectedBackgroundColorOfSearchButton) 
		&& actualBackgroundColorOfResetButton.equals(expectedlBackgroundColorOfResetButton)) {
			flag=true;
		}
		Assert.assertTrue(true, "Actual and Expected colors of one or all of the buttons are not equal");
		Assert.assertTrue(flag);
	}
}
