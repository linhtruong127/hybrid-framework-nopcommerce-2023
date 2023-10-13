package pageUIs.user;

public class ShoppingCartPageUI {

	public static final String PRODUCT_NAME_ON_CART= "xpath=//td[@class=\"product\"]/a[text()=\"%s\"]";
	public static final String EDIT_ITEM_BUTTON= "xpath=//div[@class=\"edit-item\"]/a[text()=\"Edit\"]";
	public static final String REMOVE_ICON= "xpath=//td[@class=\"remove-from-cart\"]/button[@name=\"updatecart\"]";
	public static final String NO_DATA_MSG= "xpath=//div[@class=\"no-data\"]";
	public static final String QUANTITY_UPDATE= "xpath=//input[@class=\"qty-input\"]";
	public static final String UPDATE_SHOPPING_CART_BUTTON= "xpath=//button[@id=\"updatecart\" and text()=\"Update shopping cart\"]";
	public static final String UNIT_PRICE= "xpath=//span[@class=\"product-unit-price\"]";
	public static final String SUBTOTAL_PRICE= "xpath=//span[@class=\"product-subtotal\"]";
	
	public static final String GIFT_WRAPPING_OPTION= "xpath=//select[@id=\"checkout_attribute_1\"]/option[text()=\"%s\"]";
	public static final String ESTIMATE_SHIPPING_BUTTON= "xpath=//a[@class=\"estimate-shipping-button\"]";
	public static final String ESTIMATE_COUNTRY= "xpath=//select[@id=\"CountryId\"]/option[text()=\"%s\"]";
	public static final String ESTIMATE_INPUT_ZIPCODE= "xpath=//input[@id=\"ZipPostalCode\"]";
	public static final String APPLY_BUTTON= "xpath=//button[@class=\"button-2 apply-shipping-button\"]";
	public static final String TERMS_OF_SERVICE_CHECKBOX= "xpath=//div[@class=\"terms-of-service\"]/input[@id=\"termsofservice\"]";
	public static final String CHECKOUT_BUTTON= "xpath=//button[@id=\"checkout\"]";
	
	public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX= "xpath=//div[@class=\"section ship-to-same-address\"]//input[@name=\"ShipToSameAddress\"]";
	public static final String BILLING_ADDRESS_OPTION= "xpath=//select[@id=\"billing-address-select\"]/option[text()=\"%s\"]";
	public static final String BILLING_FIRSTNAME= "xpath=//input[@id=\"BillingNewAddress_FirstName\"]";
	public static final String BILLING_LASTNAME= "xpath=//input[@id=\"BillingNewAddress_LastName\"]";
	public static final String BILLING_EMAIL= "xpath=//input[@id=\"BillingNewAddress_Email\"]";
	public static final String BILLING_COUNTRY= "xpath=//select[@id=\"BillingNewAddress_CountryId\"]/option[text()=\"%s\"]";
	public static final String BILLING_CITY= "xpath=//input[@id=\"BillingNewAddress_City\"]";
	public static final String BILLING_ADDRESS1= "xpath=//input[@id=\"BillingNewAddress_Address1\"]";
	public static final String BILLING_ZIPCODE= "xpath=//input[@id=\"BillingNewAddress_ZipPostalCode\"]";
	public static final String BILLING_PHONE_NUMBER= "xpath=//input[@id=\"BillingNewAddress_PhoneNumber\"]";
	public static final String BILLING_CONTINUE_BUTTON= "xpath=//div[@id=\"billing-buttons-container\"]/button[text()=\"Continue\"]";
	
	public static final String SHIPPING_ADDRESS_OPTION= "xpath=//select[@id=\"shipping-address-select\"]/option[text()=\"%s\"]";
	public static final String SHIPPING_ADDRESS_COUNTRY= "xpath=//select[@id=\"ShippingNewAddress_CountryId\"]";
	public static final String SHIPPING_ADDRESS_CITY= "xpath=//input[@id=\"ShippingNewAddress_City\"]";
	public static final String SHIPPING_ADDRESS_ADDRESS1= "xpath=//input[@id=\"ShippingNewAddress_Address1\"]";
	public static final String SHIPPING_ADDRESS_ZIPCODE= "xpath=//input[@id=\"ShippingNewAddress_ZipPostalCode\"]";
	public static final String SHIPPING_ADDRESS_PHONE_NUMBER= "xpath=//input[@id=\"ShippingNewAddress_PhoneNumber\"]";
	public static final String SHIPPING_ADDRESS_CONTINUE_BUTTON= "xpath=//div[@id=\"shipping-buttons-container\"]/button[text()=\"Continue\"]";
	
