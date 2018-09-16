package com.v3mobi.pageLib;

import org.openqa.selenium.WebElement;

import com.v3mobi.testbase.TestBase;



public class Registeration extends TestBase {

	public void registerWithValidData(String name, String email, String password,String usertype,String check) throws Exception {
		WebElement register = getWebElement("zing.register");
		System.out.println("Register Item click"+register);
		register.click();		
		WebElement name1 = getWebElement("zing.name");
		name1.sendKeys(Repository.getProperty(name));
		System.out.println("Enter Name is " + name);
		WebElement email1 = getWebElement("zing.email");
		email1.sendKeys(Repository.getProperty(email));
		System.out.println("Enter Name is " + email);
		WebElement password1 = getWebElement("zing.password");
		password1.sendKeys(Repository.getProperty(password));
		System.out.println("Enter Name is " + password);		
		
		/*To check weather user type is CP or PUB*/
		
		if(usertype=="CP"){
		WebElement usertype1 = getWebElement("zing.usertype");
		usertype1.click();
		}
		else {
			WebElement usertype1 = getWebElement("zing.usertype");
			usertype1.click();
		}
		
		/*To check term and condition page is checked or not*/
		
		if(check=="CH") {
		WebElement check1 = getWebElement("zing.condition");
		check1.click();		
		}
		else {
			WebElement check1 = getWebElement("zing.condition");
			check1.click();		
		}
		

	}

}
