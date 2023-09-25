package com.jquery.data;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageJqueryObject.data.HomePageObject;
import pageJqueryObject.data.PageGeneratorManager;

public class Level_13_Handle_Data_Table extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Search_Data_By_Column() {
		homePage.inputToHeaderFilter("Females", "384187");
		homePage.sleepInSecond(2);
		homePage.inputToHeaderFilter("Country", "Argentina");
		homePage.sleepInSecond(2);
		homePage.inputToHeaderFilter("Males", "295140");
		homePage.sleepInSecond(2);
		homePage.inputToHeaderFilter("Total", "49397");
		homePage.sleepInSecond(2);
	}

	@Test
	public void TC_02_Paging() {
		homePage.clickToPagingNumber("2");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveNumberDisplayed("2"));

		homePage.clickToPagingNumber("5");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveNumberDisplayed("5"));

		homePage.clickToPagingNumber("1");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveNumberDisplayed("1"));

	}

	@Test
	public void TC_03_Verify_Data_By_Row() {
		
		Assert.assertTrue(homePage.isRowValueDisplayed("24128", "Albania", "25266", "49397"));
		Assert.assertTrue(homePage.isRowValueDisplayed("384187", "Afghanistan", "407124", "791312"));
		
		homePage.clickToPagingNumber("18");
		homePage.inputToHeaderFilter("Country", "Reunion");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isRowValueDisplayed("6380", "Reunion", "6800", "13200"));
	}
	@Test
	public void TC_04_Click_To_Icon() {
		homePage.refreshCurrentPage(driver);
		homePage.clickToActionByIcon("AFRICA", "remove");
		homePage.sleepInSecond(2);
		
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToActionByIcon("Albania", "edit");
		homePage.sleepInSecond(2);
	}
	@Test
	public void TC_05_Select_All_Values_In_Column() {
		homePage.getAllValuesByColumnName("Country");
		homePage.sleepInSecond(2);
	
	}
	@Test
	public void TC_06_Actions_By_Row_And_Column_Index() {
		homePage.openPageURL(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid");
		homePage.enterToTextboxByRowAndColumnIndex("Company", "2", "ABC");
		homePage.enterToTextboxByRowAndColumnIndex("Contact Person", "3", "John Dolce");
		homePage.selectItemByRowAndColumnIndex("Country", "3", "Germany");
		
		homePage.checkToIconByRowAndColumnIndex("NPO?", "3");
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
