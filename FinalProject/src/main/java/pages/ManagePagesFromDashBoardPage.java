package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagePagesFromDashBoardPage {
	public WebDriver driver;
	public ManagePagesFromDashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']//parent::div")
	private WebElement managePages;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement mainSearchButton;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	private WebElement titleField;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement resetButton;
	
	@FindBy(xpath="//span[@id='res']")
	private WebElement resultNotFoundMessage;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr")
	private List<WebElement> tableRows;
	
	public void searchInvalidData() {
		String actualMessage,expectedMessage=".........RESULT NOT FOUND.......";
		WaitUtility.waitForElement(driver, mainSearchButton);
		PageUtility.clickOnElement(managePages);
		PageUtility.clickOnElement(mainSearchButton);
		
		PageUtility.enterText(titleField, "invalid data");
		actualMessage=resultNotFoundMessage.getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Provided data available in the list");
	}
	public void searchValidData() {
		PageUtility.clickOnElement(managePages);
		PageUtility.clickOnElement(mainSearchButton);
		PageUtility.enterText(titleField, "test");
		Assert.assertFalse(resultNotFoundMessage.isDisplayed(), "Searched content not found");;
	}
}
