package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsFacebook.register.PageGeneratorManager;
import pageObjectsFacebook.register.HomePageObject;

public class Level_20_Element_Undisplayed extends BaseTest {
	WebDriver driver;

	HomePageObject homePage;
	String emailAddress = getEmailRandom();

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Register_01_Element_Displayed_In_HTML() {

		homePage.clickToCreateNewAccount();
		verifyTrue(homePage.isFirstNameTextboxDisplay());
		verifyTrue(homePage.isLastNameTextboxDisplay());
		verifyTrue(homePage.isEmailTextboxDisplay());
		verifyTrue(homePage.isPasswordTextboxDisplay());

		homePage.enterToEmailTextbox(emailAddress);
		log.info("Verify Confirm Email textbox is displayed");
		verifyTrue(homePage.isConfirmEmailTextboxDisplay());
	}

	@Test
	public void Register_02_Element_Undisplayed_On_UI_but_Displayed_In_HTML() {
		homePage.enterToEmailTextbox("");
		homePage.sleepInSecond(3);

		log.info("Verify Confirm Email textbox is not displayed");
		verifyFalse(homePage.isConfirmEmailTextboxDisplay());

	}

	@Test
	public void Register_03_Element_Undisplayed_In_HTML() {
		homePage.clickToCloseSignupPopupButton();
		
		log.info("Verify First Name textbox is not displayed");
		verifyTrue(homePage.isFirstNameTextboxUnDisplay());
		
		log.info("Verify Last Name textbox is not displayed");
		verifyTrue(homePage.isLastNameTextboxUnDisplay());
		
		log.info("Verify Email textbox is not displayed");
		verifyTrue(homePage.isEmailTextboxUnDisplay());
		
		log.info("Verify Password textbox is not displayed");
		verifyTrue(homePage.isPasswordTextboxUnDisplay());
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
