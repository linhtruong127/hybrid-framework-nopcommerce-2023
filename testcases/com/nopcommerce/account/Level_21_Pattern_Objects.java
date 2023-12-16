package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

public class Level_21_Pattern_Objects extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private String emailAddress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void User_01_Register_Empty_Data() {

		homePage.clickToHeaderLinkByPageText("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMsgByID("FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMsgByID("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMsgByID("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMsgByID("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMsgByID("ConfirmPassword"), "Password is required.");
	}

	@Test
	public void User_02_Register_Invalid_Email() {

		homePage.clickToHeaderLinkByPageText("Register");

		registerPage.inputToDynamicTextbox("FirstName", "Lisa");
		registerPage.inputToDynamicTextbox("LastName", "Truong");
		registerPage.inputToDynamicTextbox("Email", "lisa@truong@gmail.com");
		registerPage.inputToDynamicTextbox("Password", "123456");
		registerPage.inputToDynamicTextbox("ConfirmPassword", "123456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMsgByID("Email"), "Wrong email");
	}

	@Test
	public void User_03_Register_Invalid_Password() {
		homePage.clickToHeaderLinkByPageText("Register");

		registerPage.inputToDynamicTextbox("FirstName", "Lisa");
		registerPage.inputToDynamicTextbox("LastName", "Truong");
		registerPage.inputToDynamicTextbox("Email", emailAddress);
		registerPage.inputToDynamicTextbox("Password", "123");
		registerPage.inputToDynamicTextbox("ConfirmPassword", "123456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMsgByID("Password"), "Password must meet the following rules:\n" + "must have at least 6 characters");

	}

	@Test
	public void User_04_Register_Inccorect_Confirm_Password() {
		homePage.clickToHeaderLinkByPageText("Register");

		registerPage.inputToDynamicTextbox("FirstName", "Lisa");
		registerPage.inputToDynamicTextbox("LastName", "Truong");
		registerPage.inputToDynamicTextbox("Email", emailAddress);
		registerPage.inputToDynamicTextbox("Password", "123456");
		registerPage.inputToDynamicTextbox("ConfirmPassword", "123");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMsgByID("ConfirmPassword"), "The password and confirmation password do not match.");

	}

	@Test
	public void User_05_Register_Success() {
		homePage.clickToHeaderLinkByPageText("Register");

		registerPage.inputToDynamicTextbox("FirstName", "Lisa");
		registerPage.inputToDynamicTextbox("LastName", "Truong");
		registerPage.inputToDynamicTextbox("Email", emailAddress);
		registerPage.inputToDynamicTextbox("Password", "123456");
		registerPage.inputToDynamicTextbox("ConfirmPassword", "123456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");

	}

	@Test
	public void User_06_Login_Success() {

		homePage.clickToHeaderLinkByPageText("Log in");
		loginPage = PageGeneratorManager.getUserLoginPage(driver);

		loginPage.inputToDynamicTextbox("Email", emailAddress);
		loginPage.inputToDynamicTextbox("Password", "123456");

		loginPage.clickToButtonByText("Log in");

		homePage.clickToHeaderLinkByPageText("My account");
		customerPage = PageGeneratorManager.getCustomerInfoPage(driver);

		Assert.assertEquals(customerPage.getDynamicAttributeValueByID("FirstName"), "Lisa");
		Assert.assertEquals(customerPage.getDynamicAttributeValueByID("LastName"), "Truong");
		Assert.assertEquals(customerPage.getDynamicAttributeValueByID("Email"), emailAddress);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
