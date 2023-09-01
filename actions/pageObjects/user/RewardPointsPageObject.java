package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.CustomerPageUI;

public class RewardPointsPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public RewardPointsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");

	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");

	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");

	}

}
