package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.AddressesPageUI;

public class AddressesPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToAddNewAddress() {
		waitForElementClickable(driver, AddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);

	}

	public void inputAddressFirstName(String firstName) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_FIRSTNAME);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_FIRSTNAME, firstName);

	}

	public void inputAddressLastName(String lastName) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_LASTNAME);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_LASTNAME, lastName);

	}

	public void inputAddressEmai(String email) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_EMAIL);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_EMAIL, email);

	}

	public void inputAddressCompany(String company) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_COMPANY);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_COMPANY, company);

	}

	public void inputAddressCountry(String country) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_COUNTRY);
		selectItemInDefaultDropdown(driver, AddressesPageUI.ADDRESS_COUNTRY, country);

	}

	public void inputAddressState(String state) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_STATE);
		selectItemInDefaultDropdown(driver, AddressesPageUI.ADDRESS_STATE, state);

	}

	public void inputAddressCity(String city) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_CITY);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_CITY, city);

	}

	public void inputAddress1(String address1) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_ADDRESS1);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_ADDRESS1, address1);

	}

	public void inputAddress2(String address2) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_ADDRESS2);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_ADDRESS2, address2);

	}

	public void inputAddressZipCode(String zipCode) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_ZIPCODE);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_ZIPCODE, zipCode);

	}

	public void inputAddressPhoneNumber(String phoneNumber) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_PHONENUMBER);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_PHONENUMBER, phoneNumber);

	}

	public void inputAddressFaxNumber(String faxNumber) {
		waitForElementClickable(driver, AddressesPageUI.ADDRESS_FAXNUMBER);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_FAXNUMBER, faxNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressesPageUI.SAVE_BUTTON);

	}

	public String getSuccessRegisteredText() {
		waitForElementVisible(driver, AddressesPageUI.SUCCESS_TEXT);
		return getElementText(driver, AddressesPageUI.SUCCESS_TEXT);
	}

}
