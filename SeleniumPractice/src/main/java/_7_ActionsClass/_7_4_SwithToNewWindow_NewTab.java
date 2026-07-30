package _7_ActionsClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class _7_4_SwithToNewWindow_NewTab {
	static WebDriver webDriver;

	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		webDriver.manage().window().maximize();

		// openNewTab();
		openNewWindow();
		webDriver.quit();
	}

	public static void openNewWindow() {
		webDriver.get("https://www.flipkart.com/");
		openUrlsInNewTabs("window");
		getWindowHandleDetails();
	}

	public static void openNewTab() {
		webDriver.get("https://www.flipkart.com/");
		openUrlsInNewTabs("tab");
		getWindowHandleDetails();
	}

	public static void getWindowHandleDetails() {
		Set<String> dummySet = new LinkedHashSet<>();
		for (String windowHandle : webDriver.getWindowHandles()) {
			System.out.println(webDriver.switchTo().window(windowHandle).getTitle());
			dummySet.add(webDriver.switchTo().window(windowHandle).getTitle());
		}
		System.out.println("==================");
		for (String name : dummySet) {
			System.out.println(name);

		}
	}

	public static void openUrlsInNewTabs(String windowType) {

		String[] urls = new String[] { "https://www.amazon.in/", "https://chatgpt.com/", "https://www.selenium.dev/",
				"https://www.myntra.com/", "https://www.youtube.com/", "https://www.instagram.com/accounts/login/",
				"https://www.facebook.com/" };

		for (String url : urls) {
			if ("tab".equalsIgnoreCase(windowType)) {
				webDriver.switchTo().newWindow(WindowType.TAB);
			} else if ("window".equalsIgnoreCase(windowType)) {
				webDriver.switchTo().newWindow(WindowType.WINDOW);
			}

			webDriver.get(url);
		}
	}

}
