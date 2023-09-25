package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Level_17_ReportNG extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	private String emailAddress = getEmailRandom();
	private String firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Lisa";
		lastName = "Truong";
		password = "123456";

	}

	@Test
	public void User_01_Register_Validate() {
		log.info("Register_Step 01: Verify Register link is displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());

		log.info("Register_Step 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register_Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_Step 04: Verify error message of 'First name' ");
		verifyEquals(registerPage.getFirstNameErrorText(), "First name is required.");

		log.info("Register_Step 05: Verify error message of 'Last name' ");
		verifyEquals(registerPage.getLastNameErrorText(), "Last name is required");

	}

	@Test
	public void User_02_Register_Success() {

		log.info("Register_Step 06: Enter to 'First name' textbox with value is " + firstName);
		registerPage.inputFirstNameToTextbox(firstName);

		log.info("Register_Step 07: Enter to 'Last name' textbox with value is " + lastName);
		registerPage.inputLastNameToTextbox(lastName);

		log.info("Register_Step 08: Enter to 'Email' textbox with value is " + emailAddress);
		registerPage.inputEmailToTextbox(emailAddress);

		log.info("Register_Step 09: Enter to 'Password' textbox with value is " + password);
		registerPage.inputPasswordToTextbox(password);

		log.info("Register_Step 10: Enter to 'Confirm Password' textbox with value is " + password);
		registerPage.inputConfirmPasswordToTextbox(password);

		log.info("Register_Step 11: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_Step 12: Verify registration is successful");
		verifyEquals(registerPage.getRegistrationSuccessText(), "Your registration completed..");

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
