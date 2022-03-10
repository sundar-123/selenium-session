package SeleniumSessions.copy;

import org.openqa.selenium.By;

public class CssSelector {

	public static void main(String[] args) {
		//{id} --> #id , tag#id
		//class --> .class
		//e.g.-->#input-email
		//input#input-email
		//.form-control
		//input.form-control
		//input#input-email.form-control
		//input.form-control#input-email
		//.form-control#input-email
		By.cssSelector("#input-email");
		
		//tag[type='submit']
		//input[type='submit']
		By.cssSelector("input[type='submit']");
		//input[type='submit'][value='Login']
		
		//form-control private-form__control login-email
		//form-control private-form__control login-password m-bottom-3  ---- multiple classes are there
		//.c1.c2.c3...cn
		//.form-control.private-form__control.login-email
		//input.form-control.private-form__control.login-email
		//input.form-control.private-form__control.login-email#username
		
		By.cssSelector("input.form-control.private-form__control.login-email#username");
		By.className("form-control private-form__control login-email");//this one is wrong bcz it cannot multiple classes
		By.xpath("//input[@class='form-control private-form__control login-email']");
		By.className("login-email");
		

	}

}
