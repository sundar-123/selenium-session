package mytests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	
	@BeforeSuite
	public void createUser() {
		System.out.println("BS--create user");
	}
	
	@BeforeTest
	public void connectWithDB() {
		System.out.println("BT--connect with DB");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC--launch Browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("BM--login to app");
	}
	@Test
	public void homePageTest() {
		System.out.println("homePageTest");
	}
	
	@Test
	public void searchTest() {
		System.out.println("searchTest");
	}
	@Test
	public void priceTest() {
		System.out.println("priceTest");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AM--logout");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC--close Browser");
	}
	@AfterTest
	public void disconnectWithDB() {
		System.out.println("AT--disconnect with DB");
	}
	@AfterSuite
	public void deleteUser() {
		System.out.println("AS-- deleteUser");
	}
	
	/*
	 * [RemoteTestNG] detected TestNG version 6.14.3
       BS--create user
       BT--connect with DB
       BC--launch Browser
                        BM--login to app
                        homePageTest
                        AM--logout
                        
                        BM--login to app
                        priceTest
                        AM--logout
                        
                        BM--login to app
                        searchTest
                        AM--logout
       AC--close Browser
       AT--disconnect with DB
       PASSED: homePageTest
       PASSED: priceTest
       PASSED: searchTest

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================

       AS-- deleteUser

===============================================
Default suite
Total tests run: 3, Failures: 0, Skips: 0
===============================================

	 * 
	 */
	
	

}
