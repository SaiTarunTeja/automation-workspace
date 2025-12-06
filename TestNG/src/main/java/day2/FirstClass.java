package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstClass {

	@Test
	public void openGoogle() {

		WebDriver driver = new ChromeDriver();

		try {
			driver.manage().window().maximize();
			driver.get("https://duckduckgo.com/");
			driver.findElement(By.name("q")).sendKeys("Tarun", Keys.ENTER);

			System.out.println(driver.getTitle());

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
