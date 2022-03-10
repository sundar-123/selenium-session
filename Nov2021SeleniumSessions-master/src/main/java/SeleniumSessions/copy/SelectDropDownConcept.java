package SeleniumSessions.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
        //html tag of dropdown - select

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
//		WebElement country_ele = driver.findElement(country);
//		WebElement state_ele = driver.findElement(state);
//		
//		Select select = new Select(country_ele);
//		select.selectByIndex(5);
//		select.selectByVisibleText("India");
//		//select.selectByValue("Argentina");
//		Thread.sleep(2000);
//		
//		Select select1 = new Select(state_ele);
//		select.selectByVisibleText("Karnataka");
		
//		doSelectDropDownValueByIndex(country, 5);
//		Thread.sleep(2000);
//		doSelectValueByIndex(state, 4);
		
		doSelectDropDownValueByVisibleText(country, "India");
		Thread.sleep(2000);
		doSelectDropDownValueByVisibleText(state, "Karnataka");
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownValueByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public static void doSelectDropDownValueByVisibleText(By locator,String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	public static void doSelectDropDownValueByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
}
