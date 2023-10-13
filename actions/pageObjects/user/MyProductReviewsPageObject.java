package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends BasePage {
	WebDriver driver;

	public MyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductReviewDisplayed(String productName) {
		waitForElementVisible(driver, MyProductReviewsPageUI.PRODUCT_REVIEW, productName);
		return isElementDisplayed(driver, MyProductReviewsPageUI.PRODUCT_REVIEW, productName);
	}
}
