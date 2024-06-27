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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.user.BaseElementUI;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();

	}

	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());

	}

	public void acceptToAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();

	}

	public void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();

	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();

	}

	public void sendkeyToAlert(WebDriver driver, String keyToSend) {
		waitForAlertPresence(driver).sendKeys(keyToSend);

	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Set<Cookie> getBrowserCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("xpath") || locatorType.startsWith("Xpath") || locatorType.startsWith("XPATH")) {
			by = By.xpath(locatorType.substring(6));

		} else if (locatorType.startsWith("css") || locatorType.startsWith("Css") || locatorType.startsWith("CSS")) {
			by = By.cssSelector(locatorType.substring(4));

		} else if (locatorType.startsWith("id") || locatorType.startsWith("Id") || locatorType.startsWith("ID")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("name") || locatorType.startsWith("Name") || locatorType.startsWith("NAME")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("class") || locatorType.startsWith("Class") || locatorType.startsWith("CLASS")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("tagname") || locatorType.startsWith("Tagname") || locatorType.startsWith("TAGNAME")) {
			by = By.tagName(locatorType.substring(8));

		} else {
			throw new RuntimeException("Locator is invalid");
		}
		return by;
	}

	public String getDynamicLocator(String locator, String... dynamicValues) {
		return String.format(locator, (Object[]) dynamicValues);

	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator, String... dynamicValues) {
		return driver.findElements(getByLocator(getDynamicLocator(locator, dynamicValues)));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... dynamicValues) {
		getWebElement(driver, getDynamicLocator(locator, dynamicValues)).click();
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}

	public String getElementText(WebDriver driver, String locator, String... dynamicValues) {
		return getWebElement(driver, getDynamicLocator(locator, dynamicValues)).getText();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {
		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(valueToSend);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend, String... dynamicValues) {
		getWebElement(driver, getDynamicLocator(locator, dynamicValues)).clear();
		getWebElement(driver, getDynamicLocator(locator, dynamicValues)).sendKeys(valueToSend);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
		new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue, String... dynamicValues) {
		new Select(getWebElement(driver, getDynamicLocator(locator, dynamicValues))).selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
	}

	public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(2);
		
		List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		
		for (WebElement item : speedDropdownItems) {
			if (item.getText().trim().equals(expectedItem)) {
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}
	public void selectItemOfCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(2);

		List<WebElement> allDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));

		for (WebElement item : allDropdownItems) {
			if (item.getText().trim().equals(expectedItem)) {
				System.out.println(expectedItem);
				
			}else {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(2);
				new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynamicLocator(locator, dynamicValues)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
		return getWebElement(driver, locator).getCssValue(cssPropertyName);
	}

	public String convertRGBAToHexaColor(WebDriver driver, String locator, String cssPropertyName) {
		return Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
	}

	public int getListElementSize(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}

	public int getListElementSize(WebDriver driver, String locator, String... dynamicValues) {
		return getListWebElement(driver, getDynamicLocator(locator, dynamicValues)).size();
	}

	/**
	 * Apply for checkbox and radio button
	 * 
	 * @param driver
	 * @param locator
	 */
	public void checkToElement(WebDriver driver, String locator) {
		if (!getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}

	public void checkToElement(WebDriver driver, String locator, String... dynamicValues) {
		if (!getWebElement(driver, getDynamicLocator(locator, dynamicValues)).isSelected()) {
			getWebElement(driver, getDynamicLocator(locator, dynamicValues)).click();
		}
	}

	/**
	 * Only apply for checkbox
	 * 
	 * @param driver
	 * @param locator
	 */
	public void unCheckToElement(WebDriver driver, String locator) {
		if (!getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}

	public void unCheckToElement(WebDriver driver, String locator, String... dynamicValues) {
		if (!getWebElement(driver, getDynamicLocator(locator, dynamicValues)).isSelected()) {
			getWebElement(driver, getDynamicLocator(locator, dynamicValues)).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}

	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
		setImplicitWait(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locator);
		setImplicitWait(driver, longTimeout);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void setImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... dynamicValues) {
		return getWebElement(driver, getDynamicLocator(locator, dynamicValues)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... dynamicValues) {
		return getWebElement(driver, getDynamicLocator(locator, dynamicValues)).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public void switchToIframe(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	public void senKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, dynamicValues)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}
	public void scrollToElement(WebDriver driver, String locator, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, getDynamicLocator(locator, dynamicValues)));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));

	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));

	}

	public void waitForElementVisible(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, dynamicValues))));

	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));

	}

	public void waitForElementInvisible(WebDriver driver, By element) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(element));

	}

	public void waitForElementInvisible(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(locator, dynamicValues))));

	}

	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator)));

	}

	public void waitForListElementVisible(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, getDynamicLocator(locator, dynamicValues))));

	}

	public void waitForListElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));

	}

	public void waitForListElementInvisible(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicLocator(locator, dynamicValues))));

	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver, locator)));

	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitForElementClickable(WebDriver driver, String locator, String... dynamicValues) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver, getDynamicLocator(locator, dynamicValues))));

	}

	public boolean isPageLoadedSucess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery !=null) && (jQuery.active === 0);");
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {

		String filePath = GlobalConstants.UPLOAD_PATH;

		String fullFileName = "";

		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}

		fullFileName = fullFileName.trim();
		getWebElement(driver, BaseElementUI.UPLOAD_BUTTON).sendKeys(fullFileName);

	}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
}
