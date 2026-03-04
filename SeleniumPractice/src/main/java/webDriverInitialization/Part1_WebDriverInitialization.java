package webDriverInitialization;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Part1_WebDriverInitialization {

	
	//driver.manage().window().setSize(new Dimension(1920,1080));
	//driver.manage().window().maximize();

	public WebDriver initializeWebDriver(String browserName) {
		WebDriver webDriver;
		String browserLaunchMessage = "";
		switch(browserName.toLowerCase()) {
        case "chrome":
            webDriver = new ChromeDriver();
            browserLaunchMessage = "launched "+browserName+" Driver";
            break;

        case "firefox":
            webDriver = new FirefoxDriver();
            browserLaunchMessage = "launched "+browserName+" Driver";
            break;

        case "edge":
            webDriver = new EdgeDriver();
            browserLaunchMessage = "launched "+browserName+" Driver";
            break;
		default: 
				
		webDriver = new ChromeDriver();
		browserLaunchMessage = "unsupported browser found: "+browserName+" , so launched chrome Driver";
		}
		System.out.println(browserLaunchMessage);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts()
        .implicitlyWait(Duration.ofSeconds(10));
		return webDriver;
		
	}
	
	
}
