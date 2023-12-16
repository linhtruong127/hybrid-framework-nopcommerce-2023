package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageUIs.admin.AdminProductsPageUI;

public class AdminProductsPageObject extends AdminSideBarPageObject {
	WebDriver driver;

	public AdminProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Input value to product name textbox")
	public void inputValueToProductNameTextbox(String productName) {
		sleepInSecond(2);
		waitForElementClickable(driver, AdminProductsPageUI.PRODUCTS_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminProductsPageUI.PRODUCTS_NAME_TEXTBOX, productName);

	}

	@Step("Click To Search Button")
	public void clickToSearchButton() {
		sleepInSecond(2);
		waitForElementClickable(driver, AdminProductsPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductsPageUI.SEARCH_BUTTON);

	}

	@Step("Verify the searching result displayed")
	public boolean getSearchingResult(String searchResult) {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminProductsPageUI.SEARCH_RESULT, searchResult);
		return isElementDisplayed(driver, AdminProductsPageUI.SEARCH_RESULT, searchResult);
	}

	@Step("Verify page size")
	public int getSearchingResultPageSize() {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminProductsPageUI.SEARCH_RESULT_SIZE);
		return getListElementSize(driver, AdminProductsPageUI.SEARCH_RESULT_SIZE);
	}

	@Step("Select Item In Dropdown List By Search ID")
	public void selectItemInDropdownListBySearchID(String searchID, String itemDropdown) {
		sleepInSecond(2);
		waitForElementClickable(driver, AdminProductsPageUI.SELECT_DROPDOWN_ITEM_BY_SEARCH_ID, searchID, itemDropdown);
		clickToElement(driver, AdminProductsPageUI.SELECT_DROPDOWN_ITEM_BY_SEARCH_ID, searchID, itemDropdown);
	}

	@Step("Verify No Data Message displayed")
	public String getNoDataMessage() {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminProductsPageUI.NO_DATA_MSG);
		return getElementText(driver, AdminProductsPageUI.NO_DATA_MSG);
	}

	@Step("Check To Search Subcategories Checkbox")
	public void checkToSearchSubcategories() {
		waitForElementClickable(driver, AdminProductsPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
		checkToElement(driver, AdminProductsPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);

	}

	@Step("Input value to Go Directly To Product SKU textbox")
	public void inputValueToGoDirectlyToProductSKU(String value) {
		waitForElementClickable(driver, AdminProductsPageUI.GO_DIRECTLY_TO_SKU_TEXTBOX);
		sendkeyToElement(driver, AdminProductsPageUI.GO_DIRECTLY_TO_SKU_TEXTBOX, value);

	}

	@Step("Click To Go Button")
	public void clickGoButton() {
		sleepInSecond(2);
		waitForElementClickable(driver, AdminProductsPageUI.GO_BUTTON);
		clickToElement(driver, AdminProductsPageUI.GO_BUTTON);

	}

	@Step("Verify Product Name Info displayed")
	public String getProductNameInfo() {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminProductsPageUI.EDIT_PRODUCT_TITLE);
		return getElementText(driver, AdminProductsPageUI.EDIT_PRODUCT_TITLE);
	}

}