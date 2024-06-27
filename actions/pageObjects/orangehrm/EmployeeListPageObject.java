package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageUIs.orangehrm.EmployeeListPageUI;

public class EmployeeListPageObject extends BaseActions {
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click to Add Employee Button")
	public AddEmployeePageObject clickToAddEmployeeButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		waitForSpinIconDissapear();
		return PageGeneratorManager.getAddEmployeePage(driver);
	}

	@Step("Enter To EmployeeID Textbox")
	public void enterValueToEmployeeIDTextbox(String employeeId) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX, employeeId);

	}

	@Step("Click to Search Button")
	public void clickSearchButton() {
		waitForElementVisible(driver, EmployeeListPageUI.SEARCH_BUTTON);
		clickToElement(driver, EmployeeListPageUI.SEARCH_BUTTON);
		waitForSpinIconDissapear();
	}

	public PersonalDetailsPageObject clickToEditButtonByEmployeeId(String employeeID) {
		waitForElementVisible(driver, EmployeeListPageUI.EDIT_BUTTON_BY_EMPLOYEE_ID, employeeID);
		clickToElement(driver, EmployeeListPageUI.EDIT_BUTTON_BY_EMPLOYEE_ID, employeeID);
		return PageGeneratorManager.getPersonalDetailsPage(driver);

	}

}
