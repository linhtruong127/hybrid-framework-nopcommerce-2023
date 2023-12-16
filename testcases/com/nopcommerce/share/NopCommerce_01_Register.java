package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class NopCommerce_01_Register extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	public static String emailAddress, firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		emailAddress = getEmailRandom();
		firstName = "Lisa";
		lastName = "Truong";
		password = "123456";

		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
	}

	@Test
	public void Register_01_Empty_Data() {
		Assert.assertEquals(registerPage.getFirstNameErrorText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorText(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorText(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox(firstName);
		registerPage.inputLastNameToTextbox(lastName);
		registerPage.inputEmailToTextbox("lisa@truong@gmail.com");
		registerPage.inputPasswordToTextbox(password);
		registerPage.inputConfirmPasswordToTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorText(), "Wrong email");
	}

	@Test
	public void Register_03_Register_Success() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox(firstName);
		registerPage.inputLastNameToTextbox(lastName);
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox(password);
		registerPage.inputConfirmPasswordToTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");

	}

	@Test
	public void Register_04_Existed_Email() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox(firstName);
		registerPage.inputLastNameToTextbox(lastName);
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox(password);
		registerPage.inputConfirmPasswordToTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getExistedEmailText(), "The specified email already exists");
	}

	@Test
	public void Register_05_Invalid_Password() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox(firstName);
		registerPage.inputLastNameToTextbox(lastName);
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox("123");
		registerPage.inputConfirmPasswordToTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorText(), "Password must meet the following rules:\n" + "must have at least 6 characters");

	}

	@Test
	public void Register_06_Inccorect_Confirm_Password() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox(firstName);
		registerPage.inputLastNameToTextbox(lastName);
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox(password);
		registerPage.inputConfirmPasswordToTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorText(), "The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
