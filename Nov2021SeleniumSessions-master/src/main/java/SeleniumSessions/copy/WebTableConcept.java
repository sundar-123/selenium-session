package SeleniumSessions.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept {
	static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		System.out.println(getCompName("Maria Anders"));
		System.out.println(getCountryName("Maria Anders"));
		
		System.out.println(getCompName("Francisco Chang"));
		System.out.println(getCountryName("Francisco Chang"));
		
		System.out.println("rows:" + getRowCount());
		System.out.println("columns:" + getColumnCount());
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
//		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
//		String AfterXpath = "]/td[1]";
//		for(int i=2;i<=getRowCount();i++) {
//			String xpath = beforeXpath+i+AfterXpath;
//			//System.out.println(xpath);
//			String text = driver.findElement(By.xpath(xpath)).getText();
//			System.out.println(text);
//		}
		//print the entire table
		String beforeXpath = "//table[@id=\"customers\"]/tbody/tr[";
		String AfterXpath = "]/td[";
		for(int col=1;col<=getColumnCount();col++) {
			for(int row=2;row<=getRowCount();row++) {
			String xpath = beforeXpath+row+AfterXpath+col+"]";
			//System.out.println(xpath);
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.print(text + " ");
			if(text.equals("Maria Anders")) {
				System.out.println("data is found");
				break;
			}
			}
			System.out.println();
		}
	}
	
	public static int getColumnCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr//th")).size();
	}
	public static int getRowCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
	}
	
	public static String getCompName(String name) {
		WebElement companyN = driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td"));
		return companyN.getText();
	}
	public static String getCountryName(String name) {
		WebElement countryN = driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td"));
		return countryN.getText();
	}

}
