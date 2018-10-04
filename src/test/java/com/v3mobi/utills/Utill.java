package com.v3mobi.utills;

import java.awt.Robot;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Utill {

	public static WebDriver driver;
	
	Actions act=new Actions(driver);
	
	
	
	public WebDriver selectBrowser(String browser) {
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			String browserPath = "D:\\Selenium\\Hybrid-Automation-master\\Hybrid-Automation-master\\src\\test\\java\\com\\v3mobi\\drivers\\geckodriver.exe";

			System.setProperty("webdriver.gecko.driver", browserPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			String chromePath = "D:\\Selenium\\Hybrid-Automation-master\\Hybrid-Automation-master\\src\\test\\java\\com\\v3mobi\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}

		return null;
	}

	public void impliciteWait(int timeInsec) {
		Reporter.log("waiting for page to load...");
		try {
			driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
			Reporter.log("Page is loaded");
		} catch (Throwable error) {
			Reporter.log("Timeout for Page Load Request to complete after " + timeInsec + " seconds");
			Assert.assertTrue(false, "Timeout for page load request after " + timeInsec + " second");
		}
	}

	public void seleteDropDownValue(WebElement element, String dropDownValue) {
		Select select = new Select(element);
		Reporter.log("selecting " + dropDownValue + " value in dropdown");
		select.selectByVisibleText(dropDownValue);

	}

	public void driverwait(int timeToWaitInSec) throws InterruptedException {
		Reporter.log("waiting for " + timeToWaitInSec + " seconds...");
		Thread.sleep(timeToWaitInSec * 1000);

	}

	public void expliciteWait(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void takeScreenshot(WebDriver webdriver, String fileWithPath, String methodName) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public void getAssertTestResult(String expectedResult, String actualResult) {
		Reporter.log("waiting for Assertion Result...");
		Assert.assertEquals(expectedResult, actualResult);
		Reporter.log(" Assertion Result...");

	}
	
	public void dragAndDropByPixel(WebElement webelement, int x, int y) {
		Reporter.log("Draging operation is perfoming...");
		act.dragAndDropBy(webelement,x, y).build().perform();
		Reporter.log("Draging operation is perfomed...");

	}
	public void dragAndDropByPosition(WebElement source, WebElement destination) {
		Reporter.log("Draging operation is perfoming...");
		act.dragAndDrop(source, destination).perform();
		Reporter.log("Draging operation is perfomed...");
		

	}
	public void moveToElementActionToPositon(WebElement source) {
		Reporter.log("Move Element operation is perfoming...");
		act.moveToElement(source).perform();
	}
	
	public void moveToElementActionByPositonPixel(WebElement webelement, int x, int y) {
		Reporter.log("Move Element operation is perfoming...");
		act.moveToElement(webelement, x, y).perform();
	}
	
	/*
	public void sendTestResultEmail() {
	
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		email.setSSLOnConnect(true);
		email.setFrom("user@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("foo@bar.com");
		email.send();
		
	}
	*/
	}
