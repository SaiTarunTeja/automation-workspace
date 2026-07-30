package _5_Tables;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _5_1_StaticTables {

	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		webDriver.manage().window().maximize();
		
		handlingStaticTables();
		
		webDriver.quit();
	}

	public static void handlingStaticTables() {
		webDriver.get("https://blazedemo.com/");

		// Select departure and destination
		selectOption(webDriver.findElement(By.name("fromPort")), "Boston");
		selectOption(webDriver.findElement(By.name("toPort")), "Berlin");

		// Find flights
		webDriver.findElement(By.cssSelector("input[type='submit']")).click();

		// Find the Price column index
		String tableXpath = "//table[@class='table']";
		int priceColumnIndex = getColumnIndex(webDriver, tableXpath, "Price");

		List<WebElement> rows = webDriver.findElements(By.xpath("//tbody/tr"));

		double lowestPrice = Double.MAX_VALUE;
		WebElement cheapestRow = null;

		for (WebElement row : rows) {
			String price = row.findElement(By.xpath("./td[" + priceColumnIndex + "]")).getText().replaceAll("[^0-9.]", "");

			double currentPrice = Double.parseDouble(price);

			if (currentPrice < lowestPrice) {
				lowestPrice = currentPrice;
				cheapestRow = row;
			}
		}

		cheapestRow.findElement(By.xpath(".//input[@value='Choose This Flight']")).click();

		// Passenger details
		enterTextInfiels(webDriver.findElement(By.id("inputName")), "firstName");
		enterTextInfiels(webDriver.findElement(By.id("address")), "123 Main St.");
		enterTextInfiels(webDriver.findElement(By.id("city")), "town");
		enterTextInfiels(webDriver.findElement(By.id("state")), "state");
		enterTextInfiels(webDriver.findElement(By.id("zipCode")), "123546");

		selectOption(webDriver.findElement(By.id("cardType")), "American Express");

		enterTextInfiels(webDriver.findElement(By.id("creditCardNumber")), "123546");
		enterTextInfiels(webDriver.findElement(By.id("creditCardMonth")),
				String.valueOf(LocalDate.now().getMonthValue()));
		enterTextInfiels(webDriver.findElement(By.id("creditCardYear")), String.valueOf(LocalDate.now().getYear()));

		enterTextInfiels(webDriver.findElement(By.id("nameOnCard")), "John Smith");

		webDriver.findElement(By.id("rememberMe")).click();
		webDriver.findElement(By.cssSelector("input[type='submit']")).click();

		// Verification
		String confirmationMessage = webDriver.findElement(By.tagName("h1")).getText();

		if ("Thank you for your purchase today!".equals(confirmationMessage)) {
			System.out.println("Ticket booked successfully");
		} else {
			System.out.println("Something went wrong");
		}
	}
	
	public static void enterTextInfiels(WebElement webElement, String value) {
		webElement.clear();
		webElement.sendKeys(value);
	}
	public static void selectOption(WebElement webElement, String selectableOption) {
		Select select = new Select(webElement);
		select.selectByVisibleText(selectableOption);
	}
	
	public static int getColumnIndex(WebDriver webDriver, String tableXpath, String columnName) {
	    List<WebElement> headers = webDriver.findElements(
	            By.xpath(tableXpath + "//th"));

	    for (int i = 0; i < headers.size(); i++) {
	        if (headers.get(i).getText().trim().equalsIgnoreCase(columnName)) {
	            return i + 1; // XPath uses 1-based indexing
	        }
	    }

	    return -1; // Column not found
	}
}
