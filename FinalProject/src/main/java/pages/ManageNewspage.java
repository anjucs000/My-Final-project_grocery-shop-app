package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewspage {
	
	public WebDriver driver;
	public ManageNewspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")
	private WebElement manageContent;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//parent::li")
	private WebElement manageNews;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement newButton;
	
	@FindBy(xpath="//textarea[@id='news']")
	private WebElement enterTheNewsField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr")
	private List<WebElement> tableRows;
	
	public void enterAndSaveNews() {
		String alertMessage;
		PageUtility.clickOnElement(manageContent);
		WaitUtility.waitForElement(driver, manageNews);
		WaitUtility.waitForElementClickable(driver, manageNews);
		PageUtility.clickOnElement(manageNews);
		PageUtility.clickOnElement(newButton);
		PageUtility.enterText(enterTheNewsField, FakerUtility.generateSingleData());
		PageUtility.clickOnElement(saveButton);
		alertMessage=successAlert.getText();
		Assert.assertTrue(alertMessage.contains("News Created Successfully"), "Saving news failed");
	}
	public void updateNewsAndSave() {
		int x=1;
		PageUtility.clickOnElement(manageContent);
		WaitUtility.waitForElement(driver, manageNews);
		WaitUtility.waitForElementClickable(driver, manageNews);
		PageUtility.clickOnElement(manageNews);
		List<WebElement> elements=tableRows;
		Iterator<WebElement> i = elements.iterator();
		 while(i.hasNext()) {
		        WebElement item = i.next();
		        WebElement rowVale=item.findElement(By.tagName("a"));
		       
		        if(rowVale.getAttribute("href").contains("https")) {
		        	item.click();
		            break;
		        }
		    }
		/*if(x==1) {
			for(WebElement item:elements) {
				String hrefAttribute=item.getAttribute("href");
				if(hrefAttribute.contains("https")) {
					WebElement itemToClick=item;
					item.click();
					x=2;
				}
			}
		}*/
		PageUtility.enterText(enterTheNewsField, FakerUtility.generateSingleData());
		PageUtility.clickOnElement(saveButton);
	}
	
}
