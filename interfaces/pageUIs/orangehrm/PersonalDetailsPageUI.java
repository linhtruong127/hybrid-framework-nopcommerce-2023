package pageUIs.orangehrm;

public class PersonalDetailsPageUI {
	public static final String EMPLOYEE_LIST_BUTTON = "xpath=//a[text()=\"Employee List\"]";
	public static final String FIRSTNAME_TEXTBOX = "Css=input[name=\"firstName\"]";
	public static final String LASTNAME_TEXTBOX= "name=lastName";
	public static final String EMPLOYEE_ID_TEXTBOX= "Xpath=//label[text()= \"Employee Id\"]/parent::div/following-sibling::div/input";
	public static final String HEADER_PERSONAL_DETAILS= "Xpath=//h6[contains(@class,orangehrm-main-title) and text()=\"Personal Details\"]";
	
	public static final String DRIVER_LICENSE_NUMBER_BY_LABEL = "Xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
	public static final String LICENSE_EXPIRY_DATE_BY_LABEL = "Xpath=//label[text()=\"License Expiry Date\"]/parent::div/following-sibling::div//input";
	public static final String DATE_OF_BIRTH_BY_LABEL = "Xpath=//label[text()=\"Date of Birth\"]/parent::div/following-sibling::div//input";
	public static final String NATIONAL_DROPDOWN_PARENT = "Xpath=//label[text()=\"Nationality\"]/parent::div/following-sibling::div//i";
	public static final String NATIONAL_DROPDOWN_CHILD = "Xpath=//label[text()=\"Nationality\"]/parent::div/following-sibling::div//div[@class=\"oxd-select-option\"]/span";
	public static final String NATIONAL_DROPDOWN_SELECTED_ITEM = "Xpath=//label[text()=\"Nationality\"]/parent::div/following-sibling::div//div[@class=\"oxd-select-text-input\"]";
	
	public static final String MARITAL_STATUS_DROPDOWN_PARENT = "Xpath=//label[text()=\"Marital Status\"]/parent::div/following-sibling::div//i";
	public static final String MARITAL_STATUS_DROPDOWN_CHILD = "Xpath=//label[text()=\"Marital Status\"]/parent::div/following-sibling::div//div[@class=\"oxd-select-option\"]/span";
	public static final String MARITAL_STATUS_DROPDOWN_SELECTED_ITEM = "Xpath=//label[text()=\"Marital Status\"]/parent::div/following-sibling::div//div[@class=\"oxd-select-text-input\"]";
	public static final String SAVE_BUTTON_AT_PERSONAL_DETAILS = "Xpath=//div[contains(@class,\"orangehrm-horizontal-paddin\")]//button[string()=\" Save \"]";
}
