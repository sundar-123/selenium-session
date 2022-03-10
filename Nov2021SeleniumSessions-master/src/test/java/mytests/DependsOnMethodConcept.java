package mytests;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	
	@Test
	public void loginTest() {
		System.out.println("login to app");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homeTest() {
		System.out.println("home Test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("search Test");
	}
    // test should be independent..not to be dependent
	//try to avoid priority also
	//always define the assertion--act v/s expected result --Validation point/Checkpoint
	//CRUD
	
	//@Test t1
	//Create the user
	//assert the user id
	
	//@Test t2(depends = t1)
	//Update user :
	//1.Create the user
	//2.take the user id from new user(user id = 3)
	//3.pick the same user id to update the user
	//4.delete the user(id=3)
	//5.Check the user is deleted
	
	
}
