package SeleniumSessions.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplay {
	static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		
//		if(driver.findElement(emailId).isDisplayed()) {
//			driver.findElement(emailId).sendKeys("tech812@gmail.com");
//		}
		if(doIsDisplayed(emailId)) {
			doSendKeys(emailId, "tech812@gmail.com");
		}
		
		driver.findElement(emailId).isEnabled();
		//visible - but disabled - false

	}
	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
