package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends AdminSideBarPageObject {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	@Step("Click to logOut link")
	public AdminLoginPageObject clickToLogOutLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

}