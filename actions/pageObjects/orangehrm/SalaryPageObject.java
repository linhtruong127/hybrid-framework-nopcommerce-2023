package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageUIs.facebook.HomePageUI;

public class SalaryPageObject extends BaseActions {
	WebDriver driver;

	public SalaryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToCreateNewAccount() {
		waitForElementVisible(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElementByJS(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);

}
}