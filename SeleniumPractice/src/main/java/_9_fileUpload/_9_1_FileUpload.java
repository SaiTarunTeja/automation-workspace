package _9_fileUpload;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _9_1_FileUpload {

	static WebDriver webDriver;
	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
		
		File file = new File("src/main/resources/fileUplaod.html");
		webDriver.get(file.toURI().toString());
		
		File file1 = new File("src/main/resources/fileUplaod.html");
		File file2 = new File("src/main/resources/fileUplaod.html");
		
		//upload single file
		uploadFile(file1.getAbsolutePath());
		
		//upload Multiple files
		uploadFile(file1.getAbsolutePath()+"\n"+file2.getAbsolutePath());
	}
	
	public static void uploadFile(String fileName) {
		webDriver.findElement(By.id("fileInput")).sendKeys(fileName);
		List<WebElement> uploadedFileElements= webDriver.findElements(By.xpath("//ul[@id='fileList']//li"));
		List<String> uploadedFileNames = new ArrayList<>();
		for(WebElement webElement: uploadedFileElements) {
			uploadedFileNames.add(webElement.getText());
		}
		if(!uploadedFileNames.isEmpty()) {
			System.out.println(uploadedFileNames+" uploaded successfully");
		} else {
			System.out.println("Something went wrong files were not uploaded");
		}
	}

}
