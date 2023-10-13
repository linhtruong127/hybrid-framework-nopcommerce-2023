package pageUIs.user;

public class OrdersPageUI {

	public static final String ORDER_NUMBER= "xpath=//div[@class=\"section order-item\"]//div[@class=\"title\"]";
	public static final String DETAILS_BUTTON= "xpath=//div[@class=\"section order-item\"]//button[text()=\"Details\"]";
	public static final String ORDER_NUMBER_DETAILS= "xpath=//div[@class=\"order-number\"]";
	public static final String ORDER_OVERVIEW= "xpath=//ul[@class=\"order-overview-content\"]/li[@class=\"%s\"]";

	public static final String BILLING_INFO_DETAILS= "xpath=//div[@class=\"billing-info\"]//ul/li[@class=\"%s\"]";
	public static final String PAYMENT_METHOD_DETAILS= "xpath=//li[@class=\"payment-method\"]/span[@class=\"value\"]";
	
	public static final String SHIPPING_ADDRESS_DETAILS= "xpath=//div[@class=\"shipping-info\"]//ul/li[@class=\"%s\"]";
	public static final String SHIPPING_METHOD_DETAILS= "xpath=//li[@class=\"shipping-method\"]/span[@class=\"value\"]";
	
	public static final String SKU_NUMBER= "xpath=//span[@class=\"sku-number\"]";
	public static final String PRODUCT_DETAILS= "xpath=//td[@class=\"product\"]//a";
	public static final String PRODUCT_QUANTITY= "xpath=//span[@class=\"product-quantity\"]";
	public static final String UNIT_PRICE= "xpath=//span[@class=\"product-unit-price\"]";
	public static final String SUBTOTAL_PRICE= "xpath=//span[@class=\"product-subtotal\"]";
	public static final String GIFT_WRAPPING_DETAILS= "xpath=//div[@class=\"selected-checkout-attributes\"]";
	public static final String ORDER_SUMMARY_OVERVIEW= "xpath=//label[text()=\"%s\"]/following::td/span[text()=\"%s\"]";
	public static final String ORDER_TOTAL= "xpath=//label[text()=\"%s\"]/following::td/span/strong[text()=\"%s\"]";
	
	public static final String REORDER_BUTTON= "xpath=//button[@class=\"button-1 re-order-button\"]";
}
