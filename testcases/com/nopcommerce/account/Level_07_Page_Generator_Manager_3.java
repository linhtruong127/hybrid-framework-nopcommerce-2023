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

public class Level_07_Page_Generator_Manager_3 extends BaseTest {
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

		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorText(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorText(), "Password is required.");

	}

	@Test
	public void User_02_Register_Invalid_Email() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox("Lisa");
		registerPage.inputLastNameToTextbox("Truong");
		registerPage.inputEmailToTextbox("lisa@truong@gmail.com");
		registerPage.inputPasswordToTextbox("123456");
		registerPage.inputConfirmPasswordToTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorText(), "Wrong email");
	}

	@Test
	public void User_03_Register_Invalid_Password() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox("Lisa");
		registerPage.inputLastNameToTextbox("Truong");
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox("123");
		registerPage.inputConfirmPasswordToTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorText(), "Password must meet the following rules:\n" + "must have at least 6 characters");

	}

	@Test
	public void User_04_Register_Inccorect_Confirm_Password() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox("Lisa");
		registerPage.inputLastNameToTextbox("Truong");
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox("123456");
		registerPage.inputConfirmPasswordToTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorText(), "The password and confirmation password do not match.");

	}

	@Test
	public void User_05_Register_Success() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox("Lisa");
		registerPage.inputLastNameToTextbox("Truong");
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox("123456");
		registerPage.inputConfirmPasswordToTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");

	}

	@Test
	public void User_06_Login_Success() {
		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");

		homePage = loginPage.clickToUserLoginButton();

		customerPage = homePage.clickToMyaccountLink();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Lisa");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Truong");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
