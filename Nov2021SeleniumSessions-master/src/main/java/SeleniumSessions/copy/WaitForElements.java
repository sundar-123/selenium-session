package SeleniumSessions.copy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElements {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		By footers = By.cssSelector("ul.footer-nav>li>a");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		List<WebElement> footerList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footers));
		List<WebElement> footerList = waitForElementsVisible(footers, 10);
		for (WebElement e : footerList) {
			System.out.println(e.getText());

		}
	}

	/**
	 * 
	 * 
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0
	 * 
	 * @param Locator
	 * @param timeout
	 * @return
	 */
	public static List<WebElement> waitForElementsVisible(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
	}
	public static List<WebElement> waitForElementsPresence(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locator));
	}
}
