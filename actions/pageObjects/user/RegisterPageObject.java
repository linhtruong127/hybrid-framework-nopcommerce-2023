package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step ("Click to register button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}
	@Step ("Verify first name error message")
	public String getFirstNameErrorText() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
	}
	@Step ("Verify last name error message")
	public String getLastNameErrorText() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);

	}
	@Step ("Verify email error message")
	public String getEmailErrorText() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);

	}
	@Step ("Verify password error message")
	public String getPasswordErrorText() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);

	}
	@Step ("Verify confirm password error message")
	public String getConfirmPasswordErrorText() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MSG);
	}
	@Step ("Enter to first name textbox with value {0}")
	public void inputFirstNameToTextbox(String firstNameValue) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);

	}
	@Step ("Enter to last name textbox with value {0}")
	public void inputLastNameToTextbox(String lastNameValue) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);

	}
	@Step ("Enter to email textbox with value {0}")
	public void inputEmailToTextbox(String emailAddressValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX, emailAddressValue);

	}
	@Step ("Enter to password textbox with value {0}")
	public void inputPasswordToTextbox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);

	}
	@Step ("Enter to confirm password textbox with value {0}")
	public void inputConfirmPasswordToTextbox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, passwordValue);

	}
	@Step ("Verify successful registration text display")
	public String getRegistrationSuccessText() {
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
		return getElementText(driver,RegisterPageUI.REGISTRATION_COMPLETED_MSG);
	
	}

}
