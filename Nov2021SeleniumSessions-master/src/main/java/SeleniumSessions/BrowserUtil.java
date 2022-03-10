package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	private WebDriver driver;
	/**
	 * This method is used to initialize the driver on the basis of browsername
	 * @param browser
	 * @return this returns webdriver
	 */
	public WebDriver launchBrowser(String browser) {
		
		System.out.println("browser name is:"+ browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\Parag\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
		     driver = new ChromeDriver();
		}
		else if((browser.equalsIgnoreCase("firefox"))){
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\Parag\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
	    }
		else if(browser.equalsIgnoreCase("safari")) {
			 driver = new SafariDriver();
		}
		else { 
			System.out.println("please pass the right browser..." + browser);
		}
		return driver;
	}
	
	public void enterUrl(String url) {
		System.out.println("url is :" + url);
		
		if (url.contains("http") || url.contains("https")) {
			driver.get(url);
		}
		else {
			System.out.println("incorrect url...");
			try {
			throw new Exception("INCORRECT URL MISSING HTTP OR HTTPS");
			} catch(Exception e) {
				
			}
		}
		
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	public void quitBrowser() {
		driver.quit();
	}
	public void closeBrowser() {
		driver.close();
	}
}
