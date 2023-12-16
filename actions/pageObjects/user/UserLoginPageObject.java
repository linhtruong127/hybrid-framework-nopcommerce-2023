package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BaseElement {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Enter to email textbox with value {0}")
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	@Step("Enter to password textbox with value {0}")
	public void enterToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passwordValue);

	}

	@Step("Click to Login button")
	public HomePageObject clickToUserLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	@Step("Login to user account")
	public HomePageObject loginToUser(String emailAddress, String passwordValue) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(passwordValue);
		return clickToUserLoginButton();
	}

	@Step("Verify email error message")
	public String getEmailErrorText() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MSG);
	}

	@Step("Verify login error message")
	public String getLoginErrorText() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MSG);
	}

}