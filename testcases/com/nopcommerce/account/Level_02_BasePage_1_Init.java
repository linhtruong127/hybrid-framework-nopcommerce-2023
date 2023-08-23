package com.nopcommerce.account;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_1_Init {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private BasePage basePage = new BasePage();

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webDriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Register_01_Empty_Data() {
		basePage.openPageURL(driver, "https://demo.nopcommerce.com/");
		basePage.clickToElement(driver, "//a[@class=\"ico-register\"]");
		basePage.clickToElement(driver, "//button[@id=\"register-button\"]");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id=\"FirstName-error\"]"), "First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id=\"LastName-error\"]"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id=\"Email-error\"]"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id=\"Password-error\"]"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id=\"ConfirmPassword-error\"]"), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		basePage.openPageURL(driver, "https://demo.nopcommerce.com/");
		basePage.clickToElement(driver, "//a[@class=\"ico-register\"]");

		basePage.sendkeyToElement(driver, "//input[@id=\"FirstName\"]", "Lisa");
		basePage.sendkeyToElement(driver, "//input[@id=\"LastName\"]", "Truong");
		basePage.sendkeyToElement(driver, "//input[@id=\"Email\"]", "lisa@truong@gmail.com");
		basePage.sendkeyToElement(driver, "//input[@id=\"Password\"]", "123456");
		basePage.sendkeyToElement(driver, "//input[@id=\"ConfirmPassword\"]", "123456");

		basePage.clickToElement(driver, "//button[@id=\"register-button\"]");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id=\"Email-error\"]"), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {
		basePage.openPageURL(driver, "https://demo.nopcommerce.com/");
		basePage.clickToElement(driver, "//a[@class=\"ico-register\"]");

		basePage.sendkeyToElement(driver, "//input[@id=\"FirstName\"]", "Lisa");
		basePage.sendkeyToElement(driver, "//input[@id=\"LastName\"]", "Truong");
		basePage.sendkeyToElement(driver, "//input[@id=\"Email\"]", "lisatruong@gmail.com");
		basePage.sendkeyToElement(driver, "//input[@id=\"Password\"]", "123");
		basePage.sendkeyToElement(driver, "//input[@id=\"ConfirmPassword\"]", "123456");

		basePage.clickToElement(driver, "//button[@id=\"register-button\"]");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id=\"Password-error\"]"), "Password must meet the following rules:\n" + "must have at least 6 characters");

	}

	@Test
	public void Register_04_Inccorect_Confirm_Password() {
		basePage.openPageURL(driver, "https://demo.nopcommerce.com/");
		basePage.clickToElement(driver, "//a[@class=\"ico-register\"]");

		basePage.sendkeyToElement(driver, "//input[@id=\"FirstName\"]", "Lisa");
		basePage.sendkeyToElement(driver, "//input[@id=\"LastName\"]", "Truong");
		basePage.sendkeyToElement(driver, "//input[@id=\"Email\"]", "lisatruong@gmail.com");
		basePage.sendkeyToElement(driver, "//input[@id=\"Password\"]", "123456");
		basePage.sendkeyToElement(driver, "//input[@id=\"ConfirmPassword\"]", "123");

		basePage.clickToElement(driver, "//button[@id=\"register-button\"]");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id=\"ConfirmPassword-error\"]"), "The password and confirmation password do not match.");

	}

	@Test
	public void Register_05_Success() {
		basePage.openPageURL(driver, "https://demo.nopcommerce.com/");
		basePage.clickToElement(driver, "//a[@class=\"ico-register\"]");

		basePage.sendkeyToElement(driver, "//input[@id=\"FirstName\"]", "Lisa");
		basePage.sendkeyToElement(driver, "//input[@id=\"LastName\"]", "Truong");
		basePage.sendkeyToElement(driver, "//input[@id=\"Email\"]", "linhmy127@yahoo.com");
		basePage.sendkeyToElement(driver, "//input[@id=\"Password\"]", "123456");
		basePage.sendkeyToElement(driver, "//input[@id=\"ConfirmPassword\"]", "123456");

		basePage.clickToElement(driver, "//button[@id=\"register-button\"]");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class=\"result\"]"), "Your registration completed");

	}

	@AfterClass
	public void afterClass() {
	}

}
