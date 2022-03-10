package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		// WAP

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.google.co.in/");
		driver.get("https://www.freshworks.com/");
		//By langs = By.xpath("//div[@id=\"SIvCob\"]/a");
		By footer = By.xpath("//ul[@class = \"footer-nav\"]//a");
		//clickOnLink(langs, "मराठी");
		clickOnLink(footer, "Careers");
	}

	public static void clickOnLink(By locator, String linkText) {
		List<WebElement> langList = driver.findElements(locator);
		System.out.println(langList.size());

		for (WebElement e : langList) {
			String text = e.getText();
			if (text.contains(linkText)) {
				e.click();
				break;}
		}
	}
}
