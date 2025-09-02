package commonLibs.utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import commonLibs.implementation.DriverManager;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
	 public static String takeScreenshot(String testName) {
	        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	        String filePath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

	        File src = ((TakesScreenshot)DriverManager.driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(src, new File(filePath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return filePath;
	    }
}
