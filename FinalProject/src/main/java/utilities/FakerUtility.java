package utilities;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class FakerUtility {
	public static String generateSingleData() {
		Faker faker = new Faker();
		String randomData=faker.name().title();
		return randomData;
	}
}
