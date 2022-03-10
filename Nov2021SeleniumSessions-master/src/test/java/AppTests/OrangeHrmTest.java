package AppTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHrmTest extends BaseTest {
	
	@Test(priority=1)
	public void logoTest() {
	
		Assert.assertTrue(driver.findElement(By.className("nav-logo")).isDisplayed());
	}
	
	@Test(priority=2)
	public void contactSalesLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("CONTACT SALES")).isDisplayed());
	}
	
	@Test(priority=4)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page Title:" + title);
		Assert.assertEquals(title, "Sign Up for a Free HR Software Trial | OrangeHRM");
	}
	
	@Test(priority=3)
	public void headerTest() {
		String header = driver.findElement(By.cssSelector("div.try-it-text h1")).getText();
		Assert.assertTrue(header.contains("free trial"));
	}
	
	
	/**
	 * page Title:Sign Up for a Free HR Software Trial | OrangeHRM
PASSED: logoTest
PASSED: contactSalesLinkTest
PASSED: headerTest
PASSED: pageTitleTest

===============================================
    Default test
    Tests run: 4, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 4, Failures: 0, Skips: 0
===============================================
	 * 
	 */

}
