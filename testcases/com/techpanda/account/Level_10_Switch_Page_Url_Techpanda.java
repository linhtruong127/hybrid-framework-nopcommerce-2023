package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageTechpandaObject.user.PageGeneratorManager;

public class Level_10_Switch_Page_Url_Techpanda extends BaseTest {
	private WebDriver driver;

	private pageTechpandaObject.user.HomePageObject homePage;
	private pageTechpandaObject.user.RegisterPageObject registerPage;
	private pageTechpandaObject.user.UserLoginPageObject userLoginPage;
	private pageTechpandaObjects.admin.AdminLoginPageObject adminLoginPage;
	private pageTechpandaObjects.admin.AdminDashboardPageObject adminDashboardPage;
	private String adminUrl;
	private String emailAddress = getEmailRandom();

	@Parameters({ "browser", "userUrl", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		this.adminUrl = adminUrl;
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Switch_From_User_To_Admin() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameToTextbox("Lisa");
		registerPage.inputLastNameToTextbox("Truong");
		registerPage.inputEmailToTextbox(emailAddress);
		registerPage.inputPasswordToTextbox("123456");
		registerPage.inputConfirmPasswordToTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Thank you for registering with Main Website Store.");

		homePage.clickToLogOutLink();

		userLoginPage = homePage.clickToLoginLink();
		homePage = userLoginPage.loginToUser(emailAddress, "123456");

		homePage.openPageURL(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginToAdmin("user01", "guru99com");

		adminDashboardPage.clickToClosePopup();
		
	}
	
	@Test
	public void User_02_Verify_Account_Display_On_Admin_Page() {
		adminDashboardPage.inputToEmailTextbox(emailAddress);
		adminDashboardPage.clickToSearchButton();
		adminDashboardPage.sleepInSecond(3);
		
		
		Assert.assertTrue(adminDashboardPage.getSuccessRegisteredInfo("4"), emailAddress);
		Assert.assertTrue(adminDashboardPage.getSuccessRegisteredInfo("3"), "Lisa Truong");
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
