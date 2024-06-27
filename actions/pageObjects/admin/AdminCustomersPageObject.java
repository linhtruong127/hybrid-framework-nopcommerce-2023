package pageObjects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import pageUIs.admin.AdminCustomersPageUI;

public class AdminCustomersPageObject extends AdminSideBarPageObject {
	WebDriver driver;

	public AdminCustomersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordError;

	@FindBy(xpath = "//div[@class=\"result\"]")
	private WebElement registrationCompletedMsg;

	@Step("Click To Add New Button")
	public void clickToAddNewButton() {
		waitForElementVisible(driver, AdminCustomersPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminCustomersPageUI.ADD_NEW_BUTTON);
		sleepInSecond(2);

	}

	@Step("Input Customer Info By ID textbox")
	public void inputCustomerInfoByID(String idInfo, String valueToSend) {
		waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_INFO_BY_ID, idInfo);
		sendkeyToElement(driver, AdminCustomersPageUI.CUSTOMER_INFO_BY_ID, valueToSend, idInfo);
		sleepInSecond(2);

	}

	@Step("Select Item In Dropdown List Customer Roles")
	public void selectCustomerRolesInDropdownList(String itemDropdown) {
		//clickToElementByJS(driver, AdminCustomersPageUI.CLOSE_DEFAULT_ITEM_CUSTOMER_ROLE);
		waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_ROLE_DROPDOWN);
		selectItemOfCustomDropdown(driver, AdminCustomersPageUI.CUSTOMER_ROLE_DROPDOWN, AdminCustomersPageUI.CUSTOMER_ROLE_BOX, itemDropdown);
	}

	@Step("Input value to Admin Comment TextBox")
	public void inputToAdminCommentTextBox(String valueToSend) {
		waitForElementClickable(driver, AdminCustomersPageUI.ADMIN_COMMENT_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersPageUI.ADMIN_COMMENT_TEXTBOX, valueToSend);

	}

	@Step("Click To Save And Continue Button")
	public void clickToSaveAndContinueButton() {
		waitForElementClickable(driver, AdminCustomersPageUI.SAVE_AND_CONTINUE_BUTTON);
		clickToElement(driver, AdminCustomersPageUI.SAVE_AND_CONTINUE_BUTTON);
		sleepInSecond(2);

	}

	@Step("Verify Adding Customer Success Msg Displayed")
	public boolean isAddCustomerSuccessMsgDisplayed() {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminCustomersPageUI.ADD_CUSTOMMER_SUCCESS_MSG);
		return isElementDisplayed(driver, AdminCustomersPageUI.ADD_CUSTOMMER_SUCCESS_MSG);
	}

	@Step("Verify Customer Info Displayed")
	public String getAttributeOfCustomerInfo(String idInfo) {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_INFO_BY_ID, idInfo);
		return getElementAttribute(driver, AdminCustomersPageUI.CUSTOMER_INFO_BY_ID, "value", idInfo);
	}

	@Step("Verify Customer Roles Displayed")
	public boolean isAttributeOfCustomerRolesDisplayed(String valuetoSend, String displayedValue) {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminCustomersPageUI.VALUE_OF_CUSTOMER_ROLE, valuetoSend);
		return isElementDisplayed(driver, AdminCustomersPageUI.VALUE_OF_CUSTOMER_ROLE, valuetoSend, displayedValue);
	}

	@Step("Verify Admin Comment Displayed")
	public String getAttributeOfAdminComment() {
		waitForElementVisible(driver, AdminCustomersPageUI.ADMIN_COMMENT_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersPageUI.ADMIN_COMMENT_TEXTBOX, "value");
	}

	@Step("Verify Customer info Displayed on Customer list table")
	public boolean isAttributeOnCustomerListDisplayed(String valuetoSend, String displayedValue) {
		waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_LIST, valuetoSend);
		return isElementDisplayed(driver, AdminCustomersPageUI.CUSTOMER_LIST, valuetoSend, displayedValue);
	}

	@Step("Click To Back To Customer List Button")
	public void clickToBackToCustomerListButton() {
		waitForElementClickable(driver, AdminCustomersPageUI.BACK_TO_CUSTOMER_LIST);
		clickToElement(driver, AdminCustomersPageUI.BACK_TO_CUSTOMER_LIST);
		sleepInSecond(2);

	}

	@Step("Click To Search Text Area ")
	public void clickToSearchText() {
		sleepInSecond(2);
		waitForElementClickable(driver, AdminCustomersPageUI.SEARCH_TEXT);
		clickToElement(driver, AdminCustomersPageUI.SEARCH_TEXT);

	}

	@Step("Select Item of Gender")
	public void selectGenderInfo(String genderInfo) {
		waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_INFO_BY_ID, genderInfo);
		clickToElement(driver, AdminCustomersPageUI.CUSTOMER_INFO_BY_ID, genderInfo);

	}

	@Step("Check to Active satus")
	public void selectActiveStatus(String activeStatus) {
		waitForElementClickable(driver, AdminCustomersPageUI.CUSTOMER_INFO_BY_ID, activeStatus);
		clickToElement(driver, AdminCustomersPageUI.CUSTOMER_INFO_BY_ID, activeStatus);

	}

	@Step("Get Customer Result Page Size")
	public Object getCustomerResultPageSize() {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_SEARCH_RESULT_SIZE);
		return getListElementSize(driver, AdminCustomersPageUI.CUSTOMER_SEARCH_RESULT_SIZE);	
	}

	@Step("Click To Search Button")
	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminCustomersPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCustomersPageUI.SEARCH_BUTTON);
		sleepInSecond(2);

	}

	@Step("Input DOB value to Date of Birth")
	public void inputDOBInfo(String searchItem, String selectedvalue) {
		waitForElementClickable(driver, AdminCustomersPageUI.SEARCH_DOB, searchItem, selectedvalue);
		clickToElement(driver, AdminCustomersPageUI.SEARCH_DOB, searchItem, selectedvalue);

	}

	@Step("Click To Edit Button")
	public void clickToEditButton() {
		scrollToElement(driver, AdminCustomersPageUI.EDIT_BUTTON);
		waitForElementClickable(driver, AdminCustomersPageUI.EDIT_BUTTON);
		clickToElement(driver, AdminCustomersPageUI.EDIT_BUTTON);
		sleepInSecond(2);

	}

	@Step("Click To Save Button")
	public void clickToSaveButton() {
		waitForElementClickable(driver, AdminCustomersPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminCustomersPageUI.SAVE_BUTTON);
		sleepInSecond(2);

	}

	@Step("Click To Add New Address Button")
	public void clickToAddNewAddressButton() {
		scrollToElement(driver, AdminCustomersPageUI.ADD_NEW_ADDRESS_BUTTON);
		waitForElementClickable(driver, AdminCustomersPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomersPageUI.ADD_NEW_ADDRESS_BUTTON);
		sleepInSecond(2);

	}

	@Step("Input New Address Info")
	public void inputNewAddressInfo(String idInfo, String valueToSend) {
		sleepInSecond(2);
		waitForElementClickable(driver, AdminCustomersPageUI.INPUT_NEW_ADDRESS_INFO, idInfo);
		sendkeyToElement(driver, AdminCustomersPageUI.INPUT_NEW_ADDRESS_INFO, valueToSend, idInfo);

	}

	@Step("Select Country For New Address Info")
	public void selectCountryForNewAddressInfo(String selectedItem) {
		waitForElementClickable(driver, AdminCustomersPageUI.SELECT_COUNTRY, selectedItem);
		clickToElement(driver, AdminCustomersPageUI.SELECT_COUNTRY, selectedItem);

	}

	@Step("Click To Save Button on Add New Address")
	public void clickToSaveButtonOnAddNewAddress() {
		scrollToElement(driver, AdminCustomersPageUI.SAVE_BUTTON_ON_ADD_NEW_ADDRESS);
		waitForElementClickable(driver, AdminCustomersPageUI.SAVE_BUTTON_ON_ADD_NEW_ADDRESS);
		clickToElement(driver, AdminCustomersPageUI.SAVE_BUTTON_ON_ADD_NEW_ADDRESS);
		sleepInSecond(2);

	}

	@Step("Verify Add New Address Success Msg Displayed")
	public boolean isAddNewAddressSuccessMsgDisplayed() {
		waitForElementVisible(driver, AdminCustomersPageUI.ADD_NEW_ADDRESS_SUCCESS_MSG);
		return isElementDisplayed(driver, AdminCustomersPageUI.ADD_NEW_ADDRESS_SUCCESS_MSG);
	}

	@Step("Click To Customer Details Button")
	public void clickToBackToCustomerDetailsButton() {
		waitForElementClickable(driver, AdminCustomersPageUI.BACK_TO_CUSTOMER_DETAILS);
		clickToElement(driver, AdminCustomersPageUI.BACK_TO_CUSTOMER_DETAILS);
		sleepInSecond(2);

	}

	@Step("Click To Addresses Button")
	public void clickToAddressesButton() {
		scrollToElement(driver, AdminCustomersPageUI.ADDRESSES_BUTTON);
		waitForElementClickable(driver, AdminCustomersPageUI.ADDRESSES_BUTTON);
		clickToElement(driver, AdminCustomersPageUI.ADDRESSES_BUTTON);
		sleepInSecond(2);

	}

	@Step("Verify General Addresses info Displayed on table")
	public boolean isAttributeOnAddressesDisplayed(String displayedValue) {
		waitForElementVisible(driver, AdminCustomersPageUI.GENERAL_ADDRESSES_INFO, displayedValue);
		return isElementDisplayed(driver, AdminCustomersPageUI.GENERAL_ADDRESSES_INFO, displayedValue);
	}

	@Step("Verify Address Column info Displayed on table")
	public boolean isAttributeOnAddressColumnDisplayed(String displayedValue) {
		waitForElementVisible(driver, AdminCustomersPageUI.ADDRESS_COLUMN_INFO, displayedValue);
		return isElementDisplayed(driver, AdminCustomersPageUI.ADDRESS_COLUMN_INFO, displayedValue);
	}
	@Step("Click To Delete Button")
	public void clickToDeleteButton() {
		scrollToElement(driver, AdminCustomersPageUI.DELETE_BUTTON);
		waitForElementClickable(driver, AdminCustomersPageUI.DELETE_BUTTON);
		clickToElement(driver, AdminCustomersPageUI.DELETE_BUTTON);
		sleepInSecond(2);
		
	}
	@Step("Verify No Data Text Displayed")
	public boolean isNoDataTextDisplayed() {
		waitForElementVisible(driver, AdminCustomersPageUI.NO_DATA_TEXT);
		return isElementDisplayed(driver, AdminCustomersPageUI.NO_DATA_TEXT);
	}

}