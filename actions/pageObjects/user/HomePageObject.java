package pageObjects.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BaseElement;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BaseElement {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click to register link")
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	@Step("Click to login link")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Click to my account link")
	public CustomerPageObject clickToMyaccountLink() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	@Step("Open my account link")
	public CustomerPageObject openMyaccountLink() {
		String myAccountLink = getElementAttribute(driver, HomePageUI.MYACCOUNT_LINK, "href");
		openPageURL(driver, myAccountLink);
		return PageGeneratorManager.getCustomerPage(driver);
	}

	@Step("Click to logout link")
	public HomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	@Step("Verify register link display")
	public boolean isRegisterLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
	}

	@Step("Click to product name")
	public void clickToProductName(String productName) {
		waitForElementClickable(driver, HomePageUI.PRODUCT_NAME, productName);
		clickToElement(driver, HomePageUI.PRODUCT_NAME, productName);

	}

	@Step("Click to add your review")
	public void clickToAddYourReview() {
		waitForElementClickable(driver, HomePageUI.ADD_REVIEW_PRODUCT);
		clickToElement(driver, HomePageUI.ADD_REVIEW_PRODUCT);

	}

	@Step("Input review title")
	public void inputReviewTitle(String reviewTitle) {
		waitForElementClickable(driver, HomePageUI.ADD_REVIEW_TITLE);
		sendkeyToElement(driver, HomePageUI.ADD_REVIEW_TITLE, reviewTitle);

	}

	@Step("Input review text")
	public void inputReviewText(String reviewText) {
		waitForElementClickable(driver, HomePageUI.ADD_REVIEW_TEXT);
		sendkeyToElement(driver, HomePageUI.ADD_REVIEW_TEXT, reviewText);

	}

	@Step("Click to submit review button")
	public void clickSubmitReviewButton() {
		waitForElementClickable(driver, HomePageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, HomePageUI.SUBMIT_REVIEW_BUTTON);

	}

	@Step("Click to search link")
	public SearchPageObject clickToSearchLink() {
		waitForElementClickable(driver, HomePageUI.SEARCH_LINK);
		clickToElement(driver, HomePageUI.SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(driver);
	}

	@Step("Click to product menu")
	public void clickToProductMenu(String productItem) {
		waitForElementClickable(driver, HomePageUI.SELECT_PRODUCT_MENU, productItem);
		clickToElement(driver, HomePageUI.SELECT_PRODUCT_MENU, productItem);

	}

	@Step("Click to sub product name")
	public void clickToSubProductName(String subItem) {
		waitForElementClickable(driver, HomePageUI.SELECT_SUB_MENU, subItem);
		clickToElement(driver, HomePageUI.SELECT_SUB_MENU, subItem);

	}

	@Step("Click to select sort type")
	public void selectSortType(String sortType) {
		waitForElementClickable(driver, HomePageUI.SELECT_SORT_TYPE, sortType);
		clickToElement(driver, HomePageUI.SELECT_SORT_TYPE, sortType);

	}

	@Step("Verify result display as ascending order")
	public boolean isResultDisplayedAsAscendingOrder() {
		List<String> allItems = new ArrayList<String>();
		List<WebElement> allProductItems = getListWebElement(driver, HomePageUI.SORTING_RESULT_BASED_PRODUCT_TITLE);

		for (WebElement productItem : allProductItems) {
			allItems.add(productItem.getText());
			Collections.sort(allItems);
			System.out.println(allItems);
		}
		return true;
	}

	@Step("Verify result display as descending order")
	public boolean isResultDisplayedAsDescendingOrder() {
		List<String> allItems = new ArrayList<String>();
		List<WebElement> allProductItems = getListWebElement(driver, HomePageUI.SORTING_RESULT_BASED_PRODUCT_TITLE);

		for (WebElement productItem : allProductItems) {
			allItems.add(productItem.getText());
			Collections.sort(allItems, Collections.reverseOrder());
			System.out.println(allItems);

		}
		return true;
	}

	@Step("Verify result display as Low To High price")
	public boolean isPricesDisplayedLowToHigh() {
		List<String> sortedPrices = new ArrayList<String>();
		List<WebElement> allProductPrice = getListWebElement(driver, HomePageUI.SORTING_RESULT_BASED_PRODUCT_PRICE);

		for (WebElement priceItem : allProductPrice) {
			sortedPrices.add(priceItem.getText());
			Collections.sort(sortedPrices);
			System.out.println(sortedPrices);

		}
		return true;
	}

	@Step("Verify result display as High To Low price")
	public boolean isPricesDisplayedHighToLow() {
		List<String> sortedPrices = new ArrayList<String>();
		List<WebElement> allProductPrice = getListWebElement(driver, HomePageUI.SORTING_RESULT_BASED_PRODUCT_PRICE);

		for (WebElement priceItem : allProductPrice) {
			sortedPrices.add(priceItem.getText());
			Collections.sort(sortedPrices, Collections.reverseOrder());
			System.out.println(sortedPrices);
		}
		return true;
	}

	@Step("Select page size")
	public void selectThePagesizeToDisplay(String selectItem) {
		waitForElementClickable(driver, HomePageUI.SELECT_PAGESIZE, selectItem);
		clickToElement(driver, HomePageUI.SELECT_PAGESIZE, selectItem);

	}

	@Step("Verify page size")
	public int getPageSize() {
		waitForElementVisible(driver, HomePageUI.SORTING_RESULT_BASED_PRODUCT_TITLE);
		return getListElementSize(driver, HomePageUI.SORTING_RESULT_BASED_PRODUCT_TITLE);

	}

	public boolean isNextIconDisplayed() {
		waitForElementVisible(driver, HomePageUI.NEXT_ICON);
		return isElementDisplayed(driver, HomePageUI.NEXT_ICON);
	}

	public boolean isPreviousIconDisplayed() {
		waitForElementVisible(driver, HomePageUI.PREVIOUS_ICON);
		return isElementDisplayed(driver, HomePageUI.PREVIOUS_ICON);
	}

	public void clickToNextPage() {
		waitForElementClickable(driver, HomePageUI.NEXT_ICON);
		clickToElement(driver, HomePageUI.NEXT_ICON);

	}

	@Step("Verify paging bar display")
	public boolean isPagingBarNotDisplayed() {
		waitForElementInvisible(driver, HomePageUI.PAGING_BAR);
		return true;

	}

	@Step("Click to wishlist link")
	public WishlistPageObject clickToWishlistLink() {
		waitForElementClickable(driver, HomePageUI.WISHLIST_LINK);
		clickToElement(driver, HomePageUI.WISHLIST_LINK);
		return PageGeneratorManager.getWishlistPage(driver);
	}

	@Step("Click to button Add to wishlist")
	public void clickToAddToWishlistButton() {
		waitForElementClickable(driver, HomePageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, HomePageUI.ADD_TO_WISHLIST_BUTTON);

	}

	@Step("Verify the add wishlist success message display")
	public String getSuccessMessage() {
		waitForElementVisible(driver, HomePageUI.ADD_WISHLIST_SUCCESS_MSG);
		return getElementText(driver, HomePageUI.ADD_WISHLIST_SUCCESS_MSG);
	}

	@Step("Verify product is removed from wishlist")
	public String isProductRemoveFromWishlistIcon(String wishlistQuantity) {
		waitForElementVisible(driver, HomePageUI.PRODUCT_IN_WISHLIST, wishlistQuantity);
		return getElementText(driver, HomePageUI.PRODUCT_IN_WISHLIST, wishlistQuantity);
	}

	@Step("Verify product is added to shopping cart")
	public String isProductAddedToCartIcon(String cartQuantity) {
		waitForElementVisible(driver, HomePageUI.PRODUCT_IN_CART, cartQuantity);
		return getElementText(driver, HomePageUI.PRODUCT_IN_CART, cartQuantity);
	}

	@Step("Add product to compare list")
	public void clickToAddProductToCompareList(String productId) {
		waitForElementVisible(driver, HomePageUI.ADD_PRODUCT_TO_COMPARE_LIST, productId);
		clickToElement(driver, HomePageUI.ADD_PRODUCT_TO_COMPARE_LIST, productId);

	}

	@Step("Verify the add compare list success message display")
	public String getAddCompareListSuccessMsg() {
		waitForElementVisible(driver, HomePageUI.ADD_TO_COMPARE_LIST_SUCCESS_MSG);
		return getElementText(driver, HomePageUI.ADD_TO_COMPARE_LIST_SUCCESS_MSG);
	}

	@Step("Click to compare list link")
	public CompareListPageObject clickToCompareListLink() {
		waitForElementClickable(driver, HomePageUI.COMPARELIST_PAGE);
		clickToElement(driver, HomePageUI.COMPARELIST_PAGE);
		return PageGeneratorManager.getComparelistPage(driver);
	}

	@Step("Click to Recently View Page")
	public RecentlyViewPageObject clickToRecentlyViewPage() {
		waitForElementClickable(driver, HomePageUI.RECENTLY_VIEW_PAGE);
		clickToElement(driver, HomePageUI.RECENTLY_VIEW_PAGE);
		return PageGeneratorManager.getRecentlyViewPage(driver);
	}

	@Step("Click to select Processor item")
	public void selectProcessorItem(String processorItem) {
		waitForElementClickable(driver, HomePageUI.SELECT_PROCESSOR, processorItem);
		clickToElement(driver, HomePageUI.SELECT_PROCESSOR, processorItem);

	}

	@Step("Click to select RAM item")
	public void selectRamItem(String ramItem) {
		waitForElementClickable(driver, HomePageUI.SELECT_RAM, ramItem);
		clickToElement(driver, HomePageUI.SELECT_RAM, ramItem);

	}

	@Step("Click to select HDD item")
	public void selectHddItem(String hddItem) {
		waitForElementClickable(driver, HomePageUI.SELECT_HDD, hddItem);
		checkToElement(driver, HomePageUI.SELECT_HDD, hddItem);

	}

	@Step("Click to select OS item")
	public void selectOsItem(String osItem) {
		waitForElementClickable(driver, HomePageUI.SELECT_OS, osItem);
		checkToElement(driver, HomePageUI.SELECT_OS, osItem);

	}

	@Step("Click to select software item")
	public void selectSoftwareItem(String softwareItem) {
		waitForElementClickable(driver, HomePageUI.SELECT_SOFTWARE, softwareItem);
		checkToElement(driver, HomePageUI.SELECT_SOFTWARE, softwareItem);

	}

	@Step("Click to Add To Cart button")
	public void clickToAddToCartButton() {
	waitForElementClickable(driver, HomePageUI.ADD_TO_CART_BUTTON);
	clickToElement(driver, HomePageUI.ADD_TO_CART_BUTTON);

	}

	@Step("Verify the adding cart success message display")
	public String getAddToCartSuccessMsg() {
		waitForElementVisible(driver, HomePageUI.ADD_TO_CART_SUCCESS_MSG);
		return getElementText(driver, HomePageUI.ADD_TO_CART_SUCCESS_MSG);
	}

	@Step("Verify the counting message display")
	public boolean isCountingMsgDisplayInCart() {
		waitForElementVisible(driver, HomePageUI.COUNTING_MSG_IN_CART);
		return isElementDisplayed(driver, HomePageUI.COUNTING_MSG_IN_CART);
	}

	@Step("Verify the detailed items display in cart")
	public boolean isDetailedItemsDisplayInCart() {
		waitForElementVisible(driver, HomePageUI.DETAILED_PRODUCT_IN_CART);
		return isElementDisplayed(driver, HomePageUI.DETAILED_PRODUCT_IN_CART);
	}

	@Step("Verify the sub total price display")
	public boolean isSubTotalDisplayInCart() {
		waitForElementVisible(driver, HomePageUI.SUB_TOTAL_IN_CART);
		return isElementDisplayed(driver, HomePageUI.SUB_TOTAL_IN_CART);
	}

	@Step("Click to Shopping Cart link")
	public ShoppingCartPageObject clickToShoppingCartLink() {
		waitForElementClickable(driver, HomePageUI.SHOPPING_CART_LINK);
		clickToElement(driver, HomePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	@Step("Verify the price display correct")
	public boolean isPriceValueDisplay() {
		waitForElementVisible(driver, HomePageUI.PRICE_VALUE);
		return isElementDisplayed(driver, HomePageUI.PRICE_VALUE);
	}

	@Step("Input the quantity to quantity box ")
	public void inputValueToQuantityBox(String updateQuantity) {
		waitForElementVisible(driver, HomePageUI.INPUT_QUANTITY);
		sendkeyToElement(driver, HomePageUI.INPUT_QUANTITY, updateQuantity);

	}

	@Step("Click to Update button")
	public void clickToUpdateButton() {
		waitForElementClickable(driver, HomePageUI.UPDATE_BUTTON);
		clickToElement(driver, HomePageUI.UPDATE_BUTTON);

	}
	@Step("Hover To shopping cart icon")
	public void hoverToShoppingCartIcon() {
		waitForElementVisible(driver, HomePageUI.SHOPPING_CART_LINK);
		hoverToElement(driver, HomePageUI.SHOPPING_CART_LINK);
	}

}
