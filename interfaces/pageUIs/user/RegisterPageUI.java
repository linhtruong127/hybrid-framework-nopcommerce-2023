package pageUIs.user;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON = "xpath=//button[@id=\"register-button\"]";
	public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id=\"FirstName\"]";
	public static final String LASTNAME_TEXTBOX = "Xpath=//input[@id=\"LastName\"]";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id=\"Email\"]";
	public static final String PASSWORD_TEXTBOX = "Xpath=//input[@id=\"Password\"]";
	public static final String CONFIRMPASSWORD_TEXTBOX = "XPATH=//input[@id=\"ConfirmPassword\"]";

	public static final String FIRSTNAME_ERROR_MSG = "XPATH=//span[@id=\"FirstName-error\"]";
	public static final String LASTNAME_ERROR_MSG = "Xpath=//span[@id=\"LastName-error\"]";
	public static final String EMAIL_ERROR_MSG = "xpath=//span[@id=\"Email-error\"]";
	public static final String EXISTED_EMAIL_MSG = "xpath=//div[@class=\"message-error validation-summary-errors\"]//li";
	public static final String PASSWORD_ERROR_MSG = "XPATH=//span[@id=\"Password-error\"]";
	public static final String CONFIRMPASSWORD_ERROR_MSG = "Xpath=//span[@id=\"ConfirmPassword-error\"]";
	public static final String REGISTRATION_COMPLETED_MSG = "xpath=//div[@class=\"result\"]";
}
