package com.tier1.automation.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ControlManager {
	private WebDriver webDriver;
	
	public ControlManager(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void loadUrl(String url) {
		webDriver.manage().window().maximize();
		webDriver.get(url);
    }
	
	public WebElement getElement(String xpath) {
		return webDriver.findElement(By.xpath(xpath));
	}
	
	public void sendKeys(String xpath, String value) {
		this.getElement(xpath).sendKeys(value);
	}
}
