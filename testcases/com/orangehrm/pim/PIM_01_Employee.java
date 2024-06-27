package com.orangehrm.pim;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.orangehrm.AddEmployeePageObject;
import pageObjects.orangehrm.DashboardPageObject;
import pageObjects.orangehrm.EmployeeListPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.PersonalDetailsPageObject;
import pojoData.orangeHRM.EmployeeInfo;

public class PIM_01_Employee extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private EmployeeListPageObject employeeListPage;
	private AddEmployeePageObject addEmployeePage;
	private DashboardPageObject dashBoardPage;
	private PersonalDetailsPageObject personalDetailsPage;
	private EmployeeInfo employeeInfo;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		loginPage = PageGeneratorManager.getHomePage(driver);
		loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGEHRM_USERNAME);
		loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);
		dashBoardPage = loginPage.clickToLoginButton();
		employeeListPage = dashBoardPage.openPIMModule();
		
		employeeInfo = EmployeeInfo.getEmployee();
		employeeInfo.setFirstName("Micheal");
		employeeInfo.setLastName("Owen");
		employeeInfo.setDriverLicenseNumber("123456789");
		employeeInfo.setLicenseExpiryDate("2024-12-01");
		employeeInfo.setNationality("American");
		employeeInfo.setMaritalStatus("Married");
		employeeInfo.setDateOfBirth("1983-01-01");
		employeeInfo.setGender("Male");
	}

	@Test
	public void Employee_01_Add_New() {
		addEmployeePage = employeeListPage.clickToAddEmployeeButton();
		addEmployeePage.enterToFirstnameTextbox(employeeInfo.getFirstName());
		addEmployeePage.enterToLastnameTextbox(employeeInfo.getLastName());
		employeeInfo.setEmployeeID(addEmployeePage.getEmployeeID());

		addEmployeePage.clickToSaveButton();
		Assert.assertTrue(addEmployeePage.isSuccessfulTextDisplayed("Successfully Saved"));
		addEmployeePage.waitForSpinIconDissapear();

		personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
		Assert.assertTrue(personalDetailsPage.isHeaderTitleDisplayed("Personal Details"));
		Assert.assertEquals(personalDetailsPage.getValueFirstNameTextbox(), employeeInfo.getFirstName());
		Assert.assertEquals(personalDetailsPage.getValueLastNameTextbox(), employeeInfo.getLastName());
		Assert.assertEquals(personalDetailsPage.getValueEmployeeIDTextbox(), employeeInfo.getEmployeeID());

		employeeListPage = personalDetailsPage.clickToEmployeeListButton();
		employeeListPage.enterValueToEmployeeIDTextbox(employeeInfo.getEmployeeID());
		employeeListPage.clickSearchButton();

		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Id", "1", employeeInfo.getEmployeeID()));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name", "1", employeeInfo.getFirstName()));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Last Name", "1", employeeInfo.getLastName()));

	}

	@Test
	public void Employee_02_Personal_Details() {
		personalDetailsPage = employeeListPage.clickToEditButtonByEmployeeId(employeeInfo.getEmployeeID());
		personalDetailsPage.waitForSpinIconDissapear();

		personalDetailsPage.setPersonalDetailsForm(employeeInfo);

		personalDetailsPage.clickToSaveButtonAtPersonalDetails();

		Assert.assertTrue(personalDetailsPage.isSuccessfulTextDisplayed("Successfully Updated"));
		personalDetailsPage.waitForSpinIconDissapear();

		Assert.assertTrue(personalDetailsPage.isHeaderTitleDisplayed("Personal Details"));
		Assert.assertEquals(personalDetailsPage.getNationalityAtPersonalDetails(), employeeInfo.getNationality());
		Assert.assertEquals(personalDetailsPage.getMaritalStatusAtPersonalDetails(), employeeInfo.getMaritalStatus());
		Assert.assertTrue(personalDetailsPage.isGenderStatusDisplayed(employeeInfo.getGender()));
	}

	@Test
	public void Employee_03_Contact_Details() {

	}

	@Test
	public void Employee_04_Emergency_Contact() {

	}

	@Test
	public void Employee_05_Dependents() {
	}

	@Test
	public void Employee_06_Immigration() {

	}

	@Test
	public void Employee_07_Job() {

	}

	@Test
	public void Employee_08_Salary() {

	}

	@Test
	public void Employee_09_Report() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
