package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

@Epic("Account")
@Feature("Create Account")

public class Level_19_AllureReport extends BaseTest {
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
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		firstName = "Lisa";
		lastName = "Truong";
		password = "123456";

	}

	@Description("User_01_Register_Validate")
	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register_Validate() {

		Assert.assertTrue(homePage.isRegisterLinkDisplayed());

		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorText(), "First name is required.");

		Assert.assertEquals(registerPage.getLastNameErrorText(), "Last name is required.");

	}

	@Description("User_01_Register_Validate")
	@Story("Register")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void User_02_Register_Success() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox(firstName);

		registerPage.inputLastNameToTextbox(lastName);

		registerPage.inputEmailToTextbox(emailAddress);

		registerPage.inputPasswordToTextbox(password);

		registerPage.inputConfirmPasswordToTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
