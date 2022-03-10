package SeleniumSessions.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessConcept {
	
	
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Parag\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //automation steps:
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		co.addArguments("--incognito");
		//co.setHeadless(true);
		
		//Advantages
		//execution is fast
		//its blocking the browser(its not launching the browser)
		
		WebDriver driver = new ChromeDriver(co);// launch chrome
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
		//System.out.println(driver.getPageSource());
		
		if(driver.getPageSource().contains(" Copyright The Closure Library Authors")) {
			System.out.println("is present");
		}
		
		driver.quit();//close the browser

	}

	

}
