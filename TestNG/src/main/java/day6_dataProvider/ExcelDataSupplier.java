package day6_dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
	@DataProvider()
	public Object[][] getUserData() {
		File excelFile = new File(".\\src\\main\\java\\day6_dataProvider\\DPExcel.xlsx");
		System.out.println(excelFile.exists());
		Object[][] userData = null;
		try(FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			
			XSSFSheet sheet = workbook.getSheet("UserDetails");
			int numberOfRows = sheet.getPhysicalNumberOfRows();
			int numberOfColumns = sheet.getRow(0).getLastCellNum();
			DataFormatter dataFormatter = new DataFormatter();
			
			userData = new Object[numberOfRows-1][numberOfColumns];//we must ignore the header, so that is why doing -1
			for (int row = 0; row < numberOfRows-1; row++) {
				for (int column = 0; column < numberOfColumns; column++) {
					//String cellValue = sheet.getRow(row).getCell(column).getStringCellValue();
					String cellValue = dataFormatter.formatCellValue(sheet.getRow(row+1).getCell(column));// dataformatter directly converts data into String
					userData[row][column] = cellValue;
					
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userData;
	}
	@DataProvider(parallel=true)
	public Object[][] getUserDataParallelly() {
		File excelFile = new File(".\\src\\main\\java\\day6_dataProvider\\DPExcel.xlsx");
		System.out.println(excelFile.exists());
		Object[][] userData = null;
		try(FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			
			XSSFSheet sheet = workbook.getSheet("UserDetails");
			int numberOfRows = sheet.getPhysicalNumberOfRows();
			int numberOfColumns = sheet.getRow(0).getLastCellNum();
			DataFormatter dataFormatter = new DataFormatter();
			
			userData = new Object[numberOfRows-1][numberOfColumns];//we must ignore the header, so that is why doing -1
			for (int row = 0; row < numberOfRows-1; row++) {
				for (int column = 0; column < numberOfColumns; column++) {
					//String cellValue = sheet.getRow(row).getCell(column).getStringCellValue();
					String cellValue = dataFormatter.formatCellValue(sheet.getRow(row+1).getCell(column));// dataformatter directly converts data into String
					userData[row][column] = cellValue;
					
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userData;
	}
}
