package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getFirstNameErrorText() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
	}

	public String getLastNameErrorText() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);

	}

	public String getEmailErrorText() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);

	}

	public String getPasswordErrorText() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);

	}

	public String getConfirmPasswordErrorText() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MSG);
	}

	public void inputFirstNameToTextbox(String firstNameValue) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);

	}

	public void inputLastNameToTextbox(String lastNameValue) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);

	}

	public void inputEmailToTextbox(String emailAddressValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX, emailAddressValue);

	}

	public void inputPasswordToTextbox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);

	}

	public void inputConfirmPasswordToTextbox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, passwordValue);

	}

	public String getRegistrationSuccessText() {
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
		return getElementText(driver,RegisterPageUI.REGISTRATION_COMPLETED_MSG);
	
	}

}
