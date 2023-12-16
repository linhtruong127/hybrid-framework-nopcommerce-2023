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

public class NopCommerce_05_Sort_Display_Paging extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		homePage.clickToProductMenu("Computers ");
		homePage.clickToSubProductName("Notebooks ");
	}

	@Test
	public void Sorting_01_Product_Name_From_A_To_Z() {
		homePage.selectSortType("Name: A to Z");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isResultDisplayedAsAscendingOrder());

	}

	@Test
	public void Sorting_02_Product_Name_From_Z_To_A() {
		homePage.selectSortType("Name: Z to A");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isResultDisplayedAsDescendingOrder());
	}

	@Test
	public void Sorting_03_Product_Price_From_Low_To_High() {
		homePage.selectSortType("Price: Low to High");

		Assert.assertTrue(homePage.isPricesDisplayedLowToHigh());
	}

	@Test
	public void Sorting_04_Product_Price_From_High_To_Low() {
		homePage.selectSortType("Price: High to Low");

		Assert.assertTrue(homePage.isPricesDisplayedHighToLow());
	}

	@Test
	public void Sorting_05_Display_3_Product_Per_Page() {
		homePage.selectThePagesizeToDisplay("3");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.getPageSize() <= 3);
		Assert.assertTrue(homePage.isNextIconDisplayed());

		homePage.clickToNextPage();
		Assert.assertTrue(homePage.isPreviousIconDisplayed());
	}

	@Test
	public void Sorting_06_Display_6_Product_Per_Page() {
		homePage.selectThePagesizeToDisplay("6");

		Assert.assertTrue(homePage.getPageSize() <= 6);
		Assert.assertTrue(homePage.isPagingBarNotDisplayed());

	}

	@Test
	public void Sorting_07_Display_9_Product_Per_Page() {

		homePage.selectThePagesizeToDisplay("9");

		Assert.assertTrue(homePage.getPageSize() <= 9);
		Assert.assertTrue(homePage.isPagingBarNotDisplayed());

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
