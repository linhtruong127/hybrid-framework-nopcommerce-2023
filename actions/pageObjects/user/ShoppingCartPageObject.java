package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import io.qameta.allure.Step;
import pageUIs.user.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BaseElement {
	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Verify product is added to shopping cart")
	public boolean isProductDisplayToCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME_ON_CART);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_NAME_ON_CART);
	}

	@Step("Click to edit button")
	public void clickEditButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.EDIT_ITEM_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.EDIT_ITEM_BUTTON);

	}

	@Step("Click to remove product from cart")
	public void clickToRemoveProductFromCart() {
		waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_ICON);
		clickToElement(driver, ShoppingCartPageUI.REMOVE_ICON);

	}

	@Step("Verify no product message display in shopping cart")
	public boolean isNoProductMsgDisplayInCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.NO_DATA_MSG);
		return isElementDisplayed(driver, ShoppingCartPageUI.NO_DATA_MSG);
	}

	@Step("Click to update quantity of product from cart")
	public void clickToUpdateQuantityInCart(String updateQuantity) {
		waitForElementClickable(driver, ShoppingCartPageUI.QUANTITY_UPDATE);
		sendkeyToElement(driver, ShoppingCartPageUI.QUANTITY_UPDATE, updateQuantity);

	}

	@Step("Click to Update Shopping Cart button")
	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);

	}

	@Step("Verify unit price display correctly in shopping cart")
	public boolean isUnitPriceDisplayInCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.UNIT_PRICE);
		return isElementDisplayed(driver, ShoppingCartPageUI.UNIT_PRICE);
	}

	@Step("Verify subtotal price display correctly in shopping cart")
	public boolean isSubTotalDisplayInCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.SUBTOTAL_PRICE);
		return isElementDisplayed(driver, ShoppingCartPageUI.SUBTOTAL_PRICE);
	}

	@Step("Select gift wrapping option")
	public void selectGiftWrappingOption(String wrappingOption) {
		waitForElementClickable(driver, ShoppingCartPageUI.GIFT_WRAPPING_OPTION, wrappingOption);
		clickToElement(driver, ShoppingCartPageUI.GIFT_WRAPPING_OPTION, wrappingOption);

	}

	@Step("Click to Estimate Shipping button")
	public void clickToEstimateShippingButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);

	}

	@Step("Select Country in estimate shipping part")
	public void selectCountryInEstimateShipping(String countryItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.ESTIMATE_COUNTRY, countryItem);
		clickToElement(driver, ShoppingCartPageUI.ESTIMATE_COUNTRY, countryItem);

	}

	@Step("Input Zip code in estimate shipping part")
	public void inputZipcodeInEstimateShipping(String zipcodeItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.ESTIMATE_INPUT_ZIPCODE);
		sendkeyToElement(driver, ShoppingCartPageUI.ESTIMATE_INPUT_ZIPCODE, zipcodeItem);

	}

	@Step("Click to Apply button in Estimate Shipping part")
	public void clickToApplyButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.APPLY_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.APPLY_BUTTON);

	}

	@Step("Click to Terms Of Service checkbox")
	public void clickToTermsOfServiceCheckbox() {
		waitForElementClickable(driver, ShoppingCartPageUI.TERMS_OF_SERVICE_CHECKBOX);
		clickToElementByJS(driver, ShoppingCartPageUI.TERMS_OF_SERVICE_CHECKBOX);

	}

	@Step("Click to Checkout button")
	public void clickToCheckoutButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElementByJS(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);

	}

	@Step("Click to select/deselect same address option")
	public void clickToSameAddressCheckbox() {
		waitForElementClickable(driver, ShoppingCartPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
		clickToElement(driver, ShoppingCartPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);

	}

	@Step("Select Billing address option")
	public void selectBillingAddressOption(String billingAddressOption) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_ADDRESS_OPTION, billingAddressOption);
		clickToElement(driver, ShoppingCartPageUI.BILLING_ADDRESS_OPTION, billingAddressOption);

	}

	@Step("Input First name in Billing Address")
	public void inputFirstNameInBilling(String firstName) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_FIRSTNAME);
		sendkeyToElement(driver, ShoppingCartPageUI.BILLING_FIRSTNAME, firstName);

	}

	@Step("Input Last name in Billing Address")
	public void inputLastNameInBilling(String lastName) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_LASTNAME);
		sendkeyToElement(driver, ShoppingCartPageUI.BILLING_LASTNAME, lastName);

	}

	@Step("Input Email in Billing Address")
	public void inputEmailInBilling(String emailAddress) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_EMAIL);
		sendkeyToElement(driver, ShoppingCartPageUI.BILLING_EMAIL, emailAddress);

	}

	@Step("Select Country in Billing Address")
	public void selectCountryInBilling(String countryItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_COUNTRY, countryItem);
		clickToElement(driver, ShoppingCartPageUI.BILLING_COUNTRY, countryItem);

	}

	@Step("Input City in Billing Address")
	public void inputCityInBilling(String cityItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_CITY);
		sendkeyToElement(driver, ShoppingCartPageUI.BILLING_CITY, cityItem);

	}

	@Step("Input Address1 in Billing Address")
	public void inputAddress1InBilling(String addressItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_ADDRESS1);
		sendkeyToElement(driver, ShoppingCartPageUI.BILLING_ADDRESS1, addressItem);
	}

	@Step("Input Zipcode in Billing Address")
	public void inputZipcodeInBilling(String zipcoddeItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_ZIPCODE);
		sendkeyToElement(driver, ShoppingCartPageUI.BILLING_ZIPCODE, zipcoddeItem);

	}

	@Step("Input Phone number in Billing Address")
	public void inputPhonenumberInBilling(String phoneItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.BILLING_PHONE_NUMBER);
		sendkeyToElement(driver, ShoppingCartPageUI.BILLING_PHONE_NUMBER, phoneItem);

	}

	@Step("Click to Continue button in Billing Address")
	public void clickToBillingContinueButton() {
		waitForElementVisible(driver, ShoppingCartPageUI.BILLING_CONTINUE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.BILLING_CONTINUE_BUTTON);

	}

	@Step("Select shipping address option")
	public void selectShippingAddressOption(String shippingAddressOption) {
		waitForElementClickable(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_OPTION, shippingAddressOption);
		clickToElement(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_OPTION, shippingAddressOption);

	}

	@Step("Select Country in Shipping Address")
	public void selectCountryInShippingAddress(String countryItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_COUNTRY, countryItem);
		selectItemInDefaultDropdown(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_COUNTRY, countryItem);

	}

	@Step("Input City in Shipping Address")
	public void inputCityInShippingAddress(String cityItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_CITY);
		sendkeyToElement(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_CITY, cityItem);

	}

	@Step("Input Address1 in Shipping Address")
	public void inputAddress1InShippingAddress(String addressItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_ADDRESS1);
		sendkeyToElement(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_ADDRESS1, addressItem);

	}

	@Step("Input Zipcode in Shipping Address")
	public void inputZipcodeInShippingAddress(String zipcoddeItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_ZIPCODE);
		sendkeyToElement(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_ZIPCODE, zipcoddeItem);

	}

	@Step("Input Phone number in Shipping Address")
	public void inputPhonenumberInShippingAddress(String phoneItem) {
		waitForElementClickable(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_PHONE_NUMBER);
		sendkeyToElement(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_PHONE_NUMBER, phoneItem);

	}

	@Step("Click to Continue button in Shipping Address")
	public void clickToShippingAddressContinueButton() {
		waitForElementVisible(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);

	}

	@Step("Select shipping method option")
	public void selectShippingMethodOption(String shippingMethod) {
		waitForElementClickable(driver, ShoppingCartPageUI.SHIPPING_METHOD, shippingMethod);
		clickToElement(driver, ShoppingCartPageUI.SHIPPING_METHOD, shippingMethod);

	}

	@Step("Click to Continue button in Shipping Method")
	public void clickToShippingMethodContinueButton() {
		waitForElementVisible(driver, ShoppingCartPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);

	}

	@Step("Select payment method option")
	public void selectPaymentMethodOption(String paymentMethod) {
		waitForElementClickable(driver, ShoppingCartPageUI.PAYMENT_METHOD, paymentMethod);
		clickToElement(driver, ShoppingCartPageUI.PAYMENT_METHOD, paymentMethod);

	}

	@Step("Select card type")
	public void selectTypeOfCard(String cardType) {
		waitForElementClickable(driver, ShoppingCartPageUI.SELECT_CARD, cardType);
		clickToElement(driver, ShoppingCartPageUI.SELECT_CARD, cardType);

	}

	@Step("Input Card Holder Name")
	public void inputCardHolderName(String cardHolder) {
		waitForElementClickable(driver, ShoppingCartPageUI.CARD_HOLDER_NAME);
		sendkeyToElement(driver, ShoppingCartPageUI.CARD_HOLDER_NAME, cardHolder);

	}

	@Step("Input Card Number")
	public void inputCardNumber(String cardNumber) {
		waitForElementClickable(driver, ShoppingCartPageUI.CARD_NUMBER);
		sendkeyToElement(driver, ShoppingCartPageUI.CARD_NUMBER, cardNumber);

	}

	@Step("Select card expiration month")
	public void selectCardExpireMonth(String expireMonth) {
		waitForElementClickable(driver, ShoppingCartPageUI.EXPIRATION_MONTH, expireMonth);
		clickToElement(driver, ShoppingCartPageUI.EXPIRATION_MONTH, expireMonth);

	}

	@Step("Select card expiration year")
	public void selectCardExpireYear(String expireYear) {
		waitForElementClickable(driver, ShoppingCartPageUI.EXPIRATION_YEAR, expireYear);
		clickToElement(driver, ShoppingCartPageUI.EXPIRATION_YEAR, expireYear);

	}

	@Step("Input Card Code")
	public void inputCardCode(String cardCode) {
		waitForElementClickable(driver, ShoppingCartPageUI.CARD_CODE);
		sendkeyToElement(driver, ShoppingCartPageUI.CARD_CODE, cardCode);

	}

	@Step("Click to Continue button in Payment Method")
	public void clickToPaymentMethodContinueButton() {
		waitForElementVisible(driver, ShoppingCartPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);

	}

	@Step("Verify Payment info display correctly")
	public boolean isPaymentInfoDisplayCorrectly() {
		waitForElementVisible(driver, ShoppingCartPageUI.PAYMENT_INFO);
		return isElementDisplayed(driver, ShoppingCartPageUI.PAYMENT_INFO);
	}

	@Step("Click to Continue button in Payment Info")
	public void clickToPaymentInfoContinueButton() {
		waitForElementVisible(driver, ShoppingCartPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.PAYMENT_INFO_CONTINUE_BUTTON);

	}

	@Step("Verify Billling Info display in confirm order")
	public String getBilllingInfoDisplayInConfirmOrder(String infoItem) {
		waitForElementVisible(driver, ShoppingCartPageUI.BILLING_INFO_DETAILS, infoItem);
		return getElementText(driver, ShoppingCartPageUI.BILLING_INFO_DETAILS, infoItem);
	}

	@Step("Verify Payment Method display in confirm order")
	public boolean isPaymentMethodDisplayInConfirmOrder() {
		waitForElementVisible(driver, ShoppingCartPageUI.PAYMENT_METHOD_DETAILS);
		return isElementDisplayed(driver, ShoppingCartPageUI.PAYMENT_METHOD_DETAILS);
	}

	@Step("Verify Shipping Address display in confirm order")
	public String getShippingAddressDisplayInConfirmOrder(String shippingItem) {
		waitForElementVisible(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_DETAILS, shippingItem);
		return getElementText(driver, ShoppingCartPageUI.SHIPPING_ADDRESS_DETAILS, shippingItem);
	}

	@Step("Verify Shipping Method display in confirm order")
	public boolean isShippingMethodDisplayInConfirmOrder() {
		waitForElementVisible(driver, ShoppingCartPageUI.SHIPPING_METHOD_DETAILS);
		return isElementDisplayed(driver, ShoppingCartPageUI.SHIPPING_METHOD_DETAILS);
	}

	@Step("Verify SKU Number display in confirm order")
	public boolean isSkuNumberDisplayInCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.SKU_NUMBER);
		return isElementDisplayed(driver, ShoppingCartPageUI.SKU_NUMBER);
	}

	@Step("Verify Product Name display in confirm order")
	public boolean isProductNameDisplayInCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_DETAILS);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_DETAILS);
	}

	@Step("Verify Product Quantity display in confirm order")
	public boolean isQuantityDisplayInCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_QUANTITY);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_QUANTITY);
	}

	@Step("Verify Gift Wrapping option display in confirm order")
	public boolean isGiftWrappingDisplayInConfirmOrder() {
		waitForElementVisible(driver, ShoppingCartPageUI.GIFT_WRAPPING_DETAILS);
		return isElementDisplayed(driver, ShoppingCartPageUI.GIFT_WRAPPING_DETAILS);
	}

	@Step("Verify SubTotal Summary display in confirm order")
	public boolean isSubTotalSummaryDisplayInConfirmOrder() {
		waitForElementVisible(driver, ShoppingCartPageUI.SUBTOTAL_SUMMARY);
		return isElementDisplayed(driver, ShoppingCartPageUI.SUBTOTAL_SUMMARY);
	}

	@Step("Verify Shipping Summary display in confirm order")
	public boolean isShippingSummaryDisplayInConfirmOrder() {
		waitForElementVisible(driver, ShoppingCartPageUI.SHIPPING_SUMMARY);
		return isElementDisplayed(driver, ShoppingCartPageUI.SHIPPING_SUMMARY);
	}

	@Step("Verify Tax Summary display in confirm order")
	public boolean isTaxSummaryDisplayInConfirmOrder() {
		waitForElementVisible(driver, ShoppingCartPageUI.TAX_SUMMARY);
		return isElementDisplayed(driver, ShoppingCartPageUI.TAX_SUMMARY);
	}

	@Step("Verify Total amount Summary display in confirm order")
	public boolean isTotalSummaryDisplayInConfirmOrder() {
		waitForElementVisible(driver, ShoppingCartPageUI.TOTAL_SUMMARY);
		return isElementDisplayed(driver, ShoppingCartPageUI.TOTAL_SUMMARY);
	}

	@Step("Verify Compelete Order Message display")
	public boolean isCompeleteOrderMsgDisplay() {
		waitForElementVisible(driver, ShoppingCartPageUI.COMPLETE_ORDER_MSG);
		return isElementDisplayed(driver, ShoppingCartPageUI.COMPLETE_ORDER_MSG);
	}

	@Step("Verify Compelete Order Number display")
	public boolean isOrderNumberDisplay() {
		waitForElementVisible(driver, ShoppingCartPageUI.COMPLETE_ORDER_NUMBER);
		return isElementDisplayed(driver, ShoppingCartPageUI.COMPLETE_ORDER_NUMBER);
	}

	@Step("Click To confirm button ")
	public void clickToConfirmButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.CONFIRM_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.CONFIRM_BUTTON);

	}

}
