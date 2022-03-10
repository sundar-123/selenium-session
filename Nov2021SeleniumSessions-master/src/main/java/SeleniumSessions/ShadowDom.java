package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDom {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		//Browser--page--iframe--ShadowDom---input
		
		//driver.findElement(By.id("tea")).sendKeys("Masala tea");----this thing will not work bcz there is ShadowDom element
		
		driver.switchTo().frame("pact");
		//document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement tea = (WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		tea.sendKeys("masala tea");
	}

}
