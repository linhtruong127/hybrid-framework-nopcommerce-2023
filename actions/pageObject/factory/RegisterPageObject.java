package pageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;

	@CacheLookup
	@FindBy(id = "register-button")
	private WebElement registerButton;

	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;

	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;

	@FindBy(id = "FirstName-error")
	private WebElement firstNameError;

	@FindBy(id = "LastName-error")
	private WebElement lastNameError;

	@FindBy(id = "Email-error")
	private WebElement emailError;

	@FindBy(id = "Password-error")
	private WebElement passwordError;

	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordError;

	@FindBy(xpath = "//div[@class=\"result\"]")
	private WebElement registrationCompletedMsg;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public String getFirstNameErrorText() {
		waitForElementVisible(driver, firstNameError);
		return getElementText(driver, firstNameError);
	}

	public String getLastNameErrorText() {
		waitForElementVisible(driver, lastNameError);
		return getElementText(driver, lastNameError);

	}

	public String getEmailErrorText() {
		waitForElementVisible(driver, emailError);
		return getElementText(driver, emailError);

	}

	public String getPasswordErrorText() {
		waitForElementVisible(driver, passwordError);
		return getElementText(driver, passwordError);

	}

	public String getConfirmPasswordErrorText() {
		waitForElementVisible(driver, confirmPasswordError);
		return getElementText(driver, confirmPasswordError);
	}

	public void inputFirstNameToTextbox(String firstNameValue) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstNameValue);

	}

	public void inputLastNameToTextbox(String lastNameValue) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastNameValue);

	}

	public void inputEmailToTextbox(String emailAddressValue) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddressValue);

	}

	public void inputPasswordToTextbox(String passwordValue) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, passwordValue);

	}

	public void inputConfirmPasswordToTextbox(String passwordValue) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, passwordValue);

	}

	public String getRegistrationSuccessText() {
		waitForElementVisible(driver, registrationCompletedMsg);
		return getElementText(driver, registrationCompletedMsg);

	}

}
