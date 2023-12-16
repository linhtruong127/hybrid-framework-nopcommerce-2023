package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import io.qameta.allure.Step;
import pageUIs.user.SearchPageUI;

public class SearchPageObject extends BaseElement {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click to search button")
	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	@Step("Verify warning search message display")
	public String getWarningMessage() {
		waitForElementClickable(driver, SearchPageUI.WARNING_MSG);
		return getElementText(driver, SearchPageUI.WARNING_MSG);

	}

	@Step("Input value to search textbox")
	public void inputValueToSearchTextbox(String valueSearch) {
		waitForElementClickable(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, valueSearch);

	}

	@Step("Verify search result display")
	public boolean getAllSearchingResult(String resultItem) {
		waitForElementVisible(driver, SearchPageUI.RESULT_SEARCHING, resultItem);
		return isElementDisplayed(driver, SearchPageUI.RESULT_SEARCHING, resultItem);
	}

	@Step("Click to advanced search checkbox")
	public void clickToAdvancedSearch() {
		waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickToElement(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);

	}

	@Step("Click to automatic search checkbox")
	public void clickToAutomaticSearch() {
		waitForElementClickable(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);
		clickToElement(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);

	}

	@Step("Select category dropdown list")
	public void selectCategoryDropdown(String dropdownItem) {
		waitForElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, dropdownItem);

	}

	@Step("Select manufacturer dropdown list")
	public void selectManufacturerDropdown(String dropdownItem) {
		waitForElementClickable(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, dropdownItem);

	}
	@Step("Verify no matching search message display")
	public String getErrorSearchMessage() {
		waitForElementClickable(driver, SearchPageUI.NO_MATCHING_SEARCH_MSG);
		return getElementText(driver, SearchPageUI.NO_MATCHING_SEARCH_MSG);
	}

}
