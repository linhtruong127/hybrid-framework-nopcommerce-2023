package pageUIs.user;

public class BaseElementUI {

	public static final String CUSTOMER_INFO_LINK = "//div[@class=\"listbox\"]//a[text()=\"Customer info\"]";
	public static final String ORDERS_LINK = "//div[@class=\"listbox\"]//a[text()=\"Orders\"]";
	public static final String ADDRESSES_LINK = "//div[@class=\"listbox\"]//a[text()=\"Addresses\"]";
	public static final String DOWNLOADABLE_PRODUCTS_LINK = "//div[@class=\"listbox\"]//a[text()=\"Downloadable products\"]";
	public static final String REWARD_POINTS_LINK = "//div[@class=\"listbox\"]//a[text()=\"Reward points\"]";
	public static final String BACK_IN_STOCK_SUBSCRIPTIONS_LINK = "//div[@class=\"listbox\"]//a[text()=\"Back in stock subscriptions\"]";
	public static final String CHANGE_PASSWORD_LINK = "//div[@class=\"listbox\"]//a[text()=\"Change password\"]";
	public static final String MY_PRODUCTS_REVIEWS_LINK = "//div[@class=\"listbox\"]//a[text()=\"My product reviews\"]";
	
	public static final String UPLOAD_BUTTON = "css=input[type=\"file\"]";
	public static final String LOGO_LINK = "Xpath=//div[@class=\"header-logo\"]//img";
	public static final String DYNAMIC_HEADER_LINK = "Xpath=//div[@class=\"header-links\"]//a[contains(string(), \"%s\")]";
	public static final String DYNAMIC_ERROR_BY_ID = "Xpath=//span[@id=\"%s-error\"]";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id=\"%s\"]";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "Xpath=//button[text()=\"%s\"]";
}