	public static final String SHIPPING_METHOD= "xpath=//input[@name=\"shippingoption\"]/following::label[text()=\"%s\"]";
	public static final String SHIPPING_METHOD_CONTINUE_BUTTON= "xpath=//div[@id=\"shipping-method-buttons-container\"]//button[text()=\"Continue\"]";
	public static final String PAYMENT_METHOD= "xpath=//ul[@class=\"method-list\"]//label[text()=\"%s\"]";
	public static final String PAYMENT_METHOD_CONTINUE_BUTTON= "xpath=//div[@id=\"payment-method-buttons-container\"]//button[text()=\"Continue\"]";
	public static final String PAYMENT_INFO= "xpath=//div[@class=\"section payment-info\"]//td/p";
	public static final String PAYMENT_INFO_CONTINUE_BUTTON= "xpath=//div[@id=\"payment-info-buttons-container\"]//button[text()=\"Continue\"]";
	
	public static final String BILLING_INFO_DETAILS= "xpath=//div[@class=\"billing-info\"]//ul/li[@class=\"%s\"]";
	public static final String PAYMENT_METHOD_DETAILS= "xpath=//li[@class=\"payment-method\"]/span[@class=\"value\"]";
	
	public static final String SHIPPING_ADDRESS_DETAILS= "xpath=//div[@class=\"shipping-info\"]//ul/li[@class=\"%s\"]";
	public static final String SHIPPING_METHOD_DETAILS= "xpath=//li[@class=\"shipping-method\"]/span[@class=\"value\"]";

	public static final String SKU_NUMBER= "xpath=//span[@class=\"sku-number\"]";
	public static final String PRODUCT_DETAILS= "xpath=//a[@class=\"product-name\"]";
	public static final String PRODUCT_QUANTITY= "xpath=//span[@class=\"product-quantity\"]";
	public static final String GIFT_WRAPPING_DETAILS= "xpath=//div[@class=\"selected-checkout-attributes\"]";
	public static final String SUBTOTAL_SUMMARY= "xpath=//tr[@class=\"order-subtotal\"]//span[@class=\"value-summary\"]";
	public static final String SHIPPING_SUMMARY= "xpath=//tr[@class=\"shipping-cost\"]//span[@class=\"value-summary\"]";
	public static final String TAX_SUMMARY= "xpath=//tr[@class=\"tax-value\"]//span[@class=\"value-summary\"]";
	public static final String TOTAL_SUMMARY= "xpath=//tr[@class=\"order-total\"]//span[@class=\"value-summary\"]";
	public static final String CONFIRM_BUTTON= "xpath=//div[@id=\"confirm-order-buttons-container\"]/button[text()=\"Confirm\"]";
	public static final String COMPLETE_ORDER_MSG= "xpath=//div[@class=\"page checkout-page order-completed-page\"]//div[@class=\"page-title\"]";
	public static final String COMPLETE_ORDER_NUMBER= "xpath=//div[@class=\"order-number\"]";
	
	public static final String SELECT_CARD= "xpath=//select[@id=\"CreditCardType\"]/option[text()=\"%s\"]";
	public static final String CARD_HOLDER_NAME= "xpath=//input[@id=\"CardholderName\"]";
	public static final String CARD_NUMBER= "xpath=//input[@id=\"CardNumber\"]";
	public static final String EXPIRATION_MONTH= "xpath=//select[@id=\"ExpireMonth\"]/option[text()=\"%s\"]";
	public static final String EXPIRATION_YEAR= "xpath=//select[@id=\"ExpireYear\"]/option[text()=\"%s\"]";
	public static final String CARD_CODE= "xpath=//input[@id=\"CardCode\"]";
	
	
	
	
	
	

}
