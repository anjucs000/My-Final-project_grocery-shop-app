package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

public class FakerUtility {
	public static String generateSingleData() {
		Faker faker = new Faker();
		String randomData=faker.name().title();
		return randomData;
	}
	public static int generateIndex() {
		Faker faker = new Faker();
		int index=faker.number().numberBetween(1, 30);
		return index;
		
	}
	public static String generateAmount() {
		Faker faker = new Faker();
		long amount=faker.number().numberBetween(500, 5000);
		String amountInString=String.valueOf(amount);
		return amountInString;
		
	}
	public static String generateStringData() {
		Faker faker = new Faker();
		String randomData=faker.address().fullAddress();
		return randomData;
	}
	public static String generateDate() {
		Faker faker = new Faker();
		Date date=faker.date().birthday();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String expectedSystemDate= dateFormat.format(date);
		return expectedSystemDate;
	}
	
	public static String generateUserName() {
		Faker faker = new Faker();
		String s=faker.name().username();
		return s;
	}
	public static int generateIndexforAdminUser() {
		Faker faker = new Faker();
		int index=faker.number().numberBetween(0, 5);
		return index;
		
	}
}
