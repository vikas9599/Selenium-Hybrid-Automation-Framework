package com.v3mobi.testScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.v3mobi.testbase.TestBase;
import com.v3mobi.utills.Utill;

/*
This class is for keyword driven framework example*/

public class VideoTest extends TestBase {

	Utill util = new Utill();

	@DataProvider
	public Object[][] Data() throws IOException {
		return getData("VideoID.xlsx", "VideoID");
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	@Test(dataProvider = "Data")
	public void isVideoPlay(String TestName, String vID, String vPass, String runMode) throws Exception {
		WebElement videoID = getWebElement(vID);
		videoID.sendKeys("I am here");
		WebElement viPass = getWebElement(vPass);
		viPass.sendKeys("shbdhsa");

	}

}
