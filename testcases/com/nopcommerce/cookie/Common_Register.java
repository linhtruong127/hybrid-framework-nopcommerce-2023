package com.nopcommerce.cookie;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class Common_Register extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static String emailAddress, firstName, lastName, password;
	public static Set<Cookie> cookies;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		emailAddress = getEmailRandom();
		firstName = "Lisa";
		lastName = "Truong";
		password = "123456";
		
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox(firstName);
		registerPage.inputLastNameToTextbox(lastName);
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox(password);
		registerPage.inputConfirmPasswordToTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");
		
		homePage = registerPage.clickToLogoLink();
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToUserLoginButton();
		
		loginPage.sleepInSecond(5);
	
		cookies = registerPage.getBrowserCookies(driver);
		closeBrowser();
	}
}
