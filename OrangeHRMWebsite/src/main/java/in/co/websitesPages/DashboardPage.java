package in.co.websitesPages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonLibs.implementation.BasePage;

public class DashboardPage extends BasePage{
	
	private By click = By.xpath("//li[6]");
	private By firstname = By.xpath("//input[@name='firstName']");
	private By middlename = By.xpath("//input[@name='middleName']");
	private By lastname = By.xpath("//input[@name='lastName']");
	private By nickname = By.xpath("//label[contains(text(), 'Nickname')]/following::input[1]");
	private By employeeId = By.xpath("//label[contains(text(), 'Employee Id')]/following::input[1]");
	private By otherId = By.xpath("//label[contains(text(), 'Other Id')]/following::input[1]");
	private By licenseNumber = By.xpath("//label[contains(text(),\"Driver's License Number\")]/following::input[1]");
	private By licenseExpiryDate = By.xpath("//label[contains(text(), 'License Expiry Date')]/following::input[1]");
	private By ssnNumber = By.xpath("//label[contains(text(), 'SSN Number')]/following::input[1]");
	private By sinNumber = By.xpath("//label[contains(text(), 'SIN Number')]/following::input[1]");
	private By dateOfBirth = By.xpath("//label[contains(text(), 'Date of Birth')]/following::input[1]");
	private By militaryService = By.xpath("//label[contains(text(), 'Military Service')]/following::input[1]");
	private By Nationality = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	private By MaritalStatus = By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
	WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	private By firstButton = By.xpath("//button[@data-v-10d463b7 and @data-v-6653c066]");
	private By Bloodtest = By.xpath("(//div[@class='oxd-select-wrapper'])[3]");
	private By Test_Field = By.xpath("//label[contains(text(), 'Test_Field')]/following::input[1]");
	private By secondButton = By.xpath("(//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]");
	private By attachmentadd = By.xpath("//*[text()=' Add ']");  
	private By BrowserButton = By.xpath("//input[@type='file']");
	private By thirdButton =By.xpath("(//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[3]");
	private By profile = By.xpath("//*[@class='employee-image'][1]");
	private By profile2 = By.xpath("//input[@type='file']");
	private By fourthButton = By.xpath("//*[text()=' Save ']");
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	public void clickonMyInfo()
	{
		WebElement clicker = wait.until(ExpectedConditions.elementToBeClickable(click)); 
		clicker.click();
	}
	public void firstname(String text)
	{
		enterText(firstname,text);
	}
	public void middlename(String text)
	{
		enterText(middlename,text);
	}
	public void lastname(String text)
	{
		enterText(lastname,text);
	}
	public void nickname(String text) {
	    enterText(nickname, text);
	}
	public void employeeId(String text) {
	    enterText(employeeId, text);
	}
	public void otherId(String text) {
	    enterText(otherId, text);
	}
	public void licenseNumber(String text) {
	    enterText(licenseNumber, text);
	}
	public void licenseExpiryDate(String text) {
	    enterText(licenseExpiryDate, text);
	}
	public void ssnNumber(String text) {
	    enterText(ssnNumber, text);
	}
	public void sinNumber(String text) {
	    enterText(sinNumber, text);
	}
	public void dateOfBirth(String text) {
	    enterText(dateOfBirth, text);
	}
	public void militaryService(String text) {
	    enterText(militaryService,text);
	}
	public void Nationality(String text) {
		selectDropdown(Nationality, text);
	}
	public void MaritalStatus(String text) {
		
		selectDropdown(MaritalStatus,text);
	}
	public void saveButton()
	{
		click(firstButton);
	}
	public void Bloodtest(String text)
	{
		selectDropdown(Bloodtest,text);
	}
	public void Test_Field(String text)
	{
		enterText(Test_Field,text);
	}
	public void saveButton2()
	{
		click(secondButton);
	}
	
	public void Attachments()
	{
		click(attachmentadd);
		addattachment(BrowserButton);
	}
	
	public void saveButton3()
	{
		click(thirdButton);
	}
	
	public void profilepic()
	{
		click(profile);
		addattachment(profile2);
		click(fourthButton);
	}
}
