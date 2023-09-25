package pageTechpandaObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageTechpandaObject.user.PageGeneratorManager;
import pageUIs.techadmin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminLoginPageObject clickToLogOutLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public AdminLoginPageObject clickToClosePopup() {
		waitForElementClickable(driver, AdminDashboardPageUI.CLOSE_POPUP);
		clickToElement(driver, AdminDashboardPageUI.CLOSE_POPUP);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public void inputToEmailTextbox(String valueToSend) {
		waitForElementClickable(driver, AdminDashboardPageUI.FILTER_BY_HEADER_NAME);
		sendkeyToElement(driver, AdminDashboardPageUI.FILTER_BY_HEADER_NAME, valueToSend);

	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminDashboardPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.SEARCH_BUTTON);

	}

	public boolean getSuccessRegisteredInfo(String columnIndex) {
		waitForElementVisible(driver, AdminDashboardPageUI.VALUE_BY_COLUMN_INDEX, columnIndex);
		return isElementDisplayed(driver, AdminDashboardPageUI.VALUE_BY_COLUMN_INDEX, columnIndex);
	}

}
