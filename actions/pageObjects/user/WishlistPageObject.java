package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify product is added to wishlist")
	public boolean isProductDisplayToWishlist(String productName) {
		waitForElementVisible(driver, WishlistPageUI.PRODUCT_NAME_ON_WISHLIST, productName);
		return isElementDisplayed(driver, WishlistPageUI.PRODUCT_NAME_ON_WISHLIST, productName);
	}
	@Step("Click to wishlist url for sharing")
	public void clickToWishlistUrlForSharing() {
		waitForElementClickable(driver, WishlistPageUI.WISHLIST_URL_FOR_SHARING);
		clickToElement(driver, WishlistPageUI.WISHLIST_URL_FOR_SHARING);
		
	}
	@Step("Click to button Add To Cart ")
	public void clickToAddToCartButton() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		
	}

	public void clickToCheckboxAddToCart() {
		waitForElementVisible(driver, WishlistPageUI.CHECKBOX_ADD_TO_CART);
		checkToElement(driver, WishlistPageUI.CHECKBOX_ADD_TO_CART);
		
	}

	public void clickToRemoveProductFromWishlist() {
		waitForElementClickable(driver, WishlistPageUI.REMOVE_BUTTON_IN_WISHLIST);
		clickToElement(driver, WishlistPageUI.REMOVE_BUTTON_IN_WISHLIST);
		
	}

	public String isNoProductDisplayInWishlist() {
		waitForElementVisible(driver, WishlistPageUI.NO_PRODUCT_IN_WISHLIST_MSG);
		return getElementText(driver, WishlistPageUI.NO_PRODUCT_IN_WISHLIST_MSG);
	}

		
	}

