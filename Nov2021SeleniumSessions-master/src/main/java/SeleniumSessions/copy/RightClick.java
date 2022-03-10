package SeleniumSessions.copy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
	      
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
			WebElement rightClick = driver.findElement(By.xpath("//span[text()=\"right click me\"]"));
			
			Actions act = new Actions(driver);
			act.contextClick(rightClick).perform();
			//performs a context click at the middle of given element
			//First performs a mouse move to the location of the element.
			
			List<WebElement> options = 
					driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]"));
			
			for(WebElement e :  options) {
				String text = e.getText();
				System.out.println(text);
				if(text.equals("Copy")) {
					e.click();
					break;
				}
			}
			
		}		
}
   