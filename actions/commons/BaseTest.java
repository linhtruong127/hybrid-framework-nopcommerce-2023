package commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	private WebDriver driver;
	// private String projectPath = System.getProperty("user.dir");

	public WebDriver getDriver() {
		return driver;
	}

	protected final Logger log;

	protected BaseTest() {
		log = LogManager.getLogger(getClass());
	}

	protected WebDriver getBrowserName(String browserName) {

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:

			// Tự tải driver về
			// System.setProperty("webDriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			// driver = new FirefoxDriver();

			// WebDriver Manager
			// driver = WebDriverManager.firefoxdriver().create();

			// Selenium Manager
			driver = new FirefoxDriver();
			break;
		case CHROME:
			// System.setProperty("webDriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			// driver = new ChromeDriver();

			// WebDriver Manager
			// driver = WebDriverManager.chromedriver().create();

			// Selenium Manager
			driver = new ChromeDriver();
			break;
		case EDGE:
			// System.setProperty("webDriver.msedge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			// driver = new ChromeDriver();

			// WebDriver Manager
			// driver = WebDriverManager.chromiumdriver().create();

			// Selenium Manager
			driver = new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Browser is invalid.");
		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.get("https://demo.nopcommerce.com/");
		return driver;

	}

	protected WebDriver getBrowserDriver(String browserName, String url) {

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:

			driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = new ChromeDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Browser is invalid.");
		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.get(url);
		return driver;

	}

	protected WebDriver getBrowserEnvironment(String browserName, String serverName) {

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:

			driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = new ChromeDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Browser is invalid.");
		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.get(getUrlByServerName(serverName));
		return driver;

	}

	private String getUrlByServerName(String serverName) {
		ServerList server = ServerList.valueOf(serverName.toUpperCase());
		switch (server) {
		case DEV:
			serverName = "https://demo.nopcommerce.com/";
			break;
		case STAGING:
			serverName = "https://staging.nopcommerce.com/";
			break;
		case QAT:
			serverName = "https://qat.nopcommerce.com/";
			break;

		default:
			new IllegalArgumentException("Unexpected value:" + serverName);
		}
		return serverName;
	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "john" + rand.nextInt(9999) + "@kennedy.us";
	}

	public String getEmailRandom(String prefix) {
		Random rand = new Random();
		return prefix + rand.nextInt(9999) + "@kennedy.us";
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("..............PASSED..............");
		} catch (Throwable e) {
			log.info("..............FAILED..............");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("..............PASSED..............");
		} catch (Throwable e) {
			log.info("..............FAILED..............");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("..............PASSED..............");
		} catch (Throwable e) {
			log.info("..............FAILED..............");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	@BeforeSuite
	public void deleteFileInReport() {
		deleteAllFileInFolder("reportNGImage");
		deleteAllFileInFolder("allure-json");
	}

	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowser() {
		if (driver == null) {
		} else {
			driver.quit();
		}
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = GlobalConstants.OS_NAME.toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI 'IMAGENAME eq " + browserDriverName + "*'";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				@SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}