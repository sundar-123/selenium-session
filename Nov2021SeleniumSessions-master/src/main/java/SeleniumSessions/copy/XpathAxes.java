package SeleniumSessions.copy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	 static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/india-in-south-africa-2021-22-1277060/south-africa-vs-india-2nd-odi-1277083/full-scorecard");
		System.out.println(getWicketTakerName("Rishabh Pant"));
		System.out.println(getWicketTakerName("Virat Kohli"));
		
		System.out.println(getPlayerScoreCard("Shikhar Dhawan"));
		System.out.println(getPlayerScoreCard("Virat Kohli"));

	}
	public static List<String> getPlayerScoreCard(String playerName) {
		
		List<String> actScoreList = new ArrayList();
		List<WebElement> scoreList = driver.findElements(By.xpath("//a[text()='"+playerName+"']/parent::td/following-sibling::td"));
		System.out.println(scoreList.size());
//		for(WebElement e : scoreList) {
//			String text = e.getText();  ... It will give you the wicket taker name with scoreCard
//			actScoreList.add(text);
		for(int i=1;i<scoreList.size();i++) {
		    String text = scoreList.get(i).getText();
		    actScoreList.add(text);
		}
		return actScoreList;
		
	}
	public static String getWicketTakerName(String playerName) {
		WebElement batsMan = driver.findElement(By.xpath("//a[text()='"+playerName+"']/parent::td/following-sibling::td/span"));
		return batsMan.getText();
	}

}
