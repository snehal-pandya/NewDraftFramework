package com.tier1.automation.framework.core;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;

public class ApplicationManager {

    private static final String BROWSERNAME = "$.BrowserName" ;
    private static final String CHROME_DISABLE_NOTIFICATIONS ="--disable-notifications";
    private static final String FIREFOX_DISABLE_NOTIFICATIONS ="dom.webnotifications.enabled";
    private static final String CHROME_DRIVER_KEY="webdriver.chrome.driver";
    private static final String FIREFOX_DRIVER_KEY="webdriver.gecko.driver";
    private static final String CHROME ="chrome";
    private static final String FIREFOX ="firefox";

    private ControlManager controlManager;
    private String applicationConfig;

    public void initialiseDriver(String applicationConfig) throws IOException {
    	WebDriver webDriver = null;
    	DocumentContext appConfigAccess = JsonPath.using(Configuration.defaultConfiguration()).parse(applicationConfig);
    	String browserName = appConfigAccess.read(BROWSERNAME);
        String driverPath = appConfigAccess.read(browserName);
        
        this.applicationConfig = applicationConfig;
        if(browserName.equalsIgnoreCase(CHROME))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(CHROME_DISABLE_NOTIFICATIONS);
            System.setProperty(CHROME_DRIVER_KEY, driverPath);
            webDriver = new ChromeDriver(options);
        }
        else if(browserName.equalsIgnoreCase(FIREFOX))
        {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference(FIREFOX_DISABLE_NOTIFICATIONS, false);
            System.setProperty(FIREFOX_DRIVER_KEY, driverPath);
            webDriver = new FirefoxDriver(options);
        }
        controlManager = new ControlManager(webDriver);
    }
    
    public void loadApplication(String elementLocator) throws IOException {
        SalesforceManager salesforceManager = new SalesforceManager(controlManager);
        salesforceManager.login(applicationConfig, elementLocator); 
        salesforceManager.activateLightening();
    }
    
    
}
