package com.nopcommerce.order;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.OrdersPageObject;
import pageObjects.user.ShoppingCartPageObject;
import pageObjects.user.UserLoginPageObject;

public class NopCommerce_07_Order extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private UserLoginPageObject loginPage;
	private ShoppingCartPageObject shoppingcartPage;
	private OrdersPageObject ordersPage;
	private CustomerPageObject customerPage;
	private String emailAddress = getEmailRandom();
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(Common_Register.emailAddress);
		loginPage.enterToPasswordTextbox(Common_Register.newPassword);
		homePage = loginPage.clickToUserLoginButton();
		
	}

	@Test
	public void Order_01_Add_Product_To_Shopping_Cart() {
		
		homePage.clickToProductMenu("Computers ");
		homePage.clickToSubProductName("Desktops ");
		homePage.clickToProductName("Build your own computer");

		homePage.selectProcessorItem("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		homePage.selectRamItem("8GB [+$60.00]");
		homePage.selectHddItem("400 GB [+$100.00]");
		homePage.selectOsItem("Vista Premium [+$60.00]");
		homePage.selectSoftwareItem("Acrobat Reader [+$10.00]");
		homePage.selectSoftwareItem("Total Commander [+$5.00]");

		homePage.clickToAddToCartButton();
		Assert.assertEquals(homePage.getAddToCartSuccessMsg(), "The product has been added to your shopping cart");
		homePage.refreshCurrentPage(driver);
		Assert.assertEquals(homePage.isProductAddedToCartIcon("(1)"), "(1)");
		
		homePage.hoverToShoppingCartIcon();
		Assert.assertTrue(homePage.isCountingMsgDisplayInCart(), "There are 1 item(s) in your cart.");
		Assert.assertTrue(homePage.isDetailedItemsDisplayInCart(),
				"Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] RAM: 8GB [+$60.00] HDD: 400 GB [+$100.00] OS: Vista Premium [+$60.00] Software: Microsoft Office [+$50.00] Software: Acrobat Reader [+$10.00] Software: Total Commander [+$5.00]");
		Assert.assertTrue(homePage.isSubTotalDisplayInCart(), "Sub-Total: $1,500.00");
	}

	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart() {
		shoppingcartPage = homePage.clickToShoppingCartLink();
		shoppingcartPage.clickEditButton();
		
		homePage.selectProcessorItem("2.2 GHz Intel Pentium Dual-Core E2200");
		homePage.selectRamItem("4GB [+$20.00]");
		homePage.selectHddItem("320 GB");
		homePage.selectOsItem("Vista Home [+$50.00]");
		
		homePage.selectSoftwareItem("Acrobat Reader [+$10.00]");
		homePage.selectSoftwareItem("Total Commander [+$5.00]");
		Assert.assertTrue(homePage.isPriceValueDisplay(), "$1,320.00");

		homePage.inputValueToQuantityBox("2");
		homePage.clickToUpdateButton();
		Assert.assertEquals(homePage.getAddToCartSuccessMsg(), "The product has been added to your shopping cart");
		homePage.refreshCurrentPage(driver);
		Assert.assertEquals(homePage.isProductAddedToCartIcon("(2)"), "(2)");
		
		homePage.hoverToShoppingCartIcon();
		Assert.assertTrue(homePage.isCountingMsgDisplayInCart(), "There are 2 item(s) in your cart.");
		Assert.assertTrue(homePage.isDetailedItemsDisplayInCart(),
				"Processor: 2.2 GHz Intel Pentium Dual-Core E2200 [+$15.00] RAM: 4GB [+$20.00 HDD: 320 GB OS: Vista Home [+$50.00] Software: Microsoft Office [+$50.00]");
		Assert.assertTrue(homePage.isSubTotalDisplayInCart(), "Sub-Total: $2,640.00");
		
	}

	@Test
	public void Order_03_Remove_Product_From_Shopping_Cart() {
		shoppingcartPage = homePage.clickToShoppingCartLink();
		shoppingcartPage.clickToRemoveProductFromCart();

		Assert.assertTrue(shoppingcartPage.isNoProductMsgDisplayInCart(), "Your Shopping Cart is empty!");
		Assert.assertEquals(homePage.isProductAddedToCartIcon("(0)"), "(0)");
	}

	@Test
	public void Order_04_Update_Shopping_Cart() {
		homePage.clickToLogoLink();
		homePage.clickToProductMenu("Computers ");
		homePage.clickToSubProductName("Notebooks ");
		homePage.clickToProductName("Asus N551JK-XO076H Laptop");
		homePage.clickToAddToCartButton();
		
		shoppingcartPage = homePage.clickToShoppingCartLink();
		shoppingcartPage.clickToUpdateQuantityInCart("2");
		shoppingcartPage.clickToUpdateShoppingCartButton();
		Assert.assertTrue(shoppingcartPage.isUnitPriceDisplayInCart(), "$1,500.00");
		Assert.assertTrue(shoppingcartPage.isSubTotalDisplayInCart(), "$3,000.00");	
	}

	@Test
	public void Order_05_Checkout_Product_Payment_Method_By_Cheque() {
		shoppingcartPage = homePage.clickToShoppingCartLink();
		shoppingcartPage.selectGiftWrappingOption("No");
		shoppingcartPage.clickToEstimateShippingButton();
		shoppingcartPage.selectCountryInEstimateShipping("Viet Nam");
		shoppingcartPage.inputZipcodeInEstimateShipping("70000");
		shoppingcartPage.clickToApplyButton();
		shoppingcartPage.clickToTermsOfServiceCheckbox();
		shoppingcartPage.clickToCheckoutButton();
		
		shoppingcartPage.clickToSameAddressCheckbox();
		shoppingcartPage.selectBillingAddressOption("New Address");
		shoppingcartPage.inputFirstNameInBilling("linh");
		shoppingcartPage.inputLastNameInBilling("truong");
		shoppingcartPage.inputEmailInBilling(emailAddress);
		shoppingcartPage.selectCountryInBilling("Viet Nam");
		shoppingcartPage.inputCityInBilling("HCM");
		shoppingcartPage.inputAddress1InBilling("123 ABC");
		shoppingcartPage.inputZipcodeInBilling("70000");
		shoppingcartPage.inputPhonenumberInBilling("12345678");
		shoppingcartPage.clickToBillingContinueButton();
		
		shoppingcartPage.selectShippingAddressOption("New Address");
		shoppingcartPage.selectCountryInShippingAddress("Viet Nam");
		shoppingcartPage.inputCityInShippingAddress("Da Nang");
		shoppingcartPage.inputAddress1InShippingAddress("123 QWE");
		shoppingcartPage.inputZipcodeInShippingAddress("70000");
		shoppingcartPage.inputPhonenumberInShippingAddress("23456789");
		shoppingcartPage.clickToShippingAddressContinueButton();
		
		shoppingcartPage.selectShippingMethodOption("Ground ($0.00)");
		shoppingcartPage.clickToShippingMethodContinueButton();
		
		shoppingcartPage.selectPaymentMethodOption("Check / Money Order");
		shoppingcartPage.clickToPaymentMethodContinueButton();
		
		Assert.assertTrue(shoppingcartPage.isPaymentInfoDisplayCorrectly(), "NOP SOLUTIONS your address here, New York, NY 10001 USA");			
		
		shoppingcartPage.clickToPaymentInfoContinueButton();
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("name"), "linh truong"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("email"), "Email: " + emailAddress); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("phone"), "Phone: 12345678"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("address1"), "123 ABC"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("city-state-zip"), "HCM,70000"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("country"), "Viet Nam"); 
		Assert.assertTrue(shoppingcartPage.isPaymentMethodDisplayInConfirmOrder(), "Check / Money Order"); 
		
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("name"), "Lisa Truong"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("email"), "Email: " + Common_Register.emailAddress); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("phone"), "Phone: 23456789"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("address1"), "123 QWE"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("city-state-zip"), "Da Nang,70000"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("country"), "Viet Nam"); 
		Assert.assertTrue(shoppingcartPage.isShippingMethodDisplayInConfirmOrder(), "Ground"); 
		Assert.assertTrue(shoppingcartPage.isSkuNumberDisplayInCart(), "AP_MBP_1033"); 
		Assert.assertTrue(shoppingcartPage.isProductNameDisplayInCart(), "Asus N551JK-XO076H Laptop"); 
		Assert.assertTrue(shoppingcartPage.isUnitPriceDisplayInCart(), "$1,500.00");
		Assert.assertTrue(shoppingcartPage.isQuantityDisplayInCart(), "2");
		Assert.assertTrue(shoppingcartPage.isSubTotalDisplayInCart(), "$3,000.00");
		Assert.assertTrue(shoppingcartPage.isGiftWrappingDisplayInConfirmOrder(), "No");
		Assert.assertTrue(shoppingcartPage.isSubTotalSummaryDisplayInConfirmOrder(), "$3,000.00");
		Assert.assertTrue(shoppingcartPage.isShippingSummaryDisplayInConfirmOrder(), "$0.00");
		Assert.assertTrue(shoppingcartPage.isTaxSummaryDisplayInConfirmOrder(), "$0.00");
		Assert.assertTrue(shoppingcartPage.isTotalSummaryDisplayInConfirmOrder(), "$3,000.00");

		shoppingcartPage.clickToConfirmButton();
		Assert.assertTrue(shoppingcartPage.isCompeleteOrderMsgDisplay(), "Your order has been successfully processed!");
		Assert.assertTrue(shoppingcartPage.isOrderNumberDisplay(), "Order number: 1031");
        
		customerPage = homePage.clickToMyaccountLink();
		customerPage.openDynamicSidebarPage(driver, "Orders");
		ordersPage = PageGeneratorManager.getOdersPage(driver);
		
		Assert.assertTrue(ordersPage.isOrderNumberDisplay(), "Order number: 1031");
		ordersPage.clickToDetailsButton();
		Assert.assertTrue(ordersPage.isOrderNumberDetailsDisplay(), "Order #1031");
		Assert.assertTrue(ordersPage.isOrderOverviewDetailsDisplay("order-date"), "Wednesday, October 11, 2023");
		Assert.assertTrue(ordersPage.isOrderOverviewDetailsDisplay("order-status"), "Order Status: Pending");
		Assert.assertTrue(ordersPage.isOrderOverviewDetailsDisplay("order-total"), "Order Total: $1,500.00");
		
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("name"), "linh truong"); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("email"), "Email: " + emailAddress); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("phone"), "Phone: 12345678"); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("address1"), "123 ABC"); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("city-state-zip"), "HCM,70000"); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("country"), "Viet Nam"); 
		Assert.assertTrue(ordersPage.isPaymentMethodDisplayInOrders(), "Check / Money Order"); 
		
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("name"), "Lisa Truong"); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("email"), "Email: " + Common_Register.emailAddress); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("phone"), "Phone: 23456789"); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("address1"), "123 QWE"); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("city-state-zip"), "Da Nang,70000"); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("country"), "Viet Nam"); 
		Assert.assertTrue(ordersPage.isShippingMethodDisplayInOrders(), "Ground"); 
		Assert.assertTrue(ordersPage.isSkuNumberDisplayInOrders(), "AP_MBP_1033"); 
		Assert.assertTrue(ordersPage.isProductNameDisplayInOrders(), "Asus N551JK-XO076H Laptop"); 
		Assert.assertTrue(ordersPage.isUnitPriceDisplayInOrders(), "$1,500.00");
		Assert.assertTrue(ordersPage.isQuantityDisplayInOrders(), "1");
		Assert.assertTrue(ordersPage.isSubTotalDisplayInOrders(), "$3,000.00");
		Assert.assertTrue(ordersPage.isGiftWrappingDisplayInOrders(), "No");
		Assert.assertTrue(ordersPage.isOrderSummaryDisplayInOrders("Sub-Total:","$3,000.00"));
		Assert.assertTrue(ordersPage.isOrderSummaryDisplayInOrders("Shipping:", "$0.00"));
		Assert.assertTrue(ordersPage.isOrderSummaryDisplayInOrders("Tax:", "$0.00"));
		Assert.assertTrue(ordersPage.isTotalSummaryDisplayInOrders("Order Total:", "$3,000.00"));

	}

	@Test
	public void Order_06_Checkout_Product_Payment_Method_By_Card() {

		homePage.clickToLogoLink();
		homePage.sleepInSecond(10);
		homePage.clickToProductMenu("Computers ");
		homePage.clickToSubProductName("Notebooks ");
		homePage.clickToProductName("HP Spectre XT Pro UltraBook");
		homePage.clickToAddToCartButton();
		shoppingcartPage = homePage.clickToShoppingCartLink();
		shoppingcartPage.selectGiftWrappingOption("No");
		shoppingcartPage.clickToEstimateShippingButton();
		shoppingcartPage.selectCountryInEstimateShipping("Viet Nam");
		shoppingcartPage.inputZipcodeInEstimateShipping("70000");
		shoppingcartPage.clickToApplyButton();
		shoppingcartPage.clickToTermsOfServiceCheckbox();
		shoppingcartPage.clickToCheckoutButton();
		
		shoppingcartPage.clickToSameAddressCheckbox();
		shoppingcartPage.selectBillingAddressOption("New Address");
		shoppingcartPage.inputFirstNameInBilling("linh");
		shoppingcartPage.inputLastNameInBilling("truong");
		shoppingcartPage.inputEmailInBilling(emailAddress);
		shoppingcartPage.selectCountryInBilling("Viet Nam");
		shoppingcartPage.inputCityInBilling("HCM");
		shoppingcartPage.inputAddress1InBilling("123 ABC");
		shoppingcartPage.inputZipcodeInBilling("70000");
		shoppingcartPage.inputPhonenumberInBilling("12345678");
		shoppingcartPage.clickToBillingContinueButton();
		
		shoppingcartPage.selectShippingAddressOption("New Address");
		shoppingcartPage.selectCountryInShippingAddress("Viet Nam");
		shoppingcartPage.inputCityInShippingAddress("Da Nang");
		shoppingcartPage.inputAddress1InShippingAddress("123 QWE");
		shoppingcartPage.inputZipcodeInShippingAddress("70000");
		shoppingcartPage.inputPhonenumberInShippingAddress("23456789");
		shoppingcartPage.clickToShippingAddressContinueButton();
		
		shoppingcartPage.selectShippingMethodOption("Ground ($0.00)");
		shoppingcartPage.clickToShippingMethodContinueButton();
		
		shoppingcartPage.selectPaymentMethodOption("Credit Card");
		shoppingcartPage.clickToPaymentMethodContinueButton();
		shoppingcartPage.selectTypeOfCard("Visa");
		shoppingcartPage.inputCardHolderName("Lin Tran");
		shoppingcartPage.inputCardNumber("4263982640269299");
		shoppingcartPage.selectCardExpireMonth("02");
		shoppingcartPage.selectCardExpireYear("2026");
		shoppingcartPage.inputCardCode("887");

		shoppingcartPage.clickToPaymentInfoContinueButton();
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("name"), "linh truong"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("email"), "Email: " + emailAddress); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("phone"), "Phone: 12345678"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("address1"), "123 ABC"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("city-state-zip"), "HCM,70000"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("country"), "Viet Nam"); 
		Assert.assertTrue(shoppingcartPage.isPaymentMethodDisplayInConfirmOrder(), "Credit Card"); 
		
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("name"), "Lisa Truong"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("email"), "Email: " + Common_Register.emailAddress); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("phone"), "Phone: 23456789"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("address1"), "123 QWE"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("city-state-zip"), "Da Nang,70000"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("country"), "Viet Nam"); 
		Assert.assertTrue(shoppingcartPage.isShippingMethodDisplayInConfirmOrder(), "Ground"); 
		Assert.assertTrue(shoppingcartPage.isSkuNumberDisplayInCart(), "AP_MBP_1033"); 
		Assert.assertTrue(shoppingcartPage.isProductNameDisplayInCart(), "HP Spectre XT Pro UltraBook"); 
		Assert.assertTrue(shoppingcartPage.isUnitPriceDisplayInCart(), "$1,350.00");
		Assert.assertTrue(shoppingcartPage.isQuantityDisplayInCart(), "1");
		Assert.assertTrue(shoppingcartPage.isSubTotalDisplayInCart(), "$1,350.00");
		Assert.assertTrue(shoppingcartPage.isGiftWrappingDisplayInConfirmOrder(), "No");
		Assert.assertTrue(shoppingcartPage.isSubTotalSummaryDisplayInConfirmOrder(), "$1,350.00");
		Assert.assertTrue(shoppingcartPage.isShippingSummaryDisplayInConfirmOrder(), "$0.00");
		Assert.assertTrue(shoppingcartPage.isTaxSummaryDisplayInConfirmOrder(), "$0.00");
		Assert.assertTrue(shoppingcartPage.isTotalSummaryDisplayInConfirmOrder(), "$1,350.00");

		shoppingcartPage.clickToConfirmButton();
		Assert.assertTrue(shoppingcartPage.isCompeleteOrderMsgDisplay(), "Your order has been successfully processed!");
		Assert.assertTrue(shoppingcartPage.isOrderNumberDisplay(), "Order number: 1032");
        
		customerPage = homePage.clickToMyaccountLink();
		customerPage.openDynamicSidebarPage(driver, "Orders");
		ordersPage = PageGeneratorManager.getOdersPage(driver);
		
		Assert.assertTrue(ordersPage.isOrderNumberDisplay(), "Order number: 1032");
		ordersPage.clickToDetailsButton();
		Assert.assertTrue(ordersPage.isOrderNumberDetailsDisplay(), "Order #1032");
		Assert.assertTrue(ordersPage.isOrderOverviewDetailsDisplay("order-date"), "Wednesday, October 11, 2023");
		Assert.assertTrue(ordersPage.isOrderOverviewDetailsDisplay("order-status"), "Order Status: Pending");
		Assert.assertTrue(ordersPage.isOrderOverviewDetailsDisplay("order-total"), "Order Total: $1,500.00");
		
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("name"), "linh truong"); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("email"), "Email: " + emailAddress); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("phone"), "Phone: 12345678"); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("address1"), "123 ABC"); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("city-state-zip"), "HCM,70000"); 
		Assert.assertEquals(ordersPage.getBilllingInfoDisplayInOrders("country"), "Viet Nam"); 
		Assert.assertTrue(ordersPage.isPaymentMethodDisplayInOrders(), "Credit Card"); 
		
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("name"), "Lisa Truong"); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("email"), "Email: " + Common_Register.emailAddress); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("phone"), "Phone: 23456789"); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("address1"), "123 QWE"); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("city-state-zip"), "Da Nang,70000"); 
		Assert.assertEquals(ordersPage.getShippingAddressDisplayInOrders("country"), "Viet Nam"); 
		Assert.assertTrue(ordersPage.isShippingMethodDisplayInOrders(), "Ground"); 
		Assert.assertTrue(ordersPage.isSkuNumberDisplayInOrders(), "AP_MBP_1033"); 
		Assert.assertTrue(ordersPage.isProductNameDisplayInOrders(), "HP Spectre XT Pro UltraBook"); 
		Assert.assertTrue(ordersPage.isUnitPriceDisplayInOrders(), "$1,350.00");
		Assert.assertTrue(ordersPage.isQuantityDisplayInOrders(), "1");
		Assert.assertTrue(ordersPage.isSubTotalDisplayInOrders(), "$1,350.00");
		Assert.assertTrue(ordersPage.isGiftWrappingDisplayInOrders(), "No");
		Assert.assertTrue(ordersPage.isOrderSummaryDisplayInOrders("Sub-Total:","$1,350.00"));
		Assert.assertTrue(ordersPage.isOrderSummaryDisplayInOrders("Shipping:", "$0.00"));
		Assert.assertTrue(ordersPage.isOrderSummaryDisplayInOrders("Tax:", "$0.00"));
		Assert.assertTrue(ordersPage.isTotalSummaryDisplayInOrders("Order Total:", "$1,350.00"));

	}	
	
	@Test
	public void Order_07_ReOder_Product_That_Order_Success_Before() {
		customerPage = homePage.clickToMyaccountLink();
		customerPage.openDynamicSidebarPage(driver, "Orders");
		ordersPage = PageGeneratorManager.getOdersPage(driver);
		ordersPage.clickToDetailsButton();
		ordersPage.clickReorderButton();
		shoppingcartPage.clickToUpdateQuantityInCart("10");
		shoppingcartPage.clickToUpdateShoppingCartButton();
		shoppingcartPage.clickToTermsOfServiceCheckbox();
		shoppingcartPage.clickToCheckoutButton();
		
		shoppingcartPage.clickToSameAddressCheckbox();
		shoppingcartPage.selectBillingAddressOption("New Address");
		shoppingcartPage.inputFirstNameInBilling("Lyn");
		shoppingcartPage.inputLastNameInBilling("Tran");
		shoppingcartPage.inputEmailInBilling(emailAddress);
		shoppingcartPage.selectCountryInBilling("Viet Nam");
		shoppingcartPage.inputCityInBilling("Dong Nai");
		shoppingcartPage.inputAddress1InBilling("456 Hong Bang");
		shoppingcartPage.inputZipcodeInBilling("60000");
		shoppingcartPage.inputPhonenumberInBilling("87654321");
		shoppingcartPage.clickToBillingContinueButton();
		
		shoppingcartPage.selectShippingAddressOption("New Address");
		shoppingcartPage.selectCountryInShippingAddress("Viet Nam");
		shoppingcartPage.inputCityInShippingAddress("Da Nang");
		shoppingcartPage.inputAddress1InShippingAddress("123 Cao Lo");
		shoppingcartPage.inputZipcodeInShippingAddress("40000");
		shoppingcartPage.inputPhonenumberInShippingAddress("98765432");
		shoppingcartPage.clickToShippingAddressContinueButton();
		
		shoppingcartPage.selectShippingMethodOption("Next Day Air ($0.00)");
		shoppingcartPage.clickToShippingMethodContinueButton();
		
		shoppingcartPage.selectPaymentMethodOption("Credit Card");
		shoppingcartPage.clickToPaymentMethodContinueButton();
		shoppingcartPage.selectTypeOfCard("Visa");
		shoppingcartPage.inputCardHolderName("Lin Tran");
		shoppingcartPage.inputCardNumber("4263982640269299");
		shoppingcartPage.selectCardExpireMonth("02");
		shoppingcartPage.selectCardExpireYear("2026");
		shoppingcartPage.inputCardCode("887");

		shoppingcartPage.clickToPaymentInfoContinueButton();
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("name"), "Lyn Tran"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("email"), "Email: " + emailAddress); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("phone"), "Phone: 87654321"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("address1"), "456 Hong Bang"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("city-state-zip"), "Dong Nai,60000"); 
		Assert.assertEquals(shoppingcartPage.getBilllingInfoDisplayInConfirmOrder("country"), "Viet Nam"); 
		Assert.assertTrue(shoppingcartPage.isPaymentMethodDisplayInConfirmOrder(), "Credit Card"); 
		
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("name"), "Lisa Truong"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("email"), "Email: " + Common_Register.emailAddress); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("phone"), "Phone: 98765432"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("address1"), "123 Cao Lo"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("city-state-zip"), "Da Nang,40000"); 
		Assert.assertEquals(shoppingcartPage.getShippingAddressDisplayInConfirmOrder("country"), "Viet Nam"); 
		Assert.assertTrue(shoppingcartPage.isShippingMethodDisplayInConfirmOrder(), "Next Day Air"); 
		Assert.assertTrue(shoppingcartPage.isSkuNumberDisplayInCart(), "AP_MBP_1033"); 
		Assert.assertTrue(shoppingcartPage.isProductNameDisplayInCart(), "Asus N551JK-XO076H Laptop"); 
		Assert.assertTrue(shoppingcartPage.isUnitPriceDisplayInCart(), "$1,500.00");
		Assert.assertTrue(shoppingcartPage.isQuantityDisplayInCart(), "1");
		Assert.assertTrue(shoppingcartPage.isSubTotalDisplayInCart(), "$15,000.00");
		Assert.assertTrue(shoppingcartPage.isGiftWrappingDisplayInConfirmOrder(), "No");
		Assert.assertTrue(shoppingcartPage.isSubTotalSummaryDisplayInConfirmOrder(), "$15,000.00");
		Assert.assertTrue(shoppingcartPage.isShippingSummaryDisplayInConfirmOrder(), "$0.00");
		Assert.assertTrue(shoppingcartPage.isTaxSummaryDisplayInConfirmOrder(), "$0.00");
		Assert.assertTrue(shoppingcartPage.isTotalSummaryDisplayInConfirmOrder(), "$15,000.00");
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
