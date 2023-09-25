package commons;

import java.io.File;

public class GlobalConstants {
	public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
	public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
	public static final String ADMIN_USERNAME = "admin@yourstore.com";
	public static final String ADMIN_PASSWORD = "admin";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_PATH = PROJECT_PATH + File.separator + "uploadFiles"+ File.separator;
	public static final String DOWNLOAD_PATH = PROJECT_PATH + File.separator + "downloadFiles"+ File.separator;
	public static final int RETRY_NUMBER = 2;
	public static final String REPORTNG_IMAGE_PATH = PROJECT_PATH + File.separator + "reportNGImage"+ File.separator;
}
