package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.SearchPageObject;
import pageObjects.user.UserLoginPageObject;

public class NopCommerce_04_Search_AdvancedSearch extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private UserLoginPageObject loginPage;
	private SearchPageObject searchPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(Common_Register.emailAddress);
		loginPage.enterToPasswordTextbox(Common_Register.password);
		homePage = loginPage.clickToUserLoginButton();
	}

	@Test
	public void Search_01_With_Empty_Data() {
		searchPage = homePage.clickToSearchLink();
		searchPage.clickToSearchButton();

		Assert.assertEquals(searchPage.getWarningMessage(), "Search term minimum length is 3 characters");

	}

	@Test
	public void Search_02_With_Not_Exist_Data() {
		searchPage = homePage.clickToSearchLink();
		searchPage.inputValueToSearchTextbox("MacBook Pro 20250");
		searchPage.clickToSearchButton();

		Assert.assertEquals(searchPage.getErrorSearchMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_03_With_Partial_Product_Name() {
		searchPage = homePage.clickToSearchLink();
		searchPage.inputValueToSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.getAllSearchingResult("Lenovo"));

	}

	@Test
	public void Search_04_With_Exact_Product_Name() {
		searchPage.inputValueToSearchTextbox("ThinkPad X1 Carbon");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.getAllSearchingResult("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void Search_05_With_Parent_Categories() {
		searchPage.inputValueToSearchTextbox("Apple MacBook Pro");
		searchPage.clickToAdvancedSearch();
		searchPage.selectCategoryDropdown("Computers");
		
		searchPage.clickToSearchButton();

		Assert.assertEquals(searchPage.getErrorSearchMessage(), "No products were found that matched your criteria.");
		
		
	}

	@Test
	public void Search_06_With_Sub_Categories() {
		searchPage = homePage.clickToSearchLink();
		searchPage.inputValueToSearchTextbox("Apple MacBook Pro");
		searchPage.clickToAdvancedSearch();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.clickToAutomaticSearch();
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.getAllSearchingResult("Apple MacBook Pro 13"));
	
	}

	@Test
	public void Search_07_With_Incorrect_Manufacturer() {
		searchPage = homePage.clickToSearchLink();
		searchPage.inputValueToSearchTextbox("Apple MacBook Pro");
		searchPage.clickToAdvancedSearch();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.clickToAutomaticSearch();
		searchPage.selectManufacturerDropdown("HP");
		
		searchPage.clickToSearchButton();

		Assert.assertEquals(searchPage.getErrorSearchMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_08_With_Correct_Manufacturer() {
		searchPage = homePage.clickToSearchLink();
		searchPage.inputValueToSearchTextbox("Apple MacBook Pro");
		searchPage.clickToAdvancedSearch();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.clickToAutomaticSearch();
		searchPage.selectManufacturerDropdown("Apple");
		
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.getAllSearchingResult("Apple MacBook Pro 13"));

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
