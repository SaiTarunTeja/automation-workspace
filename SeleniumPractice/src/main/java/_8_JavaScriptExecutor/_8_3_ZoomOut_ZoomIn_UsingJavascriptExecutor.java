package _8_JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _8_3_ZoomOut_ZoomIn_UsingJavascriptExecutor {

	static WebDriver webDriver;
	static JavascriptExecutor executor;

	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();

		executor = (JavascriptExecutor) webDriver;

		webDriver.get("https://testautomationpractice.blogspot.com/");
		sleep(5000);
		// zoomout_50_percent();
		zoomoutGivenPercent("500");
		sleep(5000);
		webDriver.quit();

	}

	public static void zoomout_50_percent() {
		executor.executeScript("document.body.style.zoom = '50%'");
	}

	public static void zoomoutGivenPercent(String zoomPercentage) {
		executor.executeScript("document.body.style.zoom=arguments[0] +'%';", zoomPercentage);
	}

	public static void sleep(long waitTimeSeconds) {
		try {
			Thread.sleep(waitTimeSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
