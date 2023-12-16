package com.nopcommerce.login;

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

public class NopCommerce_02_Login extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();

	}

	@Test
	public void Login_01_Empty_Data() {
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
		loginPage.loginToUser(Common_Register.emailAddress, "");

		Assert.assertEquals(loginPage.getLoginErrorText(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void Login_05_Valid_Email_And_Wrong_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.loginToUser(Common_Register.emailAddress, "123");

		Assert.assertEquals(loginPage.getLoginErrorText(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_And_Valid_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(Common_Register.emailAddress);
		loginPage.enterToPasswordTextbox(Common_Register.password);

		homePage = loginPage.clickToUserLoginButton();

		homePage.refreshCurrentPage(driver);

		customerPage = homePage.clickToMyaccountLink();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), Common_Register.firstName);
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), Common_Register.lastName);
		Assert.assertEquals(customerPage.getEmailAttributeValue(), Common_Register.emailAddress);

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
