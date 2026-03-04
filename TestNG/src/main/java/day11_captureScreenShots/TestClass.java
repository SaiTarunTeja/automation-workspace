package day11_captureScreenShots;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest{

	@Test
	public void testFB() {
		webDriver.get("https://www.facebook.com/");
		webDriver.findElement(By.id("email")).sendKeys("dummy@gmail.com");
		webDriver.findElement(By.id("pass")).sendKeys("dummy", Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(false);
	}
}
