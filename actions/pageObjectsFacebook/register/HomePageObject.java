package pageObjectsFacebook.register;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccount() {
		waitForElementVisible(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElementByJS(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);

	}

	public boolean isFirstNameTextboxDisplay() {
		//waitForElementVisible(driver, HomePageUI.FIRSTNAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.FIRSTNAME_TEXTBOX);
	}

	public boolean isLastNameTextboxDisplay() {
		//waitForElementVisible(driver, HomePageUI.LASTNAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.LASTNAME_TEXTBOX);
	}

	public boolean isEmailTextboxDisplay() {
		//waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxDisplay() {
		//waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public boolean isConfirmEmailTextboxDisplay() {
		//waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCloseSignupPopupButton() {
		waitForElementVisible(driver, HomePageUI.CLOSE_SIGNUP_POPUP_BUTTON);
		clickToElement(driver, HomePageUI.CLOSE_SIGNUP_POPUP_BUTTON);
		sleepInSecond(2);
	}

	public boolean isFirstNameTextboxUnDisplay() {
		return isElementUnDisplayed(driver, HomePageUI.FIRSTNAME_TEXTBOX);
	}

	public boolean isLastNameTextboxUnDisplay() {
		return isElementUnDisplayed(driver, HomePageUI.LASTNAME_TEXTBOX);
	}

	public boolean isEmailTextboxUnDisplay() {
		return isElementUnDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxUnDisplay() {
		return isElementUnDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}

}
