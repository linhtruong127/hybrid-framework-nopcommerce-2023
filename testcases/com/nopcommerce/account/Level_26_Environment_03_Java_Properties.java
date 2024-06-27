package com.nopcommerce.account;

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
import utilities.PropertiesConfig;

@Epic("Account")
@Feature("Create Account")

public class Level_26_Environment_03_Java_Properties extends BaseTest {
	
	private PropertiesConfig propertiesConfig;
	
		
	
	WebDriver driver;
	@Parameters({"browser", "server"})
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		propertiesConfig = PropertiesConfig.getProperties(serverName);
		driver = getBrowserDriver(browserName, propertiesConfig.getApplicationUrl());
		
		System.out.println(propertiesConfig.getApplicationUrl());
		System.out.println(propertiesConfig.getApplicationUserName());
		System.out.println(propertiesConfig.getApplicationPassword());


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
		//closeBrowser();
	}	
}
