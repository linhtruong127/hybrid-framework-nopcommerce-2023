package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.AddressesPageObject;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.OrdersPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointsPageObject;

public class Level_09_Page_Navigation extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private AddressesPageObject addressesPage;
	private OrdersPageObject ordersPage;
	private RewardPointsPageObject rewardPointsPage;
	private ChangePasswordPageObject changePasswordPage;
	private String emailAddress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void User_01_Register_Success() {
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
	public void User_02_Login_Success() {
		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");

		homePage = loginPage.clickToUserLoginButton();

		customerPage = homePage.clickToMyaccountLink();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Lisa");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Truong");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

	}

	@Test
	public void User_03_Switch_Page() {
		// Customer Page to Addresses Page
		addressesPage = customerPage.openAddressesPage();

		// Addresses Page to Orders Page
		ordersPage = addressesPage.openOrdersPage();

		// Orders Page to Customer Page
		customerPage = ordersPage.openCustomerInfoPage();

		// Customer Page to Reward Points Page
		rewardPointsPage = customerPage.openRewardPointsPage();
		
		// Reward Points Page to Change password Page
		changePasswordPage = rewardPointsPage.openChangePasswordPage();
		
		// Change password Page to Customer Page
		customerPage = changePasswordPage.openCustomerInfoPage();
		
		// Customer Page to

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
