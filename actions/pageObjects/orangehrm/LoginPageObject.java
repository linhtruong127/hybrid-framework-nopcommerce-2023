package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageUIs.orangehrm.LoginPageUI;

public class LoginPageObject extends BaseActions {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Enter To Username Textbox")
	public void enterToUsernameTextbox(String userName) {
		waitForElementClickable(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);

	}
	@Step("Enter To Password Textbox")
	public void enterToPasswordTextbox(String passWord) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);

	}
	@Step("Click To Login Button")
	public DashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPage(driver);

	}
}