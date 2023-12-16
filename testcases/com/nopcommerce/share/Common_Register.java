package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Common_Register extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	public static String emailAddress, firstName, lastName, password, newPassword;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		emailAddress = getEmailRandom();
		firstName = "Lisa";
		lastName = "Truong";
		password = "123456";
		newPassword = "987654";
		
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox(firstName);
		registerPage.inputLastNameToTextbox(lastName);
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox(password);
		registerPage.inputConfirmPasswordToTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");

		closeBrowser();
	}
}
