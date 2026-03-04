package day5_parameters;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {
	/*
	 * IMPORTANT TESTNG PARAMETER RULES:
	 *
	 * 1. Parameter names in testng.xml do NOT need to match
	 *    method argument names.
	 *    → Mapping is positional, not by variable name.
	 *    Here url is mapped to siteUrl
	 *
	 * 2. All parameters in testng.xml are read as String values by TestNG.
	 *
	 * 3. TestNG automatically converts String values to the required
	 *    type based on the method argument.
	 *    Example:
	 *      retries="2" (String in XML) → int retries (method argument)
	 *
	 * 4. If a parameter is missing in testng.xml and @Optional is used,
	 *    the default value will be applied and the test will NOT fail.
	 *
	 * 5. The @Optional default value must be compatible with the
	 *    method argument type.
	 */
	@Parameters({ "browserName", "url", "retries" })
	@Test
	public void testLogin(String browserName, String siteUrl, int retries) {

	    System.out.println("browserName: " + browserName);
	    System.out.println("url: " + siteUrl);
	    System.out.println("retries: " + retries);
	}

	/*
	 * Example showing @Optional usage.
	 * If 'retries' is missing in testng.xml,
	 * TestNG will use the default value "2"
	 * and convert it automatically to int.
	 */
	@Parameters("retries")
	@Test
	public void testLoginWithOptional(@Optional("2") int retries) {

	    System.out.println("retries: " + retries);
	}

}
