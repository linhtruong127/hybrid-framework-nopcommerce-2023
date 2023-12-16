package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import io.qameta.allure.Step;
import pageUIs.user.RecentlyViewPageUI;

public class RecentlyViewPageObject extends BaseElement {
	WebDriver driver;

	public RecentlyViewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Verify viewed products display on recently view page")
	public boolean isProductDisplayonRecentlyViewPage(String productname) {
		waitForElementVisible(driver, RecentlyViewPageUI.PRODUCT_NAME, productname);
		return isElementDisplayed(driver, RecentlyViewPageUI.PRODUCT_NAME, productname);
	}

}
