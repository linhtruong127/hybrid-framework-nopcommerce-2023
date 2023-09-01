package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.AddressesPageObject;
import pageObjects.user.BackInStockSubscriptionsPageObject;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.DownloadableProductsPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.MyProductReviewsPageObject;
import pageObjects.user.OrdersPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointsPageObject;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerPageObject getCustomerPage(WebDriver driver) {
		return new CustomerPageObject(driver);
	}

	public static CustomerPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerPageObject(driver);
	}

	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}

	public static OrdersPageObject getOrdersPage(WebDriver driver) {
		return new OrdersPageObject(driver);
	}

	public static DownloadableProductsPageObject getDownloadableProductsPage(WebDriver driver) {
		return new DownloadableProductsPageObject(driver);
	}

	public static BackInStockSubscriptionsPageObject getBackInStockSubscriptionsPage(WebDriver driver) {
		return new BackInStockSubscriptionsPageObject(driver);
	}
	
	public static RewardPointsPageObject getRewardPointsPage(WebDriver driver) {
		return new RewardPointsPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static MyProductReviewsPageObject getMyProductReviewsPage(WebDriver driver) {
		return new MyProductReviewsPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
}
