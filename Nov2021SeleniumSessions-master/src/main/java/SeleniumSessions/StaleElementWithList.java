package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementWithList {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// DOM v1
		driver.get("https://www.freshworks.com/");
		
		List <WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));
		for(WebElement e : footerList) {
			e.click();
			Thread.sleep(1000);
			
			driver.navigate().back();
			
			Thread.sleep(1000);
			footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));
			
		}
		
	}

}
