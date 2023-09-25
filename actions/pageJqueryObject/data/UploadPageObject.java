package pageJqueryObject.data;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.UploadPageUI;

public class UploadPageObject extends BasePage {
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public boolean isFileLoadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_LOADED_SUCCESS, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_SUCCESS, fileName);
	}

	public void clickToStartButtonEachFile() {
		List<WebElement> startButtons = getListWebElement(driver, UploadPageUI.START_BUTTON);

		for (WebElement button : startButtons) {
			waitForElementClickable(driver, button);
			clickToElement(driver, button);

		}
	}

	public boolean isFileUploadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_SUCCESS, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_SUCCESS, fileName);
	}

}
