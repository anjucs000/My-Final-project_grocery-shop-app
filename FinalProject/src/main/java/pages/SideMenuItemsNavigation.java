package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenuItemsNavigation {
	public WebDriver driver;
	public SideMenuItemsNavigation(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath="//li[@class='nav-item']//child::a")
	private List<WebElement> itemsList;

	public void sideMenuNavigationMethod(String menu) {
		String input;
		List<WebElement> listOfItems=itemsList;
		for(WebElement ItemSelected:listOfItems) {
			input=ItemSelected.getAttribute("href");
			if(input.contains(menu)) {
				ItemSelected.click();
			}
		}
	}
}
