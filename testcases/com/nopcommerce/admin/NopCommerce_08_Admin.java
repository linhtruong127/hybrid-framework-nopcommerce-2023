package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminProductsPageObject;
import pageObjects.admin.AdminCustomersPageObject;

public class NopCommerce_08_Admin extends BaseTest {
	private WebDriver driver;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminProductsPageObject adminProductsPage;
	private AdminCustomersPageObject adminCustomersPage;
	private String emailAddress, firstName, lastName, password, company, dateOfBirth;

	@Parameters({ "browser", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginToAdmin("admin@yourstore.com", "admin");
		Assert.assertTrue(adminDashboardPage.isPageLoadedSucess(driver));
		emailAddress = getEmailRandom();
		firstName = "Sophie";
		lastName = "Bell";
		password = "123456";
		company = "Forsys";
		dateOfBirth = "1/1/1980";

	}

	@Test
	public void Admin_01_Search_With_Product_Name() {
		adminDashboardPage.openDynamicSidebarMenuPage(driver, "Catalog");
		adminProductsPage = PageGeneratorManager.getAdminProductsPage(driver);

		adminProductsPage.openDynamicSidebarSubMenuPage(driver, "Products");
		adminProductsPage.inputValueToProductNameTextbox("Lenovo Thinkpad X1 Carbon Laptop");
		adminProductsPage.clickToSearchButton();

		Assert.assertEquals(adminProductsPage.getSearchingResultPageSize(), 1);
		Assert.assertTrue(adminProductsPage.getSearchingResult("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	// @Test
	public void Admin_02_Search_With_Product_Name_And_Parent_Category_Unchecked() {
		adminProductsPage.refreshCurrentPage(driver);
		adminProductsPage.openDynamicSidebarSubMenuPage(driver, "Products");
		adminProductsPage.inputValueToProductNameTextbox("Lenovo Thinkpad X1 Carbon Laptop");
		adminProductsPage.selectItemInDropdownListBySearchID("SearchCategoryId", "Computers");
		adminProductsPage.clickToSearchButton();

		Assert.assertEquals(adminProductsPage.getNoDataMessage(), "No data available in table");

	}

	// @Test
	public void Admin_03_Search_With_Product_Name_And_Parent_Category_Checked() {
		adminProductsPage.refreshCurrentPage(driver);
		adminProductsPage.openDynamicSidebarSubMenuPage(driver, "Products");
		adminProductsPage.inputValueToProductNameTextbox("Lenovo Thinkpad X1 Carbon Laptop");
		adminProductsPage.selectItemInDropdownListBySearchID("SearchCategoryId", "Computers");
		adminProductsPage.checkToSearchSubcategories();
		adminProductsPage.clickToSearchButton();
		adminProductsPage.sleepInSecond(2);
		Assert.assertEquals(adminProductsPage.getSearchingResultPageSize(), 1);
		Assert.assertTrue(adminProductsPage.getSearchingResult("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	// @Test
	public void Admin_04_Search_With_Product_Name_And_Child_Category() {
		adminProductsPage.refreshCurrentPage(driver);
		adminProductsPage.openDynamicSidebarSubMenuPage(driver, "Products");
		adminProductsPage.inputValueToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");
		adminProductsPage.selectItemInDropdownListBySearchID("SearchCategoryId", "Computers >> Desktops");
		adminProductsPage.clickToSearchButton();
		adminProductsPage.sleepInSecond(2);
		Assert.assertEquals(adminProductsPage.getSearchingResultPageSize(), 1);
		Assert.assertTrue(adminProductsPage.getSearchingResult("Lenovo IdeaCentre 600 All-in-One PC"));
	}

	// @Test
	public void Admin_05_Search_With_Product_Name_And_Manufacturer() {
		adminProductsPage.refreshCurrentPage(driver);
		adminProductsPage.openDynamicSidebarSubMenuPage(driver, "Products");
		adminProductsPage.inputValueToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");
		adminProductsPage.selectItemInDropdownListBySearchID("SearchCategoryId", "All");
		adminProductsPage.selectItemInDropdownListBySearchID("SearchManufacturerId", "Apple");

		adminProductsPage.clickToSearchButton();

		Assert.assertEquals(adminProductsPage.getNoDataMessage(), "No data available in table");
	}

	// @Test
	public void Admin_06_Go_Direct_To_Product_SKU() {
		adminProductsPage.refreshCurrentPage(driver);
		adminProductsPage.openDynamicSidebarSubMenuPage(driver, "Products");
		adminProductsPage.inputValueToGoDirectlyToProductSKU("LE_IC_600");
		adminProductsPage.clickGoButton();

		Assert.assertEquals(adminProductsPage.getProductNameInfo(), "Edit product details - Lenovo IdeaCentre 600 All-in-One PC back to product list");
	}

	@Test
	public void Admin_07_Create_New_Customer() {
		adminProductsPage.openDynamicSidebarMenuPage(driver, "Customers");
		adminCustomersPage = PageGeneratorManager.getAdminCustomersPage(driver);

		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");

		adminCustomersPage.clickToAddNewButton();

		adminCustomersPage.inputCustomerInfoByID("Email", emailAddress);

		adminCustomersPage.inputCustomerInfoByID("Password", password);

		adminCustomersPage.inputCustomerInfoByID("FirstName", firstName);
		adminCustomersPage.inputCustomerInfoByID("LastName", lastName);
		adminCustomersPage.selectGenderInfo("Gender_Female");
		adminCustomersPage.inputCustomerInfoByID("DateOfBirth", dateOfBirth);
		adminCustomersPage.inputCustomerInfoByID("Company", company);
		// adminCustomersPage.selectCustomerRolesInDropdownList("Guests");
		adminCustomersPage.inputToAdminCommentTextBox("Add new customer(guest)");
		adminCustomersPage.clickToSaveAndContinueButton();

		Assert.assertTrue(adminCustomersPage.isAddCustomerSuccessMsgDisplayed(), "\n" + "The new customer has been added successfully.");

		Assert.assertEquals(adminCustomersPage.getAttributeOfCustomerInfo("Email"), emailAddress);
		Assert.assertEquals(adminCustomersPage.getAttributeOfCustomerInfo("FirstName"), firstName);
		Assert.assertEquals(adminCustomersPage.getAttributeOfCustomerInfo("LastName"), lastName);
		Assert.assertEquals(adminCustomersPage.getAttributeOfCustomerInfo("Gender_Female"), "F");
		Assert.assertEquals(adminCustomersPage.getAttributeOfCustomerInfo("DateOfBirth"), dateOfBirth);
		Assert.assertEquals(adminCustomersPage.getAttributeOfCustomerInfo("Company"), company);
		Assert.assertTrue(adminCustomersPage.isAttributeOfCustomerRolesDisplayed("Registered", "Registered"));
		Assert.assertEquals(adminCustomersPage.getAttributeOfCustomerInfo("Active"), "true");
		Assert.assertEquals(adminCustomersPage.getAttributeOfAdminComment(), "Add new customer(guest)");

		adminCustomersPage.clickToBackToCustomerListButton();
		adminCustomersPage.clickToSearchText();
		Assert.assertTrue(adminCustomersPage.isAttributeOnCustomerListDisplayed(firstName + " " + lastName, firstName + " " + lastName));
		Assert.assertTrue(adminCustomersPage.isAttributeOnCustomerListDisplayed(company, company));

	}

	@Test
	public void Admin_08_Search_Customer_With_Email() {
		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");
		adminCustomersPage.clickToSearchText();
		adminCustomersPage.inputCustomerInfoByID("SearchEmail", emailAddress);
		// adminCustomersPage.selectCustomerRolesInDropdownList("Guests");
		adminCustomersPage.clickToSearchButton();
		Assert.assertEquals(adminCustomersPage.getCustomerResultPageSize(), 1);

	}

	@Test
	public void Admin_09_Search_Customer_With_FirstName_And_LastName() {
		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");
		adminCustomersPage.inputCustomerInfoByID("SearchFirstName", firstName);
		adminCustomersPage.inputCustomerInfoByID("SearchLastName", lastName);
		// adminCustomersPage.selectCustomerRolesInDropdownList("Guests");
		adminCustomersPage.clickToSearchButton();
		Assert.assertEquals(adminCustomersPage.getCustomerResultPageSize(), 1);
	}

	@Test
	public void Admin_10_Search_Customer_With_Company() {
		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");
		adminCustomersPage.inputCustomerInfoByID("SearchCompany", company);
		// adminCustomersPage.selectCustomerRolesInDropdownList("Guests");
		adminCustomersPage.clickToSearchButton();
		Assert.assertEquals(adminCustomersPage.getCustomerResultPageSize(), 1);
	}

	@Test
	public void Admin_11_Search_Customer_With_Full_Data() {
		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");
		adminCustomersPage.inputCustomerInfoByID("SearchFirstName", firstName);
		adminCustomersPage.inputCustomerInfoByID("SearchLastName", lastName);

		adminCustomersPage.inputCustomerInfoByID("SearchEmail", emailAddress);
		adminCustomersPage.inputDOBInfo("SearchMonthOfBirth", "1");
		adminCustomersPage.inputDOBInfo("SearchDayOfBirth", "1");

		adminCustomersPage.inputCustomerInfoByID("SearchCompany", company);
		// adminCustomersPage.selectCustomerRolesInDropdownList("Guests");
		adminCustomersPage.clickToSearchButton();
		Assert.assertEquals(adminCustomersPage.getCustomerResultPageSize(), 1);

	}

	@Test
	public void Admin_12_Edit_Customer() {
		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");
		// adminCustomersPage.clickToSearchText();
		adminCustomersPage.inputCustomerInfoByID("SearchFirstName", firstName);
		adminCustomersPage.inputCustomerInfoByID("SearchLastName", lastName);

		adminCustomersPage.inputCustomerInfoByID("SearchEmail", emailAddress);
		adminCustomersPage.inputDOBInfo("SearchMonthOfBirth", "1");
		adminCustomersPage.inputDOBInfo("SearchDayOfBirth", "1");

		adminCustomersPage.inputCustomerInfoByID("SearchCompany", company);
		// adminCustomersPage.selectCustomerRolesInDropdownList("Guests");
		adminCustomersPage.clickToSearchButton();
		adminCustomersPage.clickToEditButton();

		adminCustomersPage.inputCustomerInfoByID("Email", "automationfc@gmail.com");

		adminCustomersPage.inputCustomerInfoByID("FirstName", "Automation");
		adminCustomersPage.inputCustomerInfoByID("LastName", "FC");
		adminCustomersPage.inputCustomerInfoByID("DateOfBirth", "2/2/1980");
		adminCustomersPage.inputCustomerInfoByID("Company", "Calif");
		adminCustomersPage.inputToAdminCommentTextBox("Edit customer Automation");
		adminCustomersPage.clickToSaveButton();

		Assert.assertTrue(adminCustomersPage.isAddCustomerSuccessMsgDisplayed(), "\n" + "The customer has been updated successfully.");
		adminCustomersPage.inputCustomerInfoByID("SearchEmail", "automationfc@gmail.com");
		adminCustomersPage.inputCustomerInfoByID("SearchFirstName", "Automation");
		adminCustomersPage.inputCustomerInfoByID("SearchLastName", "FC");
		adminCustomersPage.inputDOBInfo("SearchMonthOfBirth", "2");
		adminCustomersPage.inputDOBInfo("SearchDayOfBirth", "2");
		adminCustomersPage.inputCustomerInfoByID("SearchCompany", "Calif");
		adminCustomersPage.clickToSearchButton();
		Assert.assertEquals(adminCustomersPage.getCustomerResultPageSize(), 1);
	}

	@Test
	public void Admin_13_Add_New_Address_In_Customer_Details() {
		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");
		adminCustomersPage.inputCustomerInfoByID("SearchFirstName", "Automation");
		adminCustomersPage.inputCustomerInfoByID("SearchLastName", "FC");

		adminCustomersPage.inputCustomerInfoByID("SearchEmail", "automationfc@gmail.com");
		adminCustomersPage.inputDOBInfo("SearchMonthOfBirth", "2");
		adminCustomersPage.inputDOBInfo("SearchDayOfBirth", "2");

		adminCustomersPage.inputCustomerInfoByID("SearchCompany", "Calif");
		adminCustomersPage.clickToSearchButton();
		adminCustomersPage.clickToEditButton();
		adminCustomersPage.clickToAddressesButton();
		adminCustomersPage.clickToAddNewAddressButton();
		adminCustomersPage.inputNewAddressInfo("Address_FirstName", firstName);
		adminCustomersPage.inputNewAddressInfo("Address_LastName", lastName);
		adminCustomersPage.inputNewAddressInfo("Address_Email", emailAddress);
		adminCustomersPage.inputNewAddressInfo("Address_Company", company);
		adminCustomersPage.selectCountryForNewAddressInfo("Viet Nam");
		adminCustomersPage.inputNewAddressInfo("Address_City", "HCM");
		adminCustomersPage.inputNewAddressInfo("Address_Address1", "68 Boulevard Barbès");
		adminCustomersPage.inputNewAddressInfo("Address_Address2", "123 Le Loi");
		adminCustomersPage.inputNewAddressInfo("Address_ZipPostalCode", "70000");
		adminCustomersPage.inputNewAddressInfo("Address_PhoneNumber", "123456789");
		adminCustomersPage.inputNewAddressInfo("Address_FaxNumber", "22334455");
		adminCustomersPage.clickToSaveButtonOnAddNewAddress();
		Assert.assertTrue(adminCustomersPage.isAddNewAddressSuccessMsgDisplayed(), "\n" + "The new address has been added successfully.");
		adminCustomersPage.clickToBackToCustomerDetailsButton();

		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed(firstName));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed(lastName));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed(emailAddress));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed("123456789"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed("22334455"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressColumnDisplayed(company));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressColumnDisplayed("68 Boulevard Barbès"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressColumnDisplayed("123 Le Loi"));

	}

	@Test
	public void Admin_14_Edit_Address_In_Customer_Details() {
		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");
		adminCustomersPage.inputCustomerInfoByID("SearchFirstName", "Automation");
		adminCustomersPage.inputCustomerInfoByID("SearchLastName", "FC");

		adminCustomersPage.inputCustomerInfoByID("SearchEmail", "automationfc@gmail.com");
		adminCustomersPage.inputDOBInfo("SearchMonthOfBirth", "2");
		adminCustomersPage.inputDOBInfo("SearchDayOfBirth", "2");

		adminCustomersPage.inputCustomerInfoByID("SearchCompany", "Calif");
		adminCustomersPage.clickToSearchButton();
		adminCustomersPage.clickToEditButton();
		// adminCustomersPage.clickToAddressesButton();
		adminCustomersPage.clickToEditButton();

		adminCustomersPage.inputNewAddressInfo("Address_FirstName", "Automation");
		adminCustomersPage.inputNewAddressInfo("Address_LastName", "FC");
		adminCustomersPage.inputNewAddressInfo("Address_Email", "automationfc1@gmail.com");
		adminCustomersPage.inputNewAddressInfo("Address_Company", "QWE");
		adminCustomersPage.selectCountryForNewAddressInfo("Viet Nam");
		adminCustomersPage.inputNewAddressInfo("Address_City", "HCM");
		adminCustomersPage.inputNewAddressInfo("Address_Address1", "68 Boulevard");
		adminCustomersPage.inputNewAddressInfo("Address_Address2", "456 Le Loi");
		adminCustomersPage.inputNewAddressInfo("Address_ZipPostalCode", "70000");
		adminCustomersPage.inputNewAddressInfo("Address_PhoneNumber", "123456789");
		adminCustomersPage.inputNewAddressInfo("Address_FaxNumber", "22334455");
		adminCustomersPage.clickToSaveButton();
		Assert.assertTrue(adminCustomersPage.isAddNewAddressSuccessMsgDisplayed(), "\n" + "The address has been updated successfully.");
		adminCustomersPage.clickToBackToCustomerDetailsButton();

		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed("Automation"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed("FC"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed("automationfc1@gmail.com"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed("123456789"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressesDisplayed("22334455"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressColumnDisplayed("QWE"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressColumnDisplayed("68 Boulevard"));
		Assert.assertTrue(adminCustomersPage.isAttributeOnAddressColumnDisplayed("456 Le Loi"));

	}

	@Test
	public void Admin_15_Delete_Address_In_Customer_Details() {
		adminCustomersPage.openDynamicSidebarSubMenuPage(driver, "Customers");
		adminCustomersPage.inputCustomerInfoByID("SearchFirstName", "Automation");
		adminCustomersPage.inputCustomerInfoByID("SearchLastName", "FC");

		adminCustomersPage.inputCustomerInfoByID("SearchEmail", "automationfc@gmail.com");
		adminCustomersPage.inputDOBInfo("SearchMonthOfBirth", "2");
		adminCustomersPage.inputDOBInfo("SearchDayOfBirth", "2");

		adminCustomersPage.inputCustomerInfoByID("SearchCompany", "Calif");
		adminCustomersPage.clickToSearchButton();
		adminCustomersPage.clickToEditButton();
		// adminCustomersPage.clickToAddressesButton();
		adminCustomersPage.clickToDeleteButton();
		adminCustomersPage.acceptToAlert(driver);
		Assert.assertTrue(adminCustomersPage.isNoDataTextDisplayed(), "No data available in table");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
