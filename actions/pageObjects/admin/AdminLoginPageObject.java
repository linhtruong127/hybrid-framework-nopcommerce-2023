package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Enter To Email Textbox")
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	@Step("Enter To Password Textbox")
	public void enterToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, passwordValue);

	}

	@Step("Click To Admin Login Button")
	public AdminDashboardPageObject clickToAdminLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);

	}

	@Step("Login To Admin Page")
	public AdminDashboardPageObject loginToAdmin(String emailAddress, String passwordValue) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(passwordValue);
		return clickToAdminLoginButton();
	}
}
