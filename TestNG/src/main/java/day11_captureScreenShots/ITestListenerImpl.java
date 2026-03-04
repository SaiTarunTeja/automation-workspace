package day11_captureScreenShots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl extends BaseTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("@@@@@@@@@@@");
		//screenshotName same as methodName
		//System.out.println(result.getMethod().getMethodName());
		//System.out.println(result.getName());
		//String screenShotName=result.getName();
		
		//ScreenshotName same as TestNG xml testName
		String screenShotName=result.getTestContext().getName();
		System.out.println(screenShotName+"!!!!!1");
		captureScreenshot(screenShotName);
	}
	
}
