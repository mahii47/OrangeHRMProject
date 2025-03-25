package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonLibs.contracts.IBasePage;

public class BasePage implements IBasePage{
	protected WebDriver driver;
	WebDriver wait;
	
	public BasePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	@Override
	public void click(By locator)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable((locator)));
		element1.click();
		
	}
	@Override
	public void enterText(By locator, String text)
	{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		    element.click();
		    element.sendKeys(Keys.CONTROL + "a");
		    element.sendKeys(Keys.DELETE);
//		    JavascriptExecutor js = (JavascriptExecutor) driver;
//		    js.executeScript("arguments[0].value='';", element);
		    element.click();
		    element.sendKeys(text);
	}
	
	public void selectDropdown(By dropdownLocator, String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Click the dropdown to open the options
	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
	    
	    dropdown.click();
	    // Wait a moment to let options load
	    try {
	        Thread.sleep(1000); // 1-second pause to allow UI update
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    // Updated option locator based on common dropdown structures
	    By optionLocator = By.xpath("//div[@class='oxd-select-option']//span[contains(text(),'" + optionText + "')]");
	    // Find the option
	    WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
	    // Click using JavaScript to avoid UI issues
	    try {
	        option.click();
	    } catch (Exception e) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", option);
	    }
	}
	@Override
	public WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}




	

}
