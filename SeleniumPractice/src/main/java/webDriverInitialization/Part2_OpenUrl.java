package webDriverInitialization;

import org.openqa.selenium.WebDriver;

public class Part2_OpenUrl {

	public static void main(String[] args) {
		String browserName = "chrome";
		String url = "https://www.selenium.dev/";
		Part2_OpenUrl openUrl = new Part2_OpenUrl();
		openUrl.openSite(browserName, url);

	}
	public void openSite(String browserName, String url) {
		
		Part1_WebDriverInitialization driverInitialization = new Part1_WebDriverInitialization();
		WebDriver webDriver = driverInitialization.initializeWebDriver(browserName);
		webDriver.get(url);
	}
}
