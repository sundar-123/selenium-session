package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	static WebDriver driver;

	public static void main(String[] args) {
	
		//locator types
		//1.ID - unique
		//2.Name - can be duplicate
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
       // driver.findElement(By.name("email")).sendKeys("tech812@gmail.com");
		
	   //3.class name - can be duplicate
		//driver.findElement(By.className("form-control")).sendKeys("MAC");//you will get MAC entered in search tab of opencart
		//4. xpath - is not an attribute
		//it is the address of the element in HTML DOM
		//types: 
		//a.abs xpath
		//b.relative xpath
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("tech812@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test@123");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
//		By emailId = By.xpath("//*[@id=\"input-email\"]");
//		By pwd = By.xpath("//*[@id=\"input-password\"]");
//		By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		doSendKeys(emailId, "tech812@gmail.com");
//		doSendKeys(pwd, "test@123");
//		doClick(loginBtn);
		
		//5.css selector
		//css - cascaded Style Sheet
		
//		By emailId = By.cssSelector("#input-email");
//		By pwd = By.cssSelector("#input-password");
//		By loginBtn = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
//		
//		doSendKeys(emailId, "tech812@gmail.com");
//		doSendKeys(pwd, "test@123");
//		doClick(loginBtn);
		
		//6.linkText : only applicable for links with <a> tag
//		By linkTxt = By.linkText("Register");
//		doClick(linkTxt);
		
		//7.partialLinkText : only applicable for links with <a> tag
//		By parLinkTxt = By.partialLinkText("Forgotten");
//		doClick(parLinkTxt);
		//forgotten password
		//forgotten uername
		
		//8.tagName : Html tag
//		String header = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);
		
//		By register = By.linkText("Register");
//		By header = By.tagName("h2");
//		
//		System.out.println(doGetText(register));
//		System.out.println(doGetText(header));
//		
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
