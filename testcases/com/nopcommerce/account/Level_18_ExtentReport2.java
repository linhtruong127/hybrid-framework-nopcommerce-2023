package com.nopcommerce.account;

//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.user.HomePageObject;
//import pageObjects.user.RegisterPageObject;
//import reportConfig.ExtentManager;
//
//public class Level_18_ExtentReport2 extends BaseTest {
//	private WebDriver driver;
//
//	private HomePageObject homePage;
//	private RegisterPageObject registerPage;
//
//	private String emailAddress = getEmailRandom();
//	private String firstName, lastName, password;
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserName(browserName);
//		homePage = PageGeneratorManager.getHomePage(driver);
//		firstName = "Lisa";
//		lastName = "Truong";
//		password = "123456";
//
//	}
//
//	@Test
//	public void User_01_Register_Validate(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register_Validate");
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 01: Verify Register link is displayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 02: Click to Register link");
//		registerPage = homePage.clickToRegisterLink();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 04: Verify error message of 'First name' ");
//		Assert.assertEquals(registerPage.getFirstNameErrorText(), "First name is required.");
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 05: Verify error message of 'Last name' ");
//		Assert.assertEquals(registerPage.getLastNameErrorText(), "Last name is required");
//
//	}
//
//	@Test
//	public void User_02_Register_Success(Method method) {
//		
//		ExtentManager.startTest(method.getName(), "User_02_Register_Success");
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 06: Enter to 'First name' textbox with value is " + firstName);
//		registerPage.inputFirstNameToTextbox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 07: Enter to 'Last name' textbox with value is " + lastName);
//		registerPage.inputLastNameToTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 08: Enter to 'Email' textbox with value is " + emailAddress);
//		registerPage.inputEmailToTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 09: Enter to 'Password' textbox with value is " + password);
//		registerPage.inputPasswordToTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 10: Enter to 'Confirm Password' textbox with value is " + password);
//		registerPage.inputConfirmPasswordToTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 11: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 12: Verify registration is successful");
//		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");
//
//	}
//
//	@AfterClass
//	public void afterClass() {
//		closeBrowser();
//	}
//
//}

