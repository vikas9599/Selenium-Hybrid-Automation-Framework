package com.v3mobi.testScripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.v3mobi.pageLib.ZingLogin;
import com.v3mobi.testbase.TestBase;
import com.v3mobi.utills.Utill;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

/*
This class is for Data driven framework example*/

public class FirstTest extends TestBase {

	String screenShotPath = "";
	Utill util = new Utill();

	@DataProvider
	public Object[][] Data() throws IOException {
		return getData("Registeration.xlsx", "Regx");
	}

	
	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	
	@Test(dataProvider = "Data")
	public void zingLogin(String TestName, String userName, String password, String runMode) throws Exception {
		
		Logger logger = Logger.getLogger("FirstTest");
		PropertyConfigurator.configure("Log4j.propertires");

		if (runMode.equals("N")) {
			throw new SkipException("Skipped Test case is");
		}
		Reporter.log("waiting for page to load...");
		ZingLogin login = new ZingLogin();
		logger.info("Inserting username and Password");
		Reporter.log("waiting for page to load...");
		login.webLogin(userName, password);

		Reporter.log("Testing With valid Credential ");
		util.driverwait(30);
		util.takeScreenshot(driver, screenShotPath, screenShotPath);
		
	}

	
	@AfterClass
	public void quiteBrowser() throws Exception {
		util.driverwait(30);
		util.takeScreenshot(driver, screenShotPath, screenShotPath);
		System.out.println("Screenshot Captured");
		closeBrowser();
	}
}
