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
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class NopCommerce_Login extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private RegisterPageObject registerPage;

	private String emailAddress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Login_00_Register__Success() {
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
	public void Login_01_Empty_Data() {

		loginPage = homePage.clickToLoginLink();
		loginPage.clickToUserLoginButton();

		Assert.assertEquals(loginPage.getEmailErrorText(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.loginToUser("lisa@truong@gmail.com", "123456");

		Assert.assertEquals(loginPage.getEmailErrorText(), "Wrong email");

	}

	@Test
	public void Login_03_Unregistered_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.loginToUser("lisatruong@gmail.com", "123456");

		Assert.assertEquals(loginPage.getLoginErrorText(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");

	}

	@Test
	public void Login_04_Valid_Email_And_No_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.loginToUser(emailAddress, "");

		Assert.assertEquals(loginPage.getLoginErrorText(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void Login_05_Valid_Email_And_Wrong_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.loginToUser(emailAddress, "123");

		Assert.assertEquals(loginPage.getLoginErrorText(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_And_Valid_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");

		homePage = loginPage.clickToUserLoginButton();

		homePage.refreshCurrentPage(driver);

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
