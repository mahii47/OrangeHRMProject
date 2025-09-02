package commonLibs.utils;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
public class ScreenshotUtil {
	public static String takeScreenshot(WebDriver driver,String testName)
	{
		  String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String filePath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(src, new File(filePath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return filePath;
	}
}
