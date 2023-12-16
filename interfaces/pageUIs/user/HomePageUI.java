package pageUIs.user;

public class HomePageUI {
	public static final String REGISTER_LINK = "xpath=//a[@class=\"ico-register\"]";
	public static final String LOGIN_LINK = "Xpath=//a[@class=\"ico-login\"]";

	public static final String MYACCOUNT_LINK = "Xpath=//a[@class=\"ico-account\"]";
	public static final String LOGOUT_LINK = "xpath=//a[@class=\"ico-logout\"]";
	
	public static final String PRODUCT_NAME = "xpath=//h2[@class=\"product-title\"]/a[text()=\"%s\"]";
	public static final String ADD_REVIEW_PRODUCT = "xpath=//a[text()=\"Add your review\"]";
	public static final String ADD_REVIEW_TITLE = "xpath=//input[@class=\"review-title\"]";
	public static final String ADD_REVIEW_TEXT = "xpath=//textarea[@class=\"review-text\"]";
	public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[@class=\"button-1 write-product-review-button\"]";
	public static final String SEARCH_LINK = "xpath=//a[text()=\"Search\"]";
	
	public static final String SELECT_PRODUCT_MENU = "xpath=//ul[@class=\"top-menu notmobile\"]//a[text()=\"%s\"]";
	public static final String SELECT_SUB_MENU = "xpath=//div[@class=\"listbox\"]//a[text()=\"%s\"]";
	public static final String SELECT_SORT_TYPE = "xpath=//select[@id=\"products-orderby\"]/option[text()=\"%s\"]";
	
	public static final String SELECT_PAGESIZE = "xpath=//select[@id=\"products-pagesize\"]/option[text()=\"%s\"]";
	public static final String NEXT_ICON = "xpath=//div[@class=\"pager\"]//a[text()=\"Next\"]";
	public static final String PREVIOUS_ICON = "xpath=//div[@class=\"pager\"]//a[text()=\"Previous\"]";
	public static final String SORTING_RESULT_BASED_PRODUCT_TITLE = "xpath=//div[@class=\"item-grid\"]//div[@class=\"details\"]//a";
	public static final String SORTING_RESULT_BASED_PRODUCT_PRICE = "xpath=//div[@class=\"item-grid\"]//div[@class=\"prices\"]//span";
	
	
	public static final String PAGING_BAR = "xpath=//div[@class=\"pager\"]/ul";
	public static final String ADD_TO_WISHLIST_BUTTON = "xpath=//button[@id=\"add-to-wishlist-button-4\"]";
	public static final String ADD_WISHLIST_SUCCESS_MSG = "xpath=//div[@class=\"bar-notification success\"]/p[@class=\"content\"]";
	public static final String WISHLIST_LINK = "xpath=//a[@class=\"ico-wishlist\"]";
	public static final String PRODUCT_IN_WISHLIST = "xpath=//span[@class=\"wishlist-qty\" and text()=\"%s\"]";
	public static final String PRODUCT_IN_CART = "xpath=//span[@class=\"cart-qty\" and text()=\"%s\"]";
	public static final String ADD_PRODUCT_TO_COMPARE_LIST = "xpath=//div[@data-productid=\"%s\"]//div[@class=\"buttons\"]/button[@title=\"Add to compare list\"]";
	public static final String ADD_TO_COMPARE_LIST_SUCCESS_MSG = "xpath=//div[@class=\"bar-notification success\"]/p[@class=\"content\"]";
	
	public static final String COMPARELIST_PAGE = "xpath=//a[text()=\"Compare products list\"]";
	public static final String RECENTLY_VIEW_PAGE = "xpath=//a[text()=\"Recently viewed products\"]";
	public static final String SELECT_PROCESSOR = "xpath=//select[@id=\"product_attribute_1\"]/option[text()=\"%s\"]";
	public static final String SELECT_RAM = "xpath=//select[@id=\"product_attribute_2\"]/option[text()=\"%s\"]";
	public static final String SELECT_HDD = "xpath=//input[@name=\"product_attribute_3\"]/following::label[text()=\"%s\"]";
	public static final String SELECT_OS = "xpath=//input[@name=\"product_attribute_4\"]/following::label[text()=\"%s\"]";
	public static final String SELECT_SOFTWARE = "xpath=//input[@name=\"product_attribute_5\"]/following::label[text()=\"%s\"]";
	public static final String ADD_TO_CART_BUTTON = "xpath=//div[@class=\"add-to-cart-panel\"]//button[text()=\"Add to cart\"]";
	public static final String ADD_TO_CART_SUCCESS_MSG = "xpath=//p[@class=\"content\"]";
	public static final String COUNTING_MSG_IN_CART = "xpath=//div[@class=\"count\"]";
	public static final String DETAILED_PRODUCT_IN_CART = "xpath=//div[@class=\"attributes\"]";
	public static final String SUB_TOTAL_IN_CART = "xpath=//div[@class=\"totals\"]";
	public static final String SHOPPING_CART_LINK = "xpath=//a[@class=\"ico-cart\"]";
	public static final String PRICE_VALUE = "xpath=//span[@class=\"price-value-1\"]";
	public static final String INPUT_QUANTITY = "xpath=//input[@id=\"product_enteredQuantity_1\"]";
	public static final String UPDATE_BUTTON = "xpath=//button[@class=\"button-1 add-to-cart-button\"]";
	

}
