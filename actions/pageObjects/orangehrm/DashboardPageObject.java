package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageUIs.orangehrm.DashboardPageUI;

public class DashboardPageObject extends BaseActions {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click to open PIM module")
	public EmployeeListPageObject openPIMModule() {
		waitForElementVisible(driver, DashboardPageUI.PIM_MODULE);
		clickToElement(driver, DashboardPageUI.PIM_MODULE);
		return PageGeneratorManager.getEmployeeListPage(driver);
	}
}