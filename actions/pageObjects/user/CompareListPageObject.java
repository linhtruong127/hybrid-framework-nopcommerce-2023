package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import io.qameta.allure.Step;
import pageUIs.user.CompareListPageUI;

public class CompareListPageObject extends BaseElement {
	WebDriver driver;

	public CompareListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Verify remove button is displayed in compare list page")
	public boolean isRemoveButtonDisplayonCompareList() {
		waitForElementVisible(driver, CompareListPageUI.REMOVE_BUTTON_ON_COMPARELIST);
		return isElementDisplayed(driver, CompareListPageUI.REMOVE_BUTTON_ON_COMPARELIST);
	}

	@Step("Verify product name is displayed in compare list page")
	public boolean isProductNameDisplayonCompareList(String productName) {
		waitForElementVisible(driver, CompareListPageUI.PRODUCT_NAME_ON_COMPARELIST, productName);
		return isElementDisplayed(driver, CompareListPageUI.PRODUCT_NAME_ON_COMPARELIST, productName);
	}

	@Step("Verify product price is displayed in compare list page")
	public boolean isProductPriceDisplayonCompareList(String productPrice) {
		waitForElementVisible(driver, CompareListPageUI.PRODUCT_PRICE_ON_COMPARELIST, productPrice);
		return isElementDisplayed(driver, CompareListPageUI.PRODUCT_PRICE_ON_COMPARELIST, productPrice);
	}

	@Step("Click to ClearList button on compare list page")
	public void clickToClearlistButton() {
		waitForElementClickable(driver, CompareListPageUI.CLEARLIST_BUTTON_ON_COMPARELIST);
		clickToElement(driver, CompareListPageUI.CLEARLIST_BUTTON_ON_COMPARELIST);

	}

	@Step("Verify the message no item is displayed in compare list page")
	public String getMessageNoItemOnCompareList() {
		waitForElementVisible(driver, CompareListPageUI.NO_ITEM_MSG_ON_COMPARELIST);
		return getElementText(driver, CompareListPageUI.NO_ITEM_MSG_ON_COMPARELIST);
	}

}
