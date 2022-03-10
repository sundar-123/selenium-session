package SeleniumSessions.copy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
      
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		
		By choices = By.xpath("//span[@class=\"comboTreeItemTitle\"]");
		//testcase 1(tc_1):single selection
		  //selectChoice(choices, "choice 1");
		
		//tc_2:multi selection
		selectChoice(choices, "choice 1","choice 2","choice 8");//Assignment to handle wrong choice in multi choice
		  
		//tc_3 : all choices selection
		//selectChoice(choices,"all");
	}
	public static void selectChoice(By locator,String... value) {
		List<WebElement>choicesList = driver.findElements(locator);
		boolean flag = true;
		if(!value[0].equalsIgnoreCase("all")) {
			
			for(WebElement e : choicesList) {
				 String text = e.getText();
				 //System.out.println(text);
				 
				 for(int i=0;i<value.length; i++) {
					 if(text.equals(value [i])){
						 flag = true;
						 e.click();
						 break;
					 }
				 }
		       }
	       }
		else {
			//for all selection
			try {
			for(WebElement e : choicesList) {
				flag = true;
				e.click();
			}
			}
			catch(ElementNotInteractableException e) {
				System.out.println("all choices are over");
			}
			
		}
		if(flag==false) {
			System.out.println("choice is not available" + value[0]);
		}
   }
}
