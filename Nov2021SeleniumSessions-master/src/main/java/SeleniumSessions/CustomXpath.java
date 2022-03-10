package SeleniumSessions;

public class CustomXpath {

	public static void main(String[] args) {
		//htmltag[@attr='value']
		//input[@id='input-email']

		//htmltag[@attr1='value' and @attr2='value'] for multiple attributes
		//input[@id='input-email' and @name='email']
		//input[@id='input-email' or @name='email']
		//input[@type='submit' and @value='Login']
		
		//*[@attr='value']
		//*[@id='input-email']--- this is an attribute
		
		//(//input[@class='form-control'])[1]  -- index based x path
		
		//(//input[@class='form-control'])[position()=4]---position based index x path
		//(//input[@class='form-control'])[last()]-- to get the last element
		
		//last column - last element- last value in amazon.com footer link
		// ((//div[@class='navFooterVerticalRow navAccessibility']//ul)[last()]//a)[last()]
		
		//text(): it is a function
		//htmltag[text()='value']
		// //a[text()='Blog'] -- will directed to respective value on page(amazon.com)
		// //label[text()='First Name']--directed to First name on register page(opencart.com)
		// //h1[text()='Register Account']-- directed to Register Account Header
		
		//combination of @attr and text():
		//htmltag[@attr='value' and text()='value']
		// //a[@href and text()='login page']
		// //label[@for='input-firstname' and text()='First Name']
		// //label[text()='First Name' and @for='input-firstname']---reverse order
		
		//contains() with attribute function :
		//htmltag[contains(@attr,'value')]
		// //input[contains(@id,'firstname')]
		
		//input-first name
		//123-first name
		//456-first name  --- dynamic id
		// //input[contains(@id,'-firstname')]
		
		//contains() with attr1 and attr2 with no contains() : 
		//input[contains(@id,'firstname') and @name='firstname']--- comma is more important
		//input[contains(@id,'firstname') and contains(@name,firstname)]
		
		//contains() with text():
		//h2[contains(text(),'Accessories')]
		//p[contains(text(),'SaaS solutions')]
		//a[contains(text(),'Fresh')]
		
		//starts-with(): function
		//a[starts-with(text(),'Fresh')]
		//*[starts-with(text(),'Fresh')]
		
		//Parent to child
		//form[@id='Form_submitForm']//input --15 (direct + indirect child elements)
		//form[@id='Form_submitForm']/input  -- 0 (direct child elements)
		//div[@class='private-form__input-wrapper']//input[@id='username']
		
		//div[@class='private-form__input-wrapper']/child::input[@id='username']
		//select[@class='dropdown countries fleft']/option
		//select[@class='dropdown countries fleft']/child::option
		//select[@class='dropdown countries fleft']/*
		
		//Child to parent
		//option[@value='Afghanistan']/..
		//option[@value='Afghanistan']/parent::select
		//option[@value='Afghanistan']/ancestor::form[@id='Form_submitForm']
		// (//option[@value='Afghanistan']/ancestor::div)[last()]
		
		
	}

}
