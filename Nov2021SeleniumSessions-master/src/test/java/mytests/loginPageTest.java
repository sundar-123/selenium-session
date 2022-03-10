package mytests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginPageTest {
	
	@DataProvider
	public Object [][] loginTestData() {
		return new Object[] [] {
			{"admin@gmail.com","admin123"},
			{"cust@gmail.com","cust123"},
			{"vendor@gmail.com","vendor123"},
			{"vendor@gmail.com","#@#@#@"},
			{"#@#@#@","vendor123"},
			{" "," "},
			{null,null},
		
		};
	}
	
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String username,String password) {
		Assert.assertTrue(doLogin(username,password));
	}
	public boolean doLogin(String userName,String password) {
		System.out.println("username :" + userName);
		System.out.println("password :" + password);
		System.out.println("login successful");
		return true;
	}
	

}
