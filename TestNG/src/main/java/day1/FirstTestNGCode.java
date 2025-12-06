package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTestNGCode {

	@Test
	public void openGoogle() {

		WebDriver driver = new ChromeDriver();

		try {
			driver.manage().window().maximize();
			driver.get("https://duckduckgo.com/");
			driver.findElement(By.name("q")).sendKeys("Tarun", Keys.ENTER);

			System.out.println(driver.getTitle());

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void openFcebook() {

		WebDriver driver = new ChromeDriver();

		try {
			driver.manage().window().maximize();
			driver.get("https://facebook.com/");
			driver.findElement(By.id("email")).sendKeys("Tarun@gmail.com", Keys.ENTER);

			System.out.println(driver.getTitle());

			Thread.sleep(1000); // avoid in real tests
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit(); // IMPORTANT: close browser
		}
	}

}
