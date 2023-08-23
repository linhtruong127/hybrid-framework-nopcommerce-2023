package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	protected static BasePage getBasePage() {
		return new BasePage();
	}

	protected void openPageURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();

	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());

	}

	protected void acceptToAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();

	}

	protected void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();

	}

	protected String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();

	}

	protected void senkeyToAlert(WebDriver driver, String keyToSend) {
		waitForAlertPresence(driver).sendKeys(keyToSend);

	}

	protected void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected Set<org.openqa.selenium.Cookie> getBrowserCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	protected void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	protected void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

	protected By getByXpath(String locator) {
		return By.xpath(locator);
	}

	protected WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	protected List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected void sendkeyToElement(WebDriver driver, WebElement element, String valueToSend) {
		element.clear();
		element.sendKeys(valueToSend);
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, WebElement element, String itemValue) {
		new Select(element).selectByVisibleText(itemValue);
	}

	protected String getFirstSelectedTextInDefaultDropdown(WebDriver driver, WebElement element) {
		return new Select(element).getFirstSelectedOption().getText();
	}

	protected boolean isDefaultDropdownMultiple(WebDriver driver, WebElement element) {
		return new Select(element).isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));

		for (WebElement item : speedDropdownItems) {
			if (item.getText().trim().equals(expectedItem)) {

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	protected String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	protected String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
		return getWebElement(driver, locator).getCssValue(cssPropertyName);
	}

	protected String convertRGBAToHexaColor(WebDriver driver, String locator, String cssPropertyName) {
		return Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
	}

	protected int getListElementSize(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}

	/**
	 * Apply for checkbox and radio button
	 * 
	 * @param driver
	 * @param locator
	 */
	protected void checkToElement(WebDriver driver, WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	/**
	 * Only apply for checkbox
	 * 
	 * @param driver
	 * @param locator
	 */
	protected void unCheckToElement(WebDriver driver, WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	protected boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}

	protected boolean isElementEnabled(WebDriver driver, WebElement element) {
		return element.isEnabled();
	}

	protected void switchToIframe(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void hoverToElement(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	protected void doubleClickToElement(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	protected void rightClickToElement(WebDriver driver, WebElement element) {
		new Actions(driver).contextClick(element).perform();
	}

	protected void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	protected void senKeyBoardToElement(WebDriver driver, WebElement element, Keys key) {
		new Actions(driver).sendKeys(element, key).perform();
	}

	protected Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	protected String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	protected boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	protected void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	protected void highlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	protected void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected void sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	protected void removeAttributeInDOM(WebDriver driver, WebElement element, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	protected String getElementValidationMessage(WebDriver driver, WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", element);
	}

	protected boolean isImageLoaded(WebDriver driver, WebElement element) {
		return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);

	}

	protected void waitForElementVisible(WebDriver driver, WebElement emailTextBox) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf((WebElement) emailTextBox));

	}

	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(element));

	}

	protected void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator)));

	}

	protected void waitForListElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));

	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));

	}

}


