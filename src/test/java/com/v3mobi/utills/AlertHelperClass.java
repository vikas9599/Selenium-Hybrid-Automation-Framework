package com.v3mobi.utills;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelperClass {

	private WebDriver driver;
	private Logger logger = Logger.getLogger(AlertHelperClass.class);

	public Alert getAlert() {
		logger.debug("");
		return driver.switchTo().alert();
	}

	public void AcceptAlert() {
		logger.info("");
		getAlert().accept();
	}

	public void DismissAlert() {
		// logger.info("");
		getAlert().dismiss();
	}

	public String getAlertText() {
		String text = getAlert().getText();
//		logger.info(text);
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			// logger.info("true");
			return true;
		} catch (NoAlertPresentException e) {
			// Ignore
			// logger.info("false");
			return false;
		}
	}

	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		AcceptAlert();
		// logger.info("");
	}

	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();
//		logger.info("");
	}

	public void AcceptPrompt(String text) {

		if (!isAlertPresent())
			return;

		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
		// logger.info(text);
	}

}
