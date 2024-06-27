package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageUIs.orangehrm.PersonalDetailsPageUI;
import pojoData.orangeHRM.EmployeeInfo;

public class PersonalDetailsPageObject extends BaseActions {
	WebDriver driver;
	public boolean getValueFirstNameTextbox;

	public PersonalDetailsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isHeaderTitleDisplayed(String headerTitle) {
		waitForSpinIconDissapear();
		waitForElementVisible(driver, PersonalDetailsPageUI.HEADER_PERSONAL_DETAILS, headerTitle);
		return isElementDisplayed(driver, PersonalDetailsPageUI.HEADER_PERSONAL_DETAILS, headerTitle);
	}

	@Step("Get Value First Name")
	public String getValueFirstNameTextbox() {
		waitForElementVisible(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	@Step("Get Value Last Name")
	public String getValueLastNameTextbox() {
		waitForElementVisible(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX, "value");
	}

	@Step("Get Value Employee ID")
	public String getValueEmployeeIDTextbox() {
		waitForElementVisible(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX, "value");
	}

	@Step("Click to Employee List Button")
	public EmployeeListPageObject clickToEmployeeListButton() {
		waitForElementClickable(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		return PageGeneratorManager.getEmployeeListPage(driver);

	}

	public void enterToDriverLicenseNumberTextbox(String driverLicenseNumber) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_BY_LABEL);
		sendkeyToElement(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_BY_LABEL, driverLicenseNumber);

	}

	public void enterToLicenseExpiryDatePicker(String licenseExpiryDate) {
		waitForElementVisible(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_DATE_BY_LABEL);
		sendkeyToElement(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_DATE_BY_LABEL, licenseExpiryDate);

	}

	public void selectNationality(String nationality) {
		waitForElementClickable(driver, PersonalDetailsPageUI.NATIONAL_DROPDOWN_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.NATIONAL_DROPDOWN_PARENT, PersonalDetailsPageUI.NATIONAL_DROPDOWN_CHILD, nationality);
	}

	public void selectMaritalStatus(String maritalStatus) {
		waitForElementClickable(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);

	}

	public void enterToDateOfBirthDatePicker(String dateOfBirth) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_BY_LABEL);
		sendkeyToElement(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_BY_LABEL, dateOfBirth);

	}

	public void clickToSaveButtonAtPersonalDetails() {
		waitForElementClickable(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAILS);
		clickToElement(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAILS);

	}

	public String getNationalityAtPersonalDetails() {
		waitForElementVisible(driver, PersonalDetailsPageUI.NATIONAL_DROPDOWN_SELECTED_ITEM);
		return getElementText(driver, PersonalDetailsPageUI.NATIONAL_DROPDOWN_SELECTED_ITEM);
	}

	public String getMaritalStatusAtPersonalDetails() {
		waitForElementVisible(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_SELECTED_ITEM);
		return getElementText(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_SELECTED_ITEM);
	}

	public void setPersonalDetailsForm(EmployeeInfo employeeInfo) {
		enterToDriverLicenseNumberTextbox(employeeInfo.getDriverLicenseNumber());
		enterToLicenseExpiryDatePicker(employeeInfo.getLicenseExpiryDate());
		selectNationality(employeeInfo.getNationality());
		selectMaritalStatus(employeeInfo.getMaritalStatus());
		enterToDateOfBirthDatePicker(employeeInfo.getDateOfBirth());
		clickRadioButtonToSelectGenderStatus(employeeInfo.getGender());

	}

}