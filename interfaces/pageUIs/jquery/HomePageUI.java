package pageUIs.jquery;

public class HomePageUI {
	public static final String HEADER_FILTER_BY_NAME = "xpath=//div[text()=\"%s\"]/parent::div/following-sibling::input";
	public static final String PAGE_LINK_NUMBER = "Xpath=//a[@class=\"qgrd-pagination-page-link\" and text() =\"%s\"]";
	public static final String PAGE_LINK_ACTIVE_NUMBER = "Xpath=//a[@class=\"qgrd-pagination-page-link active\" and text() =\"%s\"]";
	public static final String FILTER_DATA_BY_ROW = "xpath=//td[@data-key=\"females\" and text()=\"%s\"]/following-sibling::td[@data-key=\"country\" and text()=\"%s\"]/following-sibling::td[@data-key=\"males\" and text()=\"%s\"]/following-sibling::td[@data-key=\"total\" and text()=\"%s\"]";
	public static final String ACTION_BY_COUNTRY_NAME = "Xpath=//td[@data-key=\"country\" and text()=\"%s\"]/preceding-sibling::td[@class=\"qgrd-actions\"]/button[@class=\"qgrd-%s-row-btn\"]";

	public static final String ALL_PAGE_LINKS = "xpath=//a[contains(@class, \"qgrd-pagination-page-link\")]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "Xpath=//div[text()=\"%s\"]/ancestor::th/preceding-sibling::th";
	public static final String ALL_VALUE_BY_COLUMN_INDEX = "Xpath=//tr/td[%s]";

	public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "Xpath=//th[text()=\"%s\"]/preceding-sibling::th";
	public static final String DYNAMIC_INPUT_ROW_INDEX_BY_COLUMN_INDEX = "Xpath=//tr[%s]/td[%s]/input";
	public static final String DYNAMIC_DROPDOWN_ROW_INDEX_BY_COLUMN_INDEX = "Xpath=//tr[%s]/td[%s]//select";
	public static final String DYNAMIC_CHECKBOX_ROW_INDEX_BY_COLUMN_INDEX = "Xpath=//tr[%s]/td[%s]//input[@type=\"checkbox\"]";

}
