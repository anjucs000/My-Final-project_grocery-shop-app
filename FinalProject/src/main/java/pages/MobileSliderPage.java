package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MobileSliderPage {
	public WebDriver driver;
	public MobileSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
