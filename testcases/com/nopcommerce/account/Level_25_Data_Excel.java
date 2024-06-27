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
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;
import utilities.ExcelConfig;

@Epic("Account")
@Feature("Create Account")

public class Level_25_Data_Excel extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private String email, firstName, lastName, password;
	private ExcelConfig excelConfig;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		excelConfig = ExcelConfig.getExcelData();
		excelConfig.switchToSheet("UserData");
		
		firstName = excelConfig.getCellData("FirstName", 1);
		lastName = excelConfig.getCellData("LastName", 1);
		password = excelConfig.getCellData("Password", 1);
		email = getEmailRandom(excelConfig.getCellData("Email", 1));

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

	@Description("User_02_Register_Success")
	@Story("Register Success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void User_02_Register_Success() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToDynamicTextbox("FirstName", firstName);
		registerPage.inputToDynamicTextbox("LastName", lastName);
		registerPage.inputToDynamicTextbox("Email", email);
		registerPage.inputToDynamicTextbox("Password", password);
		registerPage.inputToDynamicTextbox("ConfirmPassword", password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegistrationSuccessText(), "Your registration completed");

	}

	@Description("User_03_Login_Success")
	@Story("Login Success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void User_03_Login_Success() {

		homePage = registerPage.clickToLogoLink();

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToDynamicTextbox("Email", email);
		loginPage.inputToDynamicTextbox("Password", password);

		loginPage.clickToButtonByText("Log in");

		homePage.clickToHeaderLinkByPageText("My account");
		customerPage = PageGeneratorManager.getCustomerInfoPage(driver);

		Assert.assertEquals(customerPage.getDynamicAttributeValueByID("FirstName"), firstName);
		Assert.assertEquals(customerPage.getDynamicAttributeValueByID("LastName"), lastName);
		Assert.assertEquals(customerPage.getDynamicAttributeValueByID("Email"), email);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
