package pageJqueryObject.data;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToHeaderFilter(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.HEADER_FILTER_BY_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.HEADER_FILTER_BY_NAME, valueToSend, columnName);

	}

	public void clickToPagingNumber(String PageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_NUMBER, PageNumber);
		clickToElement(driver, HomePageUI.PAGE_LINK_NUMBER, PageNumber);

	}

	public boolean isPageActiveNumberDisplayed(String PageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_NUMBER, PageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_NUMBER, PageNumber);

	}

	public boolean isRowValueDisplayed(String females, String country, String males, String total) {
		waitForElementVisible(driver, HomePageUI.FILTER_DATA_BY_ROW, females, country, males, total);
		return isElementDisplayed(driver, HomePageUI.FILTER_DATA_BY_ROW, females, country, males, total);

	}

	public void clickToActionByIcon(String countryName, String actionIcon) {
		waitForElementVisible(driver, HomePageUI.ACTION_BY_COUNTRY_NAME, countryName, actionIcon);
		clickToElement(driver, HomePageUI.ACTION_BY_COUNTRY_NAME, countryName, actionIcon);

	}

	public List<String> getAllValuesByColumnName(String columnName) {
		List<String> allValues = new ArrayList<String>();

		List<WebElement> allPageLinks = getListWebElement(driver, HomePageUI.ALL_PAGE_LINKS);

		for (WebElement pageLink : allPageLinks) {
			pageLink.click();

		}

		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME) + 1;

		List<WebElement> allColumnValues = getListWebElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));

		for (WebElement columnValue : allColumnValues) {
			allValues.add(columnValue.getText());
		}
		return allValues;

	}

	public void enterToTextboxByRowAndColumnIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.DYNAMIC_INPUT_ROW_INDEX_BY_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.DYNAMIC_INPUT_ROW_INDEX_BY_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(columnIndex));
		
	}

	public void selectItemByRowAndColumnIndex(String columnName, String rowIndex, String dropdownItem) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_ROW_INDEX_BY_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_ROW_INDEX_BY_COLUMN_INDEX, dropdownItem, rowIndex, String.valueOf(columnIndex));
		
	}

	public void checkToIconByRowAndColumnIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_ROW_INDEX_BY_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		checkToElement(driver, HomePageUI.DYNAMIC_CHECKBOX_ROW_INDEX_BY_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		
	}

}

