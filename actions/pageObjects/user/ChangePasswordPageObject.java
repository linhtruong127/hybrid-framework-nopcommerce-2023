package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputOldPassword(String oldPass) {
		waitForElementClickable(driver, ChangePasswordPageUI.OLD_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD, oldPass);

	}

	public void inputNewPassword(String newPass) {
		waitForElementClickable(driver, ChangePasswordPageUI.NEW_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD, newPass);

	}

	public void inputConfirmNewPassword(String confirmNewPass) {
		waitForElementClickable(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD, confirmNewPass);

	}

	public void clickChangePasswordButton(String string) {
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);

	}

	public String getChangePasswordSuccessText() {
		waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS);
		return getElementText(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS);
	}

	public void closeChangePasswordText() {
		waitForElementVisible(driver, ChangePasswordPageUI.CLOSE_SUCCESS_TEXT);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_SUCCESS_TEXT);

	}

	public void clickToLogOutLink() {
		waitForElementClickable(driver, ChangePasswordPageUI.LOGOUT_LINK);
		clickToElement(driver, ChangePasswordPageUI.LOGOUT_LINK);

	}

}
