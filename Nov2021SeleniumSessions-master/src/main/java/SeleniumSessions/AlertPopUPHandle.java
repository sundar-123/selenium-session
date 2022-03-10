package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUPHandle {

	public static void main(String[] args) throws InterruptedException {
		//alert - JS alert pop-up//also called modal pop up
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		// alert pop up will come
		Thread.sleep(5000);//wait for 5 seconds
        Alert alert = driver.switchTo().alert(); //switch to alert
        String text = alert.getText();
        System.out.println(text);
        
        alert.accept(); //click on ok button
        //alert.dismiss(); //click on cancel
        alert.sendKeys("testing");
	}

}
