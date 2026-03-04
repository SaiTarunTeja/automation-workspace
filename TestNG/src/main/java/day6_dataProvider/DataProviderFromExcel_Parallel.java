package day6_dataProvider;

import org.testng.annotations.Test;

public class DataProviderFromExcel_Parallel {

	@Test(dataProvider = "getUserDataParallelly", dataProviderClass = ExcelDataSupplier.class)
	public void loginUser(String userName, String password) {
		System.out.println("UserName: "+userName+" << === >>"+"Password: "+password);
	}
}
