package pageObjects.user;

import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import pageUIs.user.OrdersPageUI;

public class OrdersPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Verify Order Number display in Orders page")
	public boolean isOrderNumberDisplay() {
		waitForElementVisible(driver, OrdersPageUI.ORDER_NUMBER);
		return isElementDisplayed(driver, OrdersPageUI.ORDER_NUMBER);
	}

	@Step("Click To Details button ")
	public void clickToDetailsButton() {
		waitForElementClickable(driver, OrdersPageUI.DETAILS_BUTTON);
		clickToElement(driver, OrdersPageUI.DETAILS_BUTTON);

	}

	@Step("Verify Order Number Details display in Orders page")
	public boolean isOrderNumberDetailsDisplay() {
		waitForElementVisible(driver, OrdersPageUI.ORDER_NUMBER_DETAILS);
		return isElementDisplayed(driver, OrdersPageUI.ORDER_NUMBER_DETAILS);
	}

	@Step("Verify Order Overview Details display in Orders page")
	public boolean isOrderOverviewDetailsDisplay(String orderItem) {
		waitForElementVisible(driver, OrdersPageUI.ORDER_OVERVIEW, orderItem);
		return isElementDisplayed(driver, OrdersPageUI.ORDER_OVERVIEW, orderItem);
	}

	@Step("Verify Billling Info display in Orders page")
	public String getBilllingInfoDisplayInOrders(String billingInfo) {
		waitForElementVisible(driver, OrdersPageUI.BILLING_INFO_DETAILS, billingInfo);
		return getElementText(driver, OrdersPageUI.BILLING_INFO_DETAILS, billingInfo);
	}

	@Step("Verify Payment Method display in Orders page")
	public boolean isPaymentMethodDisplayInOrders() {
		waitForElementVisible(driver, OrdersPageUI.PAYMENT_METHOD_DETAILS);
		return isElementDisplayed(driver, OrdersPageUI.PAYMENT_METHOD_DETAILS);
	}

	@Step("Verify Shipping Address display in Orders page")
	public String getShippingAddressDisplayInOrders(String shippingInfo) {
		waitForElementVisible(driver, OrdersPageUI.SHIPPING_ADDRESS_DETAILS, shippingInfo);
		return getElementText(driver, OrdersPageUI.SHIPPING_ADDRESS_DETAILS, shippingInfo);
	}

	@Step("Verify Shipping Method display in Orders page")
	public boolean isShippingMethodDisplayInOrders() {
		waitForElementVisible(driver, OrdersPageUI.SHIPPING_METHOD_DETAILS);
		return isElementDisplayed(driver, OrdersPageUI.SHIPPING_METHOD_DETAILS);
	}

	@Step("Verify SKU Number display in Orders page")
	public boolean isSkuNumberDisplayInOrders() {
		waitForElementVisible(driver, OrdersPageUI.SKU_NUMBER);
		return isElementDisplayed(driver, OrdersPageUI.SKU_NUMBER);
	}

	@Step("Verify Product Name display in Orders page")
	public boolean isProductNameDisplayInOrders() {
		waitForElementVisible(driver, OrdersPageUI.PRODUCT_DETAILS);
		return isElementDisplayed(driver, OrdersPageUI.PRODUCT_DETAILS);
	}

	@Step("Verify Unit Price display in Orders page")
	public boolean isUnitPriceDisplayInOrders() {
		waitForElementVisible(driver, OrdersPageUI.UNIT_PRICE);
		return isElementDisplayed(driver, OrdersPageUI.UNIT_PRICE);
	}

	@Step("Verify product quantity display in Orders page")
	public boolean isQuantityDisplayInOrders() {
		waitForElementVisible(driver, OrdersPageUI.PRODUCT_QUANTITY);
		return isElementDisplayed(driver, OrdersPageUI.PRODUCT_QUANTITY);
	}

	@Step("Verify SubTotal display in Orders page")
	public boolean isSubTotalDisplayInOrders() {
		waitForElementVisible(driver, OrdersPageUI.SUBTOTAL_PRICE);
		return isElementDisplayed(driver, OrdersPageUI.SUBTOTAL_PRICE);
	}

	@Step("Verify gift wrapping option display in Orders page")
	public boolean isGiftWrappingDisplayInOrders() {
		waitForElementVisible(driver, OrdersPageUI.GIFT_WRAPPING_DETAILS);
		return isElementDisplayed(driver, OrdersPageUI.GIFT_WRAPPING_DETAILS);
	}

	@Step("Verify Order summary display in Orders page")
	public boolean isOrderSummaryDisplayInOrders(String orderItem, String itemAmount ) {
		waitForElementVisible(driver, OrdersPageUI.ORDER_SUMMARY_OVERVIEW, orderItem, itemAmount);
		return isElementDisplayed(driver, OrdersPageUI.ORDER_SUMMARY_OVERVIEW, orderItem, itemAmount);
	}

	@Step("Verify total summary display in Orders page")
	public boolean isTotalSummaryDisplayInOrders(String orderTotal, String totalAmount) {
		waitForElementVisible(driver, OrdersPageUI.ORDER_TOTAL, orderTotal, totalAmount);
		return isElementDisplayed(driver, OrdersPageUI.ORDER_TOTAL,orderTotal, totalAmount);
	}
	@Step("Click to Reorder button of an order")
	public void clickReorderButton() {
		waitForElementVisible(driver, OrdersPageUI.REORDER_BUTTON);
		clickToElement(driver, OrdersPageUI.REORDER_BUTTON);
		
	}

}
