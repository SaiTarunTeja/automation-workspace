package _4_dropdowns;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_3_BootStrapDropdown {

	/*
	 * Backend Java Python NodeJS
	 * 
	 * Frontend HTML CSS JavaScript
	 * 
	 * Database MySQL MongoDB
	 * 
	 */

	static WebDriver webDriver;

	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().window().maximize();
		bootStrapDropdown();
		webDriver.close();
	}

	public static void bootStrapDropdown() {
		///SeleniumPractice/src/main/resources/MultiSelectBootstrapDropdown.html
		File file = new File("src/main/resources/MultiSelectBootstrapDropdown.html");
		webDriver.get(file.toURI().toString());
		WebElement ddElement = webDriver.findElement(By.xpath("//button[normalize-space()='Select Skills']"));
		ddElement.click();
		
//		printOnlyHeaders();
//		printOnlySkills();
//		printHeadersAndSkills();
//		printSelectedCheckBoxes();
//		printUnSelectedCheckBox();
		printBasedOnCategory();
		sleep(5000);
	}

	public static void printBasedOnCategory() {
//		List<WebElement> eleList = webDriver.findElements(By.xpath("//div[contains(@class,'subcategory')] [   preceding-sibling::div[contains(@class,'category')][1] [normalize-space()='Backend']]"));
//		for(WebElement e: eleList) {
//			System.out.println(e.getText());
//		}
		//div[@class='category' and text()='Backend']/following::div[@class='category' ]//text()
		String category = "Frontend";
//		String nextCategoriesXpath = "//div[@class='category' and text()='"+category+"']/following::div[@class='category' ]//text()";
//		List<WebElement> nextElementsList = webDriver.findElements(By.xpath(nextCategoriesXpath));
//		List<String> GroupElements = new ArrayList<>();
//		if(nextElementsList.size()>0) {
//			String nextCategory = nextElementsList.get(0).getText();
//			List<WebElement> skillsList = webDriver.findElements(By.xpath("//div[@class='category' and text()='Backend']/following::div//label"));
//			for(WebElement element: skillsList) {
//				boolean isElementPreceding = webDriver.findElement(By.xpath("//div[@class='category' and text()='"+nextCategory+"']/preceding::div[@class='category' ]//text()"));
//			}
//		}
		
		//div[@class='category']
		Map<String, List<String>> categoryAndSubCategoryMap = new HashMap<>();
		List<WebElement> categoryList = webDriver.findElements(By.xpath("//div[@class='category']"));
		List<String> categoryNameList = getStringElementList(categoryList);
		System.out.println(categoryNameList);
		if (categoryList.size() > 0) {
			if (categoryNameList.contains(category)) {
				int categoryIndex = categoryNameList.indexOf(category);

				if ((categoryNameList.size() - 1) > categoryIndex) {
					String nextCategory = categoryNameList.get(categoryIndex+1);
					System.out.println(nextCategory);
					//div[text()='Frontend']/preceding::label[text()='Java']
					//div[text()='Backend']/following::label[text()='Java']
					List<WebElement> subCategoryWebElementList = webDriver.findElements(By.xpath("//label"));
					List<String> subCategoryNameList = getStringElementList(subCategoryWebElementList);
					
					List<WebElement> allCategoryWebElementList = webDriver.findElements(By.xpath("//div[contains(@class, 'category')]"));
					List<String> allCategoryNameList = getStringElementList(allCategoryWebElementList);
					Map<Integer,String> categoryAndIndex = new LinkedHashMap<>();
					for(WebElement element: allCategoryWebElementList) {
						
						if("category".equals(element.getAttribute("class"))) {
							String categoryName=element.getText();
							categoryAndIndex.put(allCategoryWebElementList.indexOf(element), categoryName);
						}
//						System.out.println(element.getAttribute("class"));
//						String categoryName = "";
//						String cubCategoryName = "";
//						if("category".equals(element.getAttribute("class"))) {
//							categoryName=element.getText();
//						}else if(element.getAttribute("class").contains("subcategory")) {
//							
//						}
					}
					System.out.println(categoryAndIndex);
					System.out.println("++"+allCategoryNameList);
					
					List<Integer> categoryIndexes = new ArrayList<>(categoryAndIndex.keySet());
					for(int i=0;i<categoryIndexes.size();i++) {
						List<String> subCategories = new ArrayList<>();
						if(categoryIndexes.size()-1==i) {
							Integer category_Index = categoryIndexes.get(i)+1;
							for(int j=category_Index;j<allCategoryNameList.size();j++) {
								subCategories.add(allCategoryNameList.get(j));
							}
						}else {
							Integer startingIndex = categoryIndexes.get(i)+1;
							Integer endingIndex = categoryIndexes.get(i+1);
							for(int j=startingIndex;j<endingIndex;j++) {
								subCategories.add(allCategoryNameList.get(j));
							}
						}
						categoryAndSubCategoryMap.put(categoryAndIndex.get(categoryIndexes.get(i)), subCategories);
					}
					System.out.println(categoryAndSubCategoryMap);
//					String currentCategoryXpath = "//div//label/preceding::div[normalize-space(text())='"+category+"']";
//					String nextCategoryXpath = "//div//label/following::div[normalize-space(text())='"+nextCategory+"']";
//					boolean isElementPresent = webDriver.findElement(By.xpath(currentCategoryXpath))!=null 
//							&& (webDriver.findElement(By.xpath(nextCategoryXpath))!=null);
//					if(isElementPresent) {
//						
//					}
				}

			} else {
				System.out.println("category: " + category + " not found in webPage.");
			}
		}
		if(categoryAndSubCategoryMap.containsKey(category)) {
			System.out.println(categoryAndSubCategoryMap.get(category));
		} else {
			System.out.println("category: " + category + " not found in webPage.");
		}
		
	}
	
	private static List<String> getStringElementList(List<WebElement> webElementList) {
		List<String> nameElementList = new ArrayList<>();
		for(WebElement element: webElementList) {
			String subCategoryName = element.getText();
			nameElementList.add(subCategoryName);
		}
		return nameElementList;
	}
	public static void printOnlyHeaders() {
		// print only headings
		List<WebElement> categoryOptions = webDriver.findElements(By.xpath("//div[@class='category']"));
		System.out.println("Headings");
		printOptionsList(categoryOptions);
	}

	// printing only skills
	public static void printOnlySkills() {

		List<WebElement> skillOptions = webDriver.findElements(By.xpath("//div//label"));
		System.out.println("Skills");
		printOptionsList(skillOptions);
	}

	// printing both skills and headings
	public static void printHeadersAndSkills() {
		/*
		 * Not a valid syntax //div[contains('label',*)]
		 */
		List<WebElement> categoryAndSkill = webDriver.findElements(By.xpath("//div[@class='category'] | //label"));
		System.out.println("Skills and Options");
		printOptionsList(categoryAndSkill);
	}

	// print only selected options
	public static void printSelectedCheckBoxes() {
		System.out.println("only checked Options");

		// approach-1
		for (WebElement checkbox : webDriver.findElements(By.xpath("//input[@type='checkbox']"))) {
			if (checkbox.isSelected()) {
				String labelText = checkbox.findElement(By.xpath("./following-sibling::label")).getText();
				System.out.println(labelText);
			}
		}

		// approach-2
		for (WebElement checkbox : webDriver.findElements(By.xpath("//input[@type='checkbox']"))) {

			if (checkbox.isSelected()) {
				String id = checkbox.getAttribute("id");
				String labelText = webDriver.findElement(By.xpath("//label[@for='" + id + "']")).getText();
				System.out.println(labelText);
			}
		}

		// approach-3
		int numberOfIterations = webDriver.findElements(By.xpath("//div//label")).size();
		for (int elementNumber = 1; elementNumber <= numberOfIterations; elementNumber++) {
			String baseXpath = "//div[contains(@class,'subcategory')][" + elementNumber + "]";
			WebElement element = webDriver.findElement(By.xpath(baseXpath + "//input"));
			if (element.isSelected()) {
				String selectedElement = webDriver.findElement(By.xpath(baseXpath + "//label")).getText();
				System.out.println(selectedElement);
			}
		}
		System.out.println("-------------------");

	}
	
	public static void printUnSelectedCheckBox() {
		System.out.println("unSelected Elements");
		List<WebElement> checkBoxElement = webDriver.findElements(By.xpath("//input"));
		for(WebElement element: checkBoxElement) {
			if(!element.isSelected()) {
				String elementName = element.findElement(By.xpath("./following-sibling::label")).getText();
				System.out.println(elementName);
			}
		}
		System.out.println("-------------------");
	}

	private static void printOptionsList(List<WebElement> categoryOptions) {
		for (WebElement element : categoryOptions) {
			System.out.println(element.getText());
		}
		System.out.println("--------------------");
	}
	
	private static void sleep(long sleepTimeMills) {
		try {
			Thread.sleep(sleepTimeMills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
