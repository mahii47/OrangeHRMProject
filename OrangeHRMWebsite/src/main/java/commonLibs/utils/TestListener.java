package commonLibs.utils;
import org.testng.ITestListener;
import org.testng.ITestResult;
import commonLibs.implementation.DriverManager;

public class TestListener extends DriverManager  implements ITestListener{
	 @Override
	    public void onTestFailure(ITestResult result) {
	      if(driver!=null)
	      {
	    	  String testName = result.getMethod().getMethodName();
	    	  ScreenshotUtil.takeScreenshot(testName);
	    }}

}
		 

