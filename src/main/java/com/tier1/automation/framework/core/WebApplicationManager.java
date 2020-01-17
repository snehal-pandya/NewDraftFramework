package com.tier1.automation.framework.core;

import com.tier1.automation.framework.dataaccess.JsonRepository;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class WebApplicationManager extends ApplicationManager  {

    //ApplicationName

    public void openApplication() throws IOException, ParseException {
        JsonRepository jsonDataRepository = new JsonRepository();
        JSONObject applicationConfig = jsonDataRepository.applicationConfigReader();
        JSONObject elementLocator = jsonDataRepository.elementLocatorFileReader();
    }

    public void closeApplication()
    {

    }
}
