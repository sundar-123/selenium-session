package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);//frame by index
		//driver.switchTo().frame("main");//frame by name
		
		driver.switchTo().frame(driver.findElement(By.name("main")));//by WebElement
		
	    String header = driver.findElement(By.xpath("/html/body/h2")).getText();
	    System.out.println(header);//no such element: Unable to locate element
	    
	    driver.switchTo().defaultContent();
	    driver.switchTo().parentFrame();//selenium 4.0 added
	}

}
