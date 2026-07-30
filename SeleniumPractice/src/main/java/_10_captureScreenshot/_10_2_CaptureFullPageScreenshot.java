package _10_captureScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class _10_2_CaptureFullPageScreenshot {

	public static void main(String[] args) {
		captureFullPageUsingFirefoxDriver();
		//captureFullPageUsingChromeDriver();
	}

	public static void captureFullPageUsingFirefoxDriver() {
		try {
			FirefoxDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			driver.manage().window().maximize();

			driver.get("https://www.hyrtutorials.com/");

			File src = driver.getFullPageScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir")+"\\screenshots\\firefox_fullPage.png");

			FileUtils.copyFile(src, dest);
			
			driver.quit();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void captureFullPageUsingChromeDriver() {
		try {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			driver.manage().window().maximize();
			
			driver.get("https://testautomationpractice.blogspot.com/");
			Screenshot screenshot =
				    new AShot()
				        .shootingStrategy(
				            ShootingStrategies.viewportPasting(100))
				        .takeScreenshot(driver);

				ImageIO.write(
				    screenshot.getImage(),
				    "PNG",
				    new File(System.getProperty("user.dir")+"\\screenshots\\chrome_fullPage.png"));
				
			
			driver.quit();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
