package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
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

	public void findBackgroundColor() throws IOException {
		Boolean flag=false;
		String actualBackgroundColorOfNewButton;
		String expectedBackgroundColorOfNewButton=ExcelUtility.getTestData(0, 1, constants.Constants.TESTDATAFILE, "Button_color");
		String actualBackgroundColorOfSearchButton;
		String expectedBackgroundColorOfSearchButton=ExcelUtility.getTestData(1, 1, constants.Constants.TESTDATAFILE, "Button_color");
		String actualBackgroundColorOfResetButton;
		String expectedlBackgroundColorOfResetButton=ExcelUtility.getTestData(2, 1, constants.Constants.TESTDATAFILE, "Button_color");
		actualBackgroundColorOfNewButton=PageUtility.getBackgroundColorCSSValue(newButton);
		actualBackgroundColorOfSearchButton=PageUtility.getBackgroundColorCSSValue(searchButton);
		actualBackgroundColorOfResetButton=PageUtility.getBackgroundColorCSSValue(resetButton);
		if(actualBackgroundColorOfNewButton.equals(expectedBackgroundColorOfNewButton) 
		&& actualBackgroundColorOfSearchButton.equals(expectedBackgroundColorOfSearchButton) 
		&& actualBackgroundColorOfResetButton.equals(expectedlBackgroundColorOfResetButton)) {
			flag=true;
		}
		Assert.assertTrue(flag, "Actual and Expected colors of one or all of the buttons are not equal");
	}
}
