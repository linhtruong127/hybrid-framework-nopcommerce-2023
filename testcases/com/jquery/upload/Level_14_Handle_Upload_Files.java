package com.jquery.upload;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import graphql.Assert;
import pageJqueryObject.data.PageGeneratorManager;
import pageJqueryObject.data.UploadPageObject;

public class Level_14_Handle_Upload_Files extends BaseTest {
	private WebDriver driver;
	String DaLatCity = "DalatCity.jpg";
	String NhaTrangCity = "NhatrangCity.jpg";
	String DaNangCity = "DanangCity.jpg";
	
	String[] fileCities =  {"DalatCity.jpg", "NhatrangCity.jpg", "DanangCity.jpg"};

	private UploadPageObject uploadPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadPage = PageGeneratorManager.getUploadPage(driver);

	}

	//@Test
	public void TC_01_Upload_Single_File() {
		uploadPage.uploadMultipleFiles(driver, DaLatCity);
		uploadPage.sleepInSecond(2);
		
		uploadPage.uploadMultipleFiles(driver, NhaTrangCity);
		uploadPage.sleepInSecond(2);
		
		uploadPage.uploadMultipleFiles(driver, DaNangCity);
		uploadPage.sleepInSecond(2);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(DaLatCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(NhaTrangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(DaNangCity));
	
		uploadPage.clickToStartButtonEachFile();
		
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(DaLatCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(NhaTrangCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(DaNangCity));
	
	}
	@Test
	public void TC_02_Upload_Multiple_Files() {
		uploadPage.uploadMultipleFiles(driver, fileCities);
		uploadPage.sleepInSecond(2);

		Assert.assertTrue(uploadPage.isFileLoadedSuccess(DaLatCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(NhaTrangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(DaNangCity));
	
		uploadPage.clickToStartButtonEachFile();
		
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(DaLatCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(NhaTrangCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(DaNangCity));
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
