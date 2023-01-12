package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenuItemsNavigation {
	public WebDriver driver;
	@FindBy(xpath="//li[@class='nav-item']//a")
	private List<WebElement> itemsList;

	public void sideMenuNavigationMethod() {
		List<WebElement> listOfItems=itemsList;
		for(WebElement ItemSelected:listOfItems) {
			ItemSelected.getAttribute("href");
		}
	}

}
