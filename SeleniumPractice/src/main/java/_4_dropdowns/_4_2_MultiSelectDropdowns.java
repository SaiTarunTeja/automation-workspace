package _4_dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _4_2_MultiSelectDropdowns {
	static WebDriver webDriver;

	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().window().maximize();

		selectDropdown();
		webDriver.quit();
	}

	public static void selectDropdown() {
		webDriver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		WebElement ddlIdeElement = webDriver.findElement(By.id("ide"));
		Select ideNameDropdown = new Select(ddlIdeElement);

		// print all options in a dropdown
		System.out.println("Options in ide dropdown");
		for (WebElement optionElement : ideNameDropdown.getOptions()) {
			System.out.println(optionElement.getText());
		}
		System.out.println("-----------------------");

		// selecting option based on visible text
		ideNameDropdown.selectByVisibleText("IntelliJ IDEA");
		sleep(3000);

		// selecting option based on visible text with partial match
		ideNameDropdown.selectByContainsVisibleText("Visual");
		sleep(3000);

		// selecting an option based on index
		ideNameDropdown.selectByIndex(0);
		sleep(3000);

		// selecting an option based on value attribute of HTML
		ideNameDropdown.selectByValue("nb");
		sleep(3000);

		// delecting an option
		ideNameDropdown.deselectByVisibleText("NetBeans");

		System.out.println("all selected Options in dropdown");
		for (WebElement optionElement : ideNameDropdown.getAllSelectedOptions()) {
			System.out.println(optionElement.getText());
		}
		System.out.println("-----------------------");

		// de-selecting all option in a dropdown

		ideNameDropdown.deselectAll();
	}

	public static void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
