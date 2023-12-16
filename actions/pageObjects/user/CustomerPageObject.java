package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.CustomerPageUI;

public class CustomerPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");

	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");

	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");

	}

	public String getCompanyNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX, "value");
	}

	public void updateGenderValue(String updateGender) {
		waitForElementClickable(driver, CustomerPageUI.GENDER_FEMALE_CHECKBOX);
		clickToElement(driver, CustomerPageUI.GENDER_FEMALE_CHECKBOX, updateGender);

	}

	public void updateFirstNameValue(String updateFirstName) {
		waitForElementClickable(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, updateFirstName);
	}

	public void updateLastNameValue(String updateLastName) {
		waitForElementClickable(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.LASTNAME_TEXTBOX, updateLastName);
	}

	public void updateEmailValue(String updateEmail) {
		waitForElementClickable(driver, CustomerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.EMAIL_TEXTBOX, updateEmail);

	}

	public void updateDateOfBirthValue(String dropdownItem, String updateValue) {
		waitForElementClickable(driver, CustomerPageUI.DATE_OF_BIRTH_CHECKBOX, updateValue);
		selectItemInDefaultDropdown(driver, CustomerPageUI.DATE_OF_BIRTH_CHECKBOX, dropdownItem, updateValue);

	}

	public void updateCompanyNameValue(String updateCompanyName) {
		waitForElementClickable(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX, updateCompanyName);

	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, CustomerPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerPageUI.SAVE_BUTTON);

	}

}
