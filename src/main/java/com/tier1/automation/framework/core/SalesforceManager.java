package com.tier1.automation.framework.core;

import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;

public class SalesforceManager {

	ControlManager controlManager;
	
	public SalesforceManager(ControlManager controlManager) {
		this.controlManager = controlManager;
	}
	
    public void login(String applicationConfig, String elementLocator) throws IOException {
    	DocumentContext appReader = JsonPath.using(Configuration.defaultConfiguration()).parse(applicationConfig);
    	DocumentContext elementReader = JsonPath.using(Configuration.defaultConfiguration()).parse(elementLocator);
    	controlManager.loadUrl(appReader.read("$.URL"));
    	controlManager.sendKeys((appReader.read("$.Elements.Salesforce.Login.userName.xPath")), elementReader.read("$.Username"),LocatorType.XPATH);
    }

    public void activateLightening()
    {
    	if(controlManager.showCurrentURL().contains("lightning"))
        {
           //Already in lightning mode
        }
        else
        {
            controlManager.clickElement("switch-to-lightning", LocatorType.CLASSNAME);

            // Switch to lightning mode
        }

    }
}