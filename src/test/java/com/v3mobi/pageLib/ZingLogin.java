package com.v3mobi.pageLib;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.v3mobi.testbase.TestBase;


public class ZingLogin extends TestBase {
	
	public void webLogin(String name, String pass) throws Exception {
		WebElement  Username=getWebElement("zing.username");
		System.out.println(Username);
		Reporter.log("entering userName to the userName textbox");
		Username.sendKeys(name);
		WebElement  Password=getWebElement("zing.password");
		Reporter.log("entering userName to the userName textbox");
		Password.sendKeys(pass);
		

		
	}
}
