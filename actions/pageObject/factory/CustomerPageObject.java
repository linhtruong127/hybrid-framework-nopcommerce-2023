package pageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class CustomerPageObject extends BasePageFactory {
	private WebDriver driver;

	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstNameTextBox;

	@FindBy(id = "LastName")
	private WebElement lastNameTextBox;

	@FindBy(id = "Email")
	private WebElement emailTextBox;

	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, firstNameTextBox);
		return getElementAttribute(driver, firstNameTextBox, "value");

	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, lastNameTextBox);
		return getElementAttribute(driver, lastNameTextBox, "value");

	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, emailTextBox);
		return getElementAttribute(driver, emailTextBox, "value");

	}


}
