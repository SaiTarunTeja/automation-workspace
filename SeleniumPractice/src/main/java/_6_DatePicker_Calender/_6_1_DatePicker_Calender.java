package _6_DatePicker_Calender;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _6_1_DatePicker_Calender {
	static WebDriver webDriver;

	public static void main(String[] args) {
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();

		//jQueryDatePicker();
		datePickerWith_DateTimeFormatterAndLocalDate_Pattern1("12-02-2024");
	}
	
	public static void datePickerWith_DateTimeFormatterAndLocalDate_Pattern1(String inputDate) {
		DateTimeFormatter targetDatetimeFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
		LocalDate targetLocalDateTime=null;
		try {
			targetLocalDateTime = LocalDate.parse(inputDate, targetDatetimeFormatter);
		} catch (DateTimeParseException  e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(targetLocalDateTime==null) {
			return ;
		}
		int targetDayNumber = targetLocalDateTime.getDayOfMonth();
		int targetMonthNumber = targetLocalDateTime.getMonthValue();
		int targetYearNumber = targetLocalDateTime.getYear();
		
		webDriver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		webDriver.findElement(By.xpath("//input[@id='first_date_picker']")).click();
		String currentDate = webDriver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println(currentDate);
		
		DateTimeFormatter currentDateTimeFormatter = DateTimeFormatter.ofPattern("MMMM uuuu");
		YearMonth yearMonth = YearMonth.parse(currentDate, currentDateTimeFormatter);

		
		int currentMonthNumber = yearMonth.getMonthValue();
		int currentYearNumber = yearMonth.getYear();
		
		while(currentMonthNumber > targetMonthNumber || currentYearNumber > targetYearNumber) {
			if(currentMonthNumber == targetMonthNumber) {
				break;
			} 
			webDriver.findElement(By.className("ui-datepicker-prev")).click();
			currentDate = webDriver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			
			currentDateTimeFormatter = DateTimeFormatter.ofPattern("MMMM uuuu");
			yearMonth = YearMonth.parse(currentDate, currentDateTimeFormatter);

			
			currentMonthNumber = yearMonth.getMonthValue();
			currentYearNumber = yearMonth.getYear();
		}
		
		while(currentMonthNumber < targetMonthNumber || currentYearNumber < targetYearNumber) {
			if(currentMonthNumber == targetMonthNumber) {
				break;
			} 
			webDriver.findElement(By.className("ui-datepicker-next")).click();
			currentDate = webDriver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			currentDateTimeFormatter = DateTimeFormatter.ofPattern("MMMM uuuu");
			yearMonth = YearMonth.parse(currentDate, currentDateTimeFormatter);

			
			currentMonthNumber = yearMonth.getMonthValue();
			currentYearNumber = yearMonth.getYear();
		}
		
		webDriver.findElement(By.xpath(
				"//table[@class='ui-datepicker-calendar']//td[not(contains(@class, ' ui-datepicker-other-month '))]/a[text()='"
						+ targetDayNumber + "']"))
				.click();
	}

	public static void jQueryDatePicker() {
		String targetYear = "2025";
		String targetMonth = "May";
		String targetDay = "7";

		webDriver.get("url");
		webDriver.findElement(By.xpath("//input[@id='first_date_picker']")).click();
		int targetYearInt = Integer.parseInt(targetYear);

		pickTarget(targetYearInt, "//span[@class='ui-datepicker-year']", false);
		pickTarget(getMonthIndex(targetMonth), "//span[@class='ui-datepicker-month']", true);
		webDriver.findElement(By.xpath("//td//a[text()='" + targetDay + "']")).click();

	}

	public static void pickTarget(int target, String currentElementXpath, boolean ismonth) {

		while (true) {
			int current = -1;
			if (ismonth) {
				current = getMonthIndex(webDriver.findElement(By.xpath(currentElementXpath)).getText());
			} else {
				current = Integer.parseInt(webDriver.findElement(By.xpath(currentElementXpath)).getText());
			}
			if (current == -1) {
				System.out.println("Something wen wrong");
				return;
			}
			if (target == current) {
				break;
			} else if (target < current) {
				webDriver.findElement(By.xpath("//a[@data-handler='prev']")).click();
			} else if (target > current) {
				webDriver.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
		}
	}

	public static int getMonthIndex(String monthName) {
		Map<String, Integer> monthAndItIndex = new HashMap<>();
		monthAndItIndex.put("January", 1);
		monthAndItIndex.put("February", 2);
		monthAndItIndex.put("March", 3);
		monthAndItIndex.put("April", 4);
		monthAndItIndex.put("May", 5);
		monthAndItIndex.put("June", 6);
		monthAndItIndex.put("July", 7);
		monthAndItIndex.put("August", 8);
		monthAndItIndex.put("September", 9);
		monthAndItIndex.put("October", 10);
		monthAndItIndex.put("November", 11);
		monthAndItIndex.put("December", 12);

		return monthAndItIndex.get(monthName);
	}
}
