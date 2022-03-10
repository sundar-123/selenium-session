package SeleniumSessions.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class LaunchEdge {

	public static void main(String[] args) {
		 WebDriver driver = new EdgeDriver();
		 driver.get("https://www.google.com");//enter the url
		 String title = driver.getTitle();//get the title of the page
	     System.out.println("title is:" + title);
	     
	     driver.quit();

	}

}
