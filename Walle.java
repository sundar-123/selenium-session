package map_01;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Walle {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)  {

//		WebDriverManager.chromedriver().setup();	
	System.setProperty("Webdriver.chrome.driver", "C:/Users/PAPA/Downloads/chromedriver_win32.exe");
	WebDriver driver = new ChromeDriver();
	
//	WebDriver driver=WebDriverManager.chromedriver().create();
//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(29,TimeUnit.SECONDS);
	

	
	
	driver.get("https://www.youtube.com/watch?v=kqQd6PlQtcs&ab_channel=NaveenAutomationLabs");
	driver.get("https://www.google.com/search?q=googl&rlz=1C1RXQR_enIN1035IN1035&oq=googl&aqs=chrome..69i57j35i39j46i131i199i433i465i512j0i131i433i512j69i65j69i60l2j69i65.2762j1j7&sourceid=chrome&ie=UTF-8");
	driver.manage().window().maximize();
	
//	String str=driver.getWindowHandle();
//	System.out.println(str);
//	
//	Set<String>handles=driver.getWindowHandles();
//	Iterator<String>it=handles.iterator();
//	
//	String parentid= it.next();
//	System.out.println(parentid);
	
//	driver.close();
	
	
	
	
	
		}
	}


