package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageUIs.orangehrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BaseActions {
	WebDriver driver;

	public AddEmployeePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Enter To Firstname Textbox")
	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	@Step("Enter To Lastname Textbox")
	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, AddEmployeePageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AddEmployeePageUI.LASTNAME_TEXTBOX, lastName);

	}

	@Step("Get value Employee ID")
	public String getEmployeeID() {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAttribute(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX,"value");
	}

	@Step("Click to Save Button")
	public void clickToSaveButton() {
		waitForElementClickable(driver, AddEmployeePageUI.SAVE_BUTTON);
		clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);

	}

}