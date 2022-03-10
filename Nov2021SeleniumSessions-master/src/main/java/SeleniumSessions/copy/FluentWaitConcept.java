package SeleniumSessions.copy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email11");
		By password = By.id("input-password");

//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				               .withTimeout(Duration.ofSeconds(10))
//				               .pollingEvery(Duration.ofSeconds(2))
//				               .ignoring(NoSuchElementException.class)
//				               .ignoring(StaleElementReferenceException.class);
//		
//		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//		email_ele.sendKeys("test@gmail.com");
		waitForElementPresenceWithFluentWait(emailId, 10, 2).sendKeys("test@gmail.com");
		driver.findElement(password).sendKeys("test@123");

	}

	public static WebElement waitForElementPresenceWithFluentWait(By Locator, int timeOut, int poliingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(poliingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(Locator +"is not found within the given time...");
		return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	   
	}

	public static WebElement waitForElementPresenceWithWait(By Locator, int timeOut, int poliingTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(poliingTime))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.withMessage(Locator +"is not found within the given time...");
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
    }
}
