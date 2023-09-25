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

public class Level_15_Assert_Verify extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	private String emailAddress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void User_01_Register_Success() {
		verifyFalse(homePage.isRegisterLinkDisplayed());
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getFirstNameErrorText(), "First name is required.");
		verifyEquals(registerPage.getLastNameErrorText(), "Last name is required");

		registerPage.inputFirstNameToTextbox("Lisa");
		registerPage.inputLastNameToTextbox("Truong");
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox("123456");
		registerPage.inputConfirmPasswordToTextbox("123456");

		registerPage.clickToRegisterButton();

		verifyEquals(registerPage.getRegistrationSuccessText(), "Your registration completed..");

	}


	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
