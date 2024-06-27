package pageUIs.orangehrm;

public class AddEmployeePageUI {
	public static final String FIRSTNAME_TEXTBOX = "Css=input[name=\"firstName\"]";
	public static final String LASTNAME_TEXTBOX= "name=lastName";
	public static final String EMPLOYEE_ID_TEXTBOX= "Xpath=//label[text()= \"Employee Id\"]/parent::div/following-sibling::div/input";
	public static final String SAVE_BUTTON= "Xpath=//button[contains(string(),\" Save \")]";
	public static final String DYNAMIC_SUCCESS_MESSAGE= "Xpath=//p[contains(@class,oxd-text--toast-message) and text()=\"%s\"]";

}