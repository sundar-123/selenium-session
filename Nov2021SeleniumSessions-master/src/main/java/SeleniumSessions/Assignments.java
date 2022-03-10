package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignments {
	static WebDriver driver;
	
		public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			driver.get("https://www.freshworks.com/");
			driver.get("https://www.google.co.in/");
			
//			By copyrFW = By.xpath("//div[@class=\"footer-copyrights\"]//a");
			//By copyrGoogle = By.xpath("//div[@class=\"KxwPGc AghGtd\"]/a");
			By copyrGoogle = By.xpath("//div[@class=\"o3j99 c93Gbe\"]//a");
//			clickOnLinks(copyrFW, "GDPR");
			//clickOnLinks(copyrGoogle,"About");
			clickOnLinks(copyrGoogle, "How Search works");
		}
		
	public static void clickOnLinks(By locator,String linkText) {
		List<WebElement> copyrights = driver.findElements(locator);
		System.out.println(copyrights.size());
		//System.out.println(copyrights);
		
		for(WebElement e : copyrights) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(linkText)) {
			e.click();
			break;
			}
		}
	}
	
	
}
