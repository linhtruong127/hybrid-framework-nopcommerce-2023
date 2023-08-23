package commons;

import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserName(String browserName) {

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			
			//Tự tải driver về
			//System.setProperty("webDriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			//driver = new FirefoxDriver();
			
			//WebDriver Manager
			//driver = WebDriverManager.firefoxdriver().create();
			
			//Selenium Manager
			driver = new FirefoxDriver();
			break;
		case CHROME:
			//System.setProperty("webDriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			
			//WebDriver Manager
			//driver = WebDriverManager.chromedriver().create();
			
			//Selenium Manager
			driver = new ChromeDriver();
			break;
		case EDGE:
			//System.setProperty("webDriver.msedge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			//driver = new ChromeDriver();
			
			//WebDriver Manager
			//driver = WebDriverManager.chromiumdriver().create();
			
			//Selenium Manager
			driver = new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Browser is invalid.");
		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;

	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "john" + rand.nextInt(999) + "@kennedy.us";
	}

	protected void closeBrowser() {
		if (driver == null) {
		} else {
			driver.quit();
		}
	}

}