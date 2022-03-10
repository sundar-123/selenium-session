package SeleniumSessions.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class WebDriverBasics {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parag\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //automation steps:
		WebDriver driver = new ChromeDriver();// launch chrome
		driver.get("https://www.google.com");//enter the url
		String title = driver.getTitle();//get the title of the page
		System.out.println("title is:" + title);
		
		//+
		//verification point/checkpoint/act v/s exp result
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		//=Automation Testing
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		
		if(driver.getPageSource().contains(" Copyright The Closure Library Authors")) {
			System.out.println("is present");
		}
		
		driver.quit();//close the browser

	}

}
