package mytests;

import org.testng.annotations.Test;

public class ExpectedExceptonConcept {

	
	@Test(expectedExceptions = {NullPointerException.class , ArithmeticException.class})
	public void searchTest() {
		System.out.println("search Test");
		int i = 9/0;
	}
}
