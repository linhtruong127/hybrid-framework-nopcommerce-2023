package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import pageUIs.admin.AdminSideBarPageUI;

public class AdminSideBarPageObject extends BaseElement {
	WebDriver driver;

	public AdminSideBarPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void openDynamicSidebarMenuPage(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AdminSideBarPageUI.DYNAMIC_MENU_PAGE, pageName);
		clickToElement(driver, AdminSideBarPageUI.DYNAMIC_MENU_PAGE, pageName);
		
	}
	public void openDynamicSidebarSubMenuPage(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AdminSideBarPageUI.DYNAMIC_SUBMENU_PAGE, pageName);
		clickToElement(driver, AdminSideBarPageUI.DYNAMIC_SUBMENU_PAGE, pageName);

	}
}
