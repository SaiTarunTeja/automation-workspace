package _10_captureScreenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class _10_2_LogoVerification {
	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		
		webDriver.get("https://www.netflix.com/in/");
		//verifyLogoDisplayed();
		verifybaseLineLogo();
		webDriver.quit();
		
		
	}
	
	public static void verifyLogoDisplayed() {
		WebElement logo = webDriver.findElement(By.xpath("//img[@data-hawkins-id='BrandNetflixLogotype']"));
		
		if(logo.isDisplayed()) {
			System.out.println("Logo Displayed");
		} else {
			System.out.println("logo not Displayed");
		}
		
	}
	
	public static void verifybaseLineLogo() {
		try {

		    WebElement logo = webDriver.findElement(
		            By.xpath("//img[@data-hawkins-id='BrandNetflixLogotype']"));		    

		    File logoFile = logo.getScreenshotAs(OutputType.FILE);
		    
		    //File trg = new File(System.getProperty("user.dir")+"\\screenshots\\AAAAAA.png");
		    //FileUtils.copyFile(logoFile, trg);

		    BufferedImage actualImage = ImageIO.read(logoFile);

		    BufferedImage expectedImage = ImageIO.read(
		            new File("D:\\EclipseWorkSpace\\SeleniumPractice\\screenshots\\NetFlixLogo.png"));

		    ImageDiffer differ = new ImageDiffer();

		    ImageDiff diff = differ.makeDiff(expectedImage, actualImage);

		    if (diff.hasDiff()) {
		        System.out.println("FAIL : Logo has changed");
		    } else {
		        System.out.println("PASS : Logo is not changed");
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
