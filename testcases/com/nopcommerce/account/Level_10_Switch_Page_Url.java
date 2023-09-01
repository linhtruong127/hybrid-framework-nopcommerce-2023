package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_10_Switch_Page_Url extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String userUrl, adminUrl;
	private String emailAddress = getEmailRandom();

	@Parameters({ "browser", "userUrl", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_User_To_Admin() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox("Lisa");
		registerPage.inputLastNameToTextbox("Truong");
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox("123456");
		registerPage.inputConfirmPasswordToTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");
		userLoginPage = homePage.clickToLoginLink();

		homePage = userLoginPage.loginToUser(emailAddress, "123456");

		homePage.clickToLogOutLink();

		homePage.openPageURL(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginToAdmin("admin@yourstore.com", "admin");
		Assert.assertTrue(adminDashboardPage.isPageLoadedSucess(driver));
	}

	@Test
	public void User_02_Admin_To_User() {
		adminDashboardPage.clickToLogOutLink();
		adminLoginPage.openPageURL(driver, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		userLoginPage = homePage.clickToLoginLink();
		homePage = userLoginPage.loginToUser(emailAddress, "123456");

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
