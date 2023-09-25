package pageTechpandaObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techuser.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		clickToElement(driver, HomePageUI.ACCOUNT_BUTTON);
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		clickToElement(driver, HomePageUI.ACCOUNT_BUTTON);
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public HomePageObject clickToLogOutLink() {
		clickToElement(driver, HomePageUI.ACCOUNT_BUTTON);
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
}
