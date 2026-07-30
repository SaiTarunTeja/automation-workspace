package _4_dropdowns;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_5_AutoSuggestedDropdown {

	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		autoSuggestDDL();

		
		webDriver.quit();
	}

	public static void autoSuggestDDL() {
		webDriver.get("https://www.amazon.in/");
		webDriver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("novel books");
		List<WebElement> suggessionOptions = webDriver.findElements(By.xpath("//div[contains(@class, 'suggestion-ellipsis')]"));
		for(WebElement webElement: suggessionOptions) {
			String suggestion = webElement.getText();
			if("novel books english".equalsIgnoreCase(suggestion)) {
				webElement.click();
				break;
			}
		}
		
		
	}
}
