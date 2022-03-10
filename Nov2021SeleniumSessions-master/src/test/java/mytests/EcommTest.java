package mytests;

import org.testng.annotations.Test;

public class EcommTest {
	
	@Test(priority=1)
	public void loginTest() {
		System.out.println("loginTest");
	}
	
	@Test(priority=3)
	public void homeTest() {
		System.out.println("homeTest");
	}
	
	@Test(priority=2)
	public void cartTest() {
		System.out.println("cartTest");
	}
	
	@Test(priority=4)
	public void searchTest() {
		System.out.println("searchTest");
	}
	
	@Test()
	public void m1Test() {
		System.out.println("m1Test");
	}
	
	@Test()
	public void m2Test() {
		System.out.println("m2Test");
	}
	
	@Test()
	public void m3Test() {
		System.out.println("m3Test");
	}

}
    /*
     * [RemoteTestNG] detected TestNG version 6.14.3
        m1Test // preference will be given to non-priority based test cases & then to Priority based TCs in alphabetical order.
        m2Test
        m3Test
        loginTest
        cartTest
        homeTest
        searchTest
        PASSED: m1Test
        PASSED: m2Test
        PASSED: m3Test
        PASSED: loginTest
        PASSED: cartTest
        PASSED: homeTest
        PASSED: searchTest

===============================================
    Default test
    Tests run: 7, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 7, Failures: 0, Skips: 0
===============================================

     * 
     */

