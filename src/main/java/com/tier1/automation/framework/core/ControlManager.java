package com.tier1.automation.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ControlManager {
	private WebDriver webDriver;
	
	private WebElement getElement(String locator, LocatorType type) {
		switch (type){
		case ID :
			return webDriver.findElement(By.id(locator));
		case XPATH :
			return webDriver.findElement(By.xpath(locator));
		case CSS :
			return webDriver.findElement(By.cssSelector(locator));
			
		default:
			return null;
		
		}
		
	}
	
	public ControlManager(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void loadUrl(String url) {
		webDriver.manage().window().maximize();
		webDriver.get(url);
    }
	
	public void sendKeys(String locator, String value, LocatorType type) {
		this.getElement(locator,type).sendKeys(value);
	}
}
