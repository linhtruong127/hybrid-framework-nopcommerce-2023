package commons;

import java.io.File;

public class GlobalConstants {
	public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
	public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
	public static final String ADMIN_USERNAME = "admin@yourstore.com";
	public static final String ADMIN_PASSWORD = "admin";
	public static final String ADMIN_ORANGEHRM_USERNAME = "linht";
	public static final String ADMIN_ORANGEHRM_PASSWORD = "Dotoi@12785";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_PATH = PROJECT_PATH + File.separator + "uploadFiles"+ File.separator;
	public static final String DOWNLOAD_PATH = PROJECT_PATH + File.separator + "downloadFiles"+ File.separator;
	public static final int RETRY_NUMBER = 2;
	public static final String REPORTNG_IMAGE_PATH = PROJECT_PATH + File.separator + "reportNGImage"+ File.separator;
	public static final String RESOURCE_PATH = PROJECT_PATH + File.separator + "resources"+ File.separator;
	public static final String DATA_TEST_PATH = PROJECT_PATH + File.separator + "dataTest"+ File.separator;
	public static final String 	ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + File.separator + "environmentConfig"+ File.separator;
}
