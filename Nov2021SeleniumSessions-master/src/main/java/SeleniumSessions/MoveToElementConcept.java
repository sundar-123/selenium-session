package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
        //move to element
		//parent to child
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how+to+create+menu+with+sub+menu&o=rec");
		WebElement contentParent = driver.findElement(By.className("menulink"));
		Actions act = new Actions(driver);
		act.moveToElement(contentParent).build().perform();//correct
		//act.moveToElement(contentParent).perform();//correct
		//act.moveToElement(contentParent).build().perform();//not correct
		Thread.sleep(4000);
		
		driver.findElement(By.linkText("COURSES")).click();//write in letter as displayed on page
	
		
	}
}
