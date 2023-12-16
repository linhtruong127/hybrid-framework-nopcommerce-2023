package pageUIs.admin;

public class AdminProductsPageUI {

	public static final String PRODUCTS_NAME_TEXTBOX = "Xpath=//input[@id=\"SearchProductName\"]";
	public static final String SEARCH_BUTTON = "Xpath=//button[@id=\"search-products\"]";
	public static final String SEARCH_RESULT = "Xpath=//table[@id=\"products-grid\"]//td[contains(text(),\"%s\")]";
	public static final String SEARCH_RESULT_SIZE = "Xpath=//table[@id=\"products-grid\"]/tbody/tr";
	public static final String SELECT_DROPDOWN_ITEM_BY_SEARCH_ID = "Xpath=//select[@id=\"%s\"]/option[text()=\"%s\"]";
	public static final String SEARCH_SUBCATEGORIES_CHECKBOX = "Xpath=//input[@id=\"SearchIncludeSubCategories\"]";
	public static final String GO_DIRECTLY_TO_SKU_TEXTBOX = "Xpath=//input[@id=\"GoDirectlyToSku\"]";
	public static final String GO_BUTTON = "Xpath=//button[@id=\"go-to-product-by-sku\"]";
	public static final String NO_DATA_MSG = "Xpath=//td[@class=\"dataTables_empty\"]";
	public static final String EDIT_PRODUCT_TITLE = "Xpath=//div[@class=\"content-header clearfix\"]/h1";
	

}

		
				