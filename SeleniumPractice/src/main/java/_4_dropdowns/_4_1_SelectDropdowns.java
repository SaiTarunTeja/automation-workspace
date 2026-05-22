package _4_dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _4_1_SelectDropdowns {
	static WebDriver webDriver;

	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().window().maximize();

		selectDropdown();
		webDriver.quit();
	}

	public static void selectDropdown() {
		sleep(3000);
		webDriver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		WebElement ddlCourseElement = webDriver.findElement(By.id("course"));
		Select courseNameDropdown = new Select(ddlCourseElement);

		// print all options in a dropdown
		System.out.println("Options in course dropdown");
		for(WebElement optionElement: courseNameDropdown.getOptions()) {
			System.out.println(optionElement.getText());
		}
		System.out.println("-----------------------");
		
		// selecting option based on visible text
		courseNameDropdown.selectByVisibleText("Javascript");
		sleep(3000);

		// selecting option based on visible text with partial match
		 courseNameDropdown.selectByContainsVisibleText("Dot");
		 sleep(3000);

		// selecting an option based on index
		 courseNameDropdown.selectByIndex(1);
		 sleep(3000);

		 // selecting an option based on value attribute of HTML
		 courseNameDropdown.selectByValue("python");
		 sleep(3000);
		 
		 // currently selected option in a dropdown
		 System.out.println("first selected option: "+courseNameDropdown.getFirstSelectedOption().getText());

	}

	public static void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
