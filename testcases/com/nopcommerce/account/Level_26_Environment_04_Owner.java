package com.nopcommerce.account;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.EnvironmentConfig;

@Epic("Account")
@Feature("Create Account")

public class Level_26_Environment_04_Owner extends BaseTest {
	private EnvironmentConfig environmentConfig;

	WebDriver driver;

	@Parameters({"browser", "server"})
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		ConfigFactory.setProperty("server", serverName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		

		System.out.println(environmentConfig.appUrl());
		System.out.println(environmentConfig.appUserName());
		System.out.println(environmentConfig.appPassword());
		System.out.println(environmentConfig.dbUrl());
		
		driver = getBrowserDriver(browserName, environmentConfig.appUrl());
	}

	@Description("User_01_Register_Validate")
	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register_Validate() {

	}

	@Description("User_02_Register_Success")
	@Story("Register Success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void User_02_Register_Success() {

	}

	@Description("User_03_Login_Success")
	@Story("Login Success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void User_03_Login_Success() {

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
