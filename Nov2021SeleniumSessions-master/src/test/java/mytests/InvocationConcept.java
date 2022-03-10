package mytests;

import org.testng.annotations.Test;

public class InvocationConcept {
	
	@Test(invocationCount = 10)
	public void getUserTest() {
		System.out.println("get user");
	}
	

}
