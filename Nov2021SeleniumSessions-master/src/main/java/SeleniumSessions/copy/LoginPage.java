package SeleniumSessions.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void main(String[] args) {


		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/login");
		
		System.out.println(br.getPageTitle());
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil el = new ElementUtil(driver);
		el.doSendKeys(emailId, "tech812@gmail.com");
		el.doSendKeys(password, "test@123");
		
		br.closeBrowser();
		
	}

}
