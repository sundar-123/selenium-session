package SeleniumSessions.copy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOptions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
        //html tag of dropdown - select

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
		if(getDropDownOptionsList(country).contains("India")) {
			System.out.println("India is present in drop down ");
		}
		selectValueFromDropDown(country, "India");
		
		
   }
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String>optionsTextlist = new ArrayList<String>();
		System.out.println(optionsList.size());//get the size of dropdown menu
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			optionsTextlist.add(text);
		}
		return optionsTextlist;
	  }
	public static void selectValueFromDropDown(By locator,String value) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionsList = select.getOptions();
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;}
		}
	}
}
