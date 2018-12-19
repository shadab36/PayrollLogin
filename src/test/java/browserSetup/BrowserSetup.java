package browserSetup;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import webApp.CommonData;
public class BrowserSetup{
	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static String browserName;
	public static Logger log;
	public static WebElement webelement;
	public static String local_chromebrowser;
	public static String local_chrome;
@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader("F:\\ECOM_DemoTest\\Demo\\src\\main\\resources\\Configure.properties"));
		AppURL = property.getProperty("App_url");
		local_chromebrowser = property.getProperty("local_chrome_browser");
		local_chrome = property.getProperty("local_chrome");
	
		// on source lab setup
		AppURL = property.getProperty("App_url");
		System.out.println("Bname=====" + AppURL);

		// if (browser.equalsIgnoreCase("chrome"))

		if ((local_chrome.equals("yes"))) {
			local_chromebrowser = System.setProperty(CommonData.Chrome_Name, CommonData.Chrome_Path);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			Thread.sleep(500);
			// if (browser.equalsIgnoreCase("firefox"))
		}
		else {
			
	System.out.println("platform does not provide");
		
			
			
		}
	
	}

	@AfterClass
	public static void after_Class() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}


}

