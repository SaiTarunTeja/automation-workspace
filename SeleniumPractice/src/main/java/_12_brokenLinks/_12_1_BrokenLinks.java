package _12_brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _12_1_BrokenLinks {
	static WebDriver webDriver;

	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		verifyBrokenLinks();
		webDriver.quit();

	}

	public static void verifyBrokenLinks() {
		webDriver.get("http://www.deadlinkcity.com/");
		//List<WebElement> allAnchorLinksList = webDriver.findElements(By.tagName("a"));
		List<WebElement> allAnchorLinksList = webDriver.findElements(By.xpath("//li//a"));
		
		for (WebElement anchorLinkElement : allAnchorLinksList) {
			String href = anchorLinkElement.getAttribute("href");
			System.out.println(href);
			
			 if (href == null || href.isBlank()) {
			        continue;
			    }
			try {
				
				HttpClient client = HttpClient.newHttpClient();

				HttpRequest request = HttpRequest.newBuilder(URI.create(href))
				        .method("HEAD", HttpRequest.BodyPublishers.noBody())
				        .build();

				HttpResponse<Void> response =
				        client.send(request, HttpResponse.BodyHandlers.discarding());

				int responseCode = response.statusCode();
				
				//if(responseCode!=200) {
				if(responseCode>=400) {
					System.err.println(href+" --> "+responseCode+" --> "+getStatusMessage(responseCode));
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	private static String getStatusMessage(int statusCode) {
	    return switch (statusCode) {
	        case 200 -> "OK";
	        case 201 -> "Created";
	        case 301 -> "Moved Permanently";
	        case 302 -> "Found";
	        case 400 -> "Bad Request";
	        case 401 -> "Unauthorized";
	        case 403 -> "Forbidden";
	        case 404 -> "Not Found";
	        case 500 -> "Internal Server Error";
	        case 502 -> "Bad Gateway";
	        case 503 -> "Service Unavailable";
	        default -> "Unknown Status";
	    };
	}
}
