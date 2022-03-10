package SeleniumSessions.copy;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlerts {
	            static WebDriver driver;
		public static void main(String[] args) {
			//alert - JS alert pop-up//also called modal pop up
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			
			driver.findElement(By.name("proceed")).click();
			
			//driver.switchTo().alert();//NoAlertPresentException
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println(alert.getText());
			alert.accept();
	}
		public static Alert waitForAlerts(int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.alertIsPresent());
			
		}
		public static String getAlertText(int timeOut) {
			return waitForAlerts(timeOut).getText();
		}
		public static void acceptAlert(int timeOut) {
			waitForAlerts(timeOut).accept();
		}
		public static void dismissAlert(int timeOut) {
			waitForAlerts(timeOut).dismiss();
		}
 
		
}
