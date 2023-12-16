package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BaseElement {
	WebDriver driver;

	public MyAccountSideBarPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public CustomerPageObject openCustomerInfoPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}

	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESSES_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}

	public RewardPointsPageObject openRewardPointsPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.REWARD_POINTS_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getRewardPointsPage(driver);
	}

	public OrdersPageObject openOrdersPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.ORDERS_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.ORDERS_LINK);
		return PageGeneratorManager.getOrdersPage(driver);
	}

	public ChangePasswordPageObject openChangePasswordPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getChangePasswordPage(driver);
	}

	public DownloadableProductsPageObject openDownloadableProductsPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
		return PageGeneratorManager.getDownloadableProductsPage(driver);
	}

	public BackInStockSubscriptionsPageObject openBackInStockSubscriptionsPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		return PageGeneratorManager.getBackInStockSubscriptionsPage(driver);
	}

	public MyProductReviewsPageObject openMyProductReviewsPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.MY_PRODUCTS_REVIEWS_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.MY_PRODUCTS_REVIEWS_LINK);
		return PageGeneratorManager.getMyProductReviewsPage(driver);
	}

	public MyAccountSideBarPageObject openDynamicSidebarLessPage(String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerInfoPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrdersPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressesPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointsPage(driver);
		case "Change password":
			return PageGeneratorManager.getAddressesPage(driver);
		default:
			return null;
		}
	}

	public void openDynamicSidebarPage(WebDriver driver, String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK, pageName);

	}
}
