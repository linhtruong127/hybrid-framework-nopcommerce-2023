package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.WishlistPageObject;
import pageObjects.user.CompareListPageObject;
import pageObjects.user.RecentlyViewPageObject;

public class NopCommerce_06_Wishlist_Compare_RecentReview extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private UserLoginPageObject loginPage;
	private WishlistPageObject wishlistPage;
	private CompareListPageObject comparelistPage;
	private RecentlyViewPageObject recentlyViewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(Common_Register.emailAddress);
		loginPage.enterToPasswordTextbox(Common_Register.password);
		homePage = loginPage.clickToUserLoginButton();
	}

	@Test
	public void Wishlist_01_Add_Product_To_Wishlist() {

		homePage.clickToProductName("Apple MacBook Pro 13-inch");
		homePage.clickToAddToWishlistButton();
		Assert.assertEquals(homePage.getSuccessMessage(), "The product has been added to your wishlist");

		homePage.refreshCurrentPage(driver);
		wishlistPage = homePage.clickToWishlistLink();
		Assert.assertTrue(wishlistPage.isProductDisplayToWishlist("Apple MacBook Pro 13-inch"));

	}

	@Test
	public void Wishlist_02_Add_Product_To_Cart_From_Wishlist() {
		wishlistPage.clickToCheckboxAddToCart();
		wishlistPage.clickToAddToCartButton();
		Assert.assertEquals(homePage.isProductRemoveFromWishlistIcon("(0)"), "(0)");
		Assert.assertEquals(homePage.isProductAddedToCartIcon("(2)"), "(2)");

	}

	@Test
	public void Wishlist_03_Remove_Product_From_Wishlist() {
		homePage.clickToLogoLink();
		homePage.clickToProductName("Apple MacBook Pro 13-inch");
		homePage.clickToAddToWishlistButton();
		homePage.refreshCurrentPage(driver);
		wishlistPage = homePage.clickToWishlistLink();

		wishlistPage.clickToRemoveProductFromWishlist();

		Assert.assertEquals(wishlistPage.isNoProductDisplayInWishlist(), "The wishlist is empty!");
		Assert.assertEquals(homePage.isProductRemoveFromWishlistIcon("(0)"), "(0)");
	}

	@Test
	public void Wishlist_04_Add_Product_To_Compare() {
		homePage.clickToLogoLink();
		homePage.clickToAddProductToCompareList("1");
		Assert.assertEquals(homePage.getAddCompareListSuccessMsg(), "The product has been added to your product comparison");

		homePage.refreshCurrentPage(driver);
		homePage.clickToAddProductToCompareList("4");
		Assert.assertEquals(homePage.getAddCompareListSuccessMsg(), "The product has been added to your product comparison");

		homePage.refreshCurrentPage(driver);
		comparelistPage = homePage.clickToCompareListLink();
		Assert.assertTrue(comparelistPage.isRemoveButtonDisplayonCompareList());
		Assert.assertTrue(comparelistPage.isProductNameDisplayonCompareList("Build your own computer"));
		Assert.assertTrue(comparelistPage.isProductNameDisplayonCompareList("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(comparelistPage.isProductPriceDisplayonCompareList("$1,200.00"));
		Assert.assertTrue(comparelistPage.isProductPriceDisplayonCompareList("$1,800.00"));

		comparelistPage.clickToClearlistButton();
		Assert.assertEquals(comparelistPage.getMessageNoItemOnCompareList(), "You have no items to compare.");

	}

	@Test
	public void Wishlist_05_Recently_Viewed_Products() {
		homePage.clickToProductMenu("Computers ");
		homePage.clickToSubProductName("Notebooks ");
		homePage.clickToProductName("Apple MacBook Pro 13-inch");

		homePage.backToPage(driver);
		homePage.clickToProductName("HP Spectre XT Pro UltraBook");

		homePage.backToPage(driver);
		homePage.clickToProductName("Lenovo Thinkpad X1 Carbon Laptop");

		homePage.backToPage(driver);
		homePage.clickToProductName("HP Spectre XT Pro UltraBook");

		homePage.backToPage(driver);
		homePage.clickToProductName("Asus N551JK-XO076H Laptop");

		recentlyViewPage = homePage.clickToRecentlyViewPage();

		Assert.assertTrue(recentlyViewPage.isProductDisplayonRecentlyViewPage("Lenovo Thinkpad X1 Carbon Laptop"));
		Assert.assertTrue(recentlyViewPage.isProductDisplayonRecentlyViewPage("HP Spectre XT Pro UltraBook"));
		Assert.assertTrue(recentlyViewPage.isProductDisplayonRecentlyViewPage("Asus N551JK-XO076H Laptop"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
