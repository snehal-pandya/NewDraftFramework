package com.tier1.automation.framework.dataaccess;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonRepository implements IDataRepository {

    String ElementLocatorFilePath;    
    @Override
    public String dataReader() throws IOException {
                
        String appConfigData = "";
    	try {
    			appConfigData = new String(Files.readAllBytes(Paths.get((FileSystems.getDefault().getPath("ApplicationConfig.json").toAbsolutePath()).toString())));
    			DocumentContext appConfigAccess = JsonPath.using(Configuration.defaultConfiguration()).parse(appConfigData);
    			ElementLocatorFilePath = appConfigAccess.read("$.ElementLocatorFilePath");
    	} 
    	catch (IOException e) {
    			e.printStackTrace();
    		}
    	return appConfigData;
    }
    
    /*public String applicationConfigReader() throws IOException {
        dataReader();
        String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get(ElementLocatorFilePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
    }*/
    
    public String elementLocatorFileReader() throws IOException {
    	dataReader();
    	String elementLocatorData = "";
		try {
			elementLocatorData = new String(Files.readAllBytes(Paths.get(ElementLocatorFilePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return elementLocatorData;
	}

	@Override
	public void cacheManager() {
		// TODO Auto-generated method stub
		
	}

}
