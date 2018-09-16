package com.v3mobi.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.v3mobi.excelReader.Xls_Reader;
import com.v3mobi.utills.Utill;

public class TestBase extends Utill {

	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public Xls_Reader Data;

	public void init() throws IOException {
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		impliciteWait(30);
		driver.get(Repository.getProperty("url"));

	}

	public void loadPropertiesFile() throws IOException {

		String global_path = "D:\\Selenium\\Hybrid-Automation-master\\Hybrid-Automation-master\\src\\test\\java\\com\\v3mobi\\config\\config.properties";
		String loginpage_path = "D:\\Selenium\\Hybrid-Automation-master\\Hybrid-Automation-master\\src\\test\\java\\com\\v3mobi\\pageLocators\\loginpage.properties";
		String report_path = "D:\\Selenium\\Hybrid-Automation-master\\Hybrid-Automation-master\\src\\test\\java\\com\\v3mobi\\pageLocators\\loginpage.properties";

		f = new File(global_path);
		FI = new FileInputStream(f);
		Repository.load(FI);

		f = new File(loginpage_path);
		FI = new FileInputStream(f);
		Repository.load(FI);

		f = new File(report_path);
		FI = new FileInputStream(f);
		Repository.load(FI);
	}

	public static WebElement getLocator(String locator) throws Exception {
		String[] split = locator.split(":");
		// System.out.println("Get Locator length"+split.length);
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.tagName(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public WebElement getWebElement(String locator) throws Exception {
		return getLocator(Repository.getProperty(locator));
	}

	public void closeBrowser() {
		driver.quit();
	}

	public Object[][] getData(String ExcelName, String testcase) {
		String excel_Path = "D:\\Selenium\\Hybrid-Automation-master\\Hybrid-Automation-master\\src\\test\\java\\com\\v3mobi\\testData\\"
				+ ExcelName;
		Data = new Xls_Reader(excel_Path);
		int rowNum = Data.getRowCount(testcase);
		System.out.println(rowNum);
		int colNum = Data.getColumnCount(testcase);
		Object sampleData[][] = new Object[rowNum - 1][colNum];
		for (int i = 2; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				sampleData[i - 2][j] = Data.getCellData(testcase, j, i);
			}
		}
		return sampleData;
	}
}
