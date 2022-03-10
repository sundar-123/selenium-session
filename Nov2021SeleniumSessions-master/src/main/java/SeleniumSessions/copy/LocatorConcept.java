package SeleniumSessions.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	 static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//Create a web element
		//Web element = by locator
		// create web element + action(Click,sendKeys,isDisplayed...)
		
		//1st type : ID locator
		
		// 1st approach
		//driver.findElement(By.id("input-email")).sendKeys("tech812@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("test@123");
		//it will give you the email id and password in opencart app login page
		
		//2nd approach
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		emailId.sendKeys("tech812@gmail.com");
//		password.sendKeys("test@123");
		
		//3rd approach using by locator
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailID = driver.findElement(emailId);
//		WebElement pwd = driver.findElement(password);
//		
//		emailID.sendKeys("tech812@gmail.com");
//		pwd.sendKeys("test@123");
		
		//4.by locator with generic method
		
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		getElement(emailId).sendKeys("tech812@gmail.com");
//		getElement(password).sendKeys("test@123");
		
		//5.by locator with getElement and actions generic method
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		dosendKeys(emailId,"tech812@gmail.com");
//		dosendKeys(password,"test@123");
		
		//6.by locator with getElement and actions generic method in util class
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtil eleutil = new ElementUtil(driver);
//		eleutil.dosendKeys(emailId, "tech812@gmail.com");
//		eleutil.dosendKeys(password, "test@123");
		
		//7.String locator with By,getElement and actions generic method in util class
		String eId = "input-email";
		String pwd = "input-password";
		
//		doSendKeys("id", eId, "tech812@gmail.com");
//		doSendKeys("id", pwd, "test@123");
		//8 aprroach
		// 
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.doSendKeys("id", eId, "tech812@gmail.com");
		eleutil.doSendKeys("id", pwd, "tech@123");
		
		
	}
	
	public static By getBy(String locatorType,String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			
			break;

		default:
			break;
		}
		return locator;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doSendKeys(String locatorType,String locatorValue,String value) {
		getElement(getBy(locatorType,locatorValue)).sendKeys(value);
	}
}
