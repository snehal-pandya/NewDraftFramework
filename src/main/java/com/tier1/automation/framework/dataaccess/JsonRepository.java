package com.tier1.automation.framework.dataaccess;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class JsonRepository implements IDataRepository {

    String ApplicationConfigFilePath;
    String ElementLocatorFilePath;
    String DriverPropertiesFilePath;
    JSONObject jsonReader;
    JSONParser parser;
    
    @Override
    public void dataReader() throws IOException, ParseException {
        parser = new JSONParser();
        try
        {
        	Path path = FileSystems.getDefault().getPath("AppConfig.json").toAbsolutePath();
            FileReader file = new FileReader(path.toString());
           // Object obj = parser.parse(file);
            jsonReader = (JSONObject)parser.parse(file);
            ApplicationConfigFilePath = (String) jsonReader.get("ApplicationConfigFilePath");
            ElementLocatorFilePath = (String) jsonReader.get("ElementLocatorFilePath");

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    
    public JSONObject applicationConfigReader() throws IOException, ParseException {
        dataReader();
        try
        {
            FileReader applicationConfigFile =new FileReader(ApplicationConfigFilePath);
            jsonReader = (JSONObject)parser.parse(applicationConfigFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonReader;
    }
    

    public JSONObject elementLocatorFileReader() throws IOException, ParseException {
        dataReader();
        try
        {
            FileReader elementLocatorFile =new FileReader(ElementLocatorFilePath);
            jsonReader = (JSONObject)parser.parse(elementLocatorFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonReader;
    }


	@Override
	public void cacheManager() {
		// TODO Auto-generated method stub
		
	}

}
