package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.orangehrm.BaseActionsPageUI;

public class BaseActions extends BasePage {
	WebDriver driver;

	public BaseActions(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Successful Text Displayed")
	public boolean isSuccessfulTextDisplayed(String successfullText) {
		waitForElementVisible(driver, BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE, successfullText);
		return isElementDisplayed(driver, BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE, successfullText);
	}

	@Step("Wait for spin loading dissapear")
	public void waitForSpinIconDissapear() {
		waitForListElementInvisible(driver, BaseActionsPageUI.SPINNER_ICON);

	}

	@Step("Verify value displayed on table")
	public boolean isValueDisplayedAtColumnName(String columnName, String rowValue, String verifyValue) {
		int columnIndex = getListElementSize(driver, BaseActionsPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return isElementDisplayed(driver, BaseActionsPageUI.VALUE_BY_COLUMN_INDEX_AND_ROW, rowValue, String.valueOf(columnIndex), verifyValue);
	}

	public void clickRadioButtonToSelectGenderStatus(String gender) {
		clickToElementByJS(driver, BaseActionsPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, gender);
	}

	public boolean isGenderStatusDisplayed(String gender) {
		return isElementSelected(driver, BaseActionsPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, gender);
	}
}