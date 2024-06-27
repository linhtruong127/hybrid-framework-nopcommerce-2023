package pageUIs.orangehrm;

public class EmployeeListPageUI {
	public static final String ADD_EMPLOYEE_BUTTON = "xpath=//a[text()=\"Add Employee\"]";
	public static final String EMPLOYEE_ID_TEXTBOX = "Xpath=//label[text()= \"Employee Id\"]/parent::div/following-sibling::div/input";
	public static final String SEARCH_BUTTON = "Xpath=//button[text()=\" Search \"]";
	public static final String EDIT_BUTTON_BY_EMPLOYEE_ID = "Xpath=//div[string()='%s']/following-sibling::div/div[contains(@class,'oxd-table-cell-actions')]//i[@class='oxd-icon bi-pencil-fill']";

}
