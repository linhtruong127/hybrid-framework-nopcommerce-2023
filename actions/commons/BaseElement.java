package commons;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import jsonData.nopCommerce.UserInfoData;
import pageObjects.user.HomePageObject;
import pageUIs.user.BaseElementUI;
import pojoData.nopCommerce.UserInfo;

public class BaseElement extends BasePage {
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to logo homepage link")
	public HomePageObject clickToLogoLink() {
		waitForElementClickable(driver, BaseElementUI.LOGO_LINK);
		clickToElement(driver, BaseElementUI.LOGO_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	@Step("Click to header link by page name")
	public void clickToHeaderLinkByPageText(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK, pageName);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK, pageName);
	}

	@Step("Click to a button by button name")
	public void clickToButtonByText(String buttonName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);
	}

	@Step("Get Textbox ErrorMsg By ID")
	public String getTextboxErrorMsgByID(String idTextbox) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_ERROR_BY_ID, idTextbox);
		return getElementText(driver, BaseElementUI.DYNAMIC_ERROR_BY_ID, idTextbox);
	}

	@Step("Input To Dynamic Textbox")
	public void inputToDynamicTextbox(String textboxName, String valueToSend) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxName);
		sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSend, textboxName);

	}

	@Step("Get Dynamic Attribute Value By ID")
	public String getDynamicAttributeValueByID(String textboxID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	@Step("Login To Application")
	public void loginToApplication(UserInfo userInfo) {
		inputToDynamicTextbox("Email", userInfo.getEmailAddress());
		inputToDynamicTextbox("Password", userInfo.getPassword());
		
	}
	@Step("Login To System")
	public void loginToSystem(UserInfoData userInfo) {
		inputToDynamicTextbox("Email", userInfo.getEmail());
		inputToDynamicTextbox("Password", userInfo.getPassword());

	}
}