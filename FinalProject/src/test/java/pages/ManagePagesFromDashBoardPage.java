package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagePagesFromDashBoardPage {
	public WebDriver driver;
	public ManagePagesFromDashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-page']")
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
	
	public void searchInvalidData() throws IOException {
		String actualMessage,expectedMessage=ExcelUtility.getTestData(0, 1, constants.Constants.TESTDATAFILE, "Manage_Pages");
		PageUtility.clickOnElement(managePages);
		WaitUtility.waitForElement(driver, mainSearchButton);
		PageUtility.clickOnElement(mainSearchButton);
		PageUtility.enterText(titleField, ExcelUtility.getTestData(1, 1, constants.Constants.TESTDATAFILE, "Manage_Pages"));
		PageUtility.clickOnElement(searchButton);
		actualMessage=resultNotFoundMessage.getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Provided data available in the list");
	}
	public void searchValidData() throws IOException {
		int rowCOunt;
		PageUtility.clickOnElement(managePages);
		WaitUtility.waitForElement(driver, mainSearchButton);
		PageUtility.clickOnElement(mainSearchButton);
		PageUtility.enterText(titleField, ExcelUtility.getTestData(1, 1, constants.Constants.TESTDATAFILE, "Manage_Pages"));
		List<WebElement> tableRowsElements=tableRows;
		rowCOunt=tableRowsElements.size();
		Assert.assertTrue(rowCOunt>1, "Searched content not found");;
	}
}
