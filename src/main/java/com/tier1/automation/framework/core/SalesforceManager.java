package com.tier1.automation.framework.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SalesforceManager {

	ControlManager controlManager;
	
	public SalesforceManager(ControlManager controlManager) {
		this.controlManager = controlManager;
	}
	
    public void login(JSONObject applicationConfig, JSONObject elementLocator) throws IOException, ParseException {
    	controlManager.loadUrl((String)applicationConfig.get("URL"));
    	controlManager.sendKeys((String)elementLocator.get("UserName"), (String)applicationConfig.get("Username"));
    }

    public void switchToLightening()
    {

    }
}