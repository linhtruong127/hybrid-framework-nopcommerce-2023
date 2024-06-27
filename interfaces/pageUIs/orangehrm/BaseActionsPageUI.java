package pageUIs.orangehrm;

public class BaseActionsPageUI {
	public static final String SPINNER_ICON= "Css=div.oxd-loading-spinner-container";
	public static final String DYNAMIC_SUCCESS_MESSAGE= "Xpath=//p[contains(@class,oxd-text--toast-message) and text()=\"%s\"]";
	public static final String COLUMN_INDEX_BY_NAME= "Xpath=//div[text()=\"%s\"]/preceding-sibling::div";
	public static final String VALUE_BY_COLUMN_INDEX_AND_ROW= "Xpath=//div[@class=\"oxd-table-card\"]/div[@role=\"row\"][%s]/div[%s]/div[contains(text(),\"%s\")]";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL= "Xpath=//label[string()=\"%s\"]/input";

}