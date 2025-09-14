package in.co.website.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import in.co.websitesPages.DashboardPage;

public class DashboardTest{

	 WebDriver driver;
	 DashboardPage dashboardPage;
	 
	@Test(priority = 2,dependsOnMethods= "loginTest")
	public void ClickonMyList()
	{
		dashboardPage = new DashboardPage(LoginTest.driver);
		dashboardPage.clickonMyInfo();
	}
	@Test(priority = 3,dependsOnMethods = "ClickonMyList")
	public void EnterForm() throws InterruptedException
	{
		Thread.sleep(5000);
		dashboardPage.firstname("Mahesh1");	
		dashboardPage.middlename("Vijay");
		dashboardPage.lastname("Mankar");
		dashboardPage.employeeId("1357");
		dashboardPage.otherId("247");
		dashboardPage.licenseNumber("4567890");
		dashboardPage.licenseExpiryDate("2024-08-07");
		dashboardPage.dateOfBirth("2025-12-03");
		dashboardPage.MaritalStatus("Married");
		dashboardPage.Nationality("Indian");
		dashboardPage.saveButton();
		dashboardPage.Bloodtest("A+");
		dashboardPage.Test_Field("12345");
		dashboardPage.saveButton2();
		dashboardPage.Attachments();
		dashboardPage.saveButton3();
		dashboardPage.profilepic();
	}
}
