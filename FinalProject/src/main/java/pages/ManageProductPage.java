package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageProductPage {
	public WebDriver driver;
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//parent::li")
	private WebElement manageProductSidemenu;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleField;
	
	@FindBy(xpath="//input[@value='Veg']")
	private WebElement vegRadioButton;
	
	@FindBy(xpath="//select[@id='cat_id']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath="//select[@id='sub_id']")
	private WebElement subCategoryDropdown;
	
	
	public void addNewproduct() {
		Select category=new Select(categoryDropdown);
		Select subCategory=new Select(subCategoryDropdown);
	}

}
