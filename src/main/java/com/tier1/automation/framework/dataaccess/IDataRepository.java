package com.tier1.automation.framework.dataaccess;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface IDataRepository {

    public void dataReader() throws IOException, ParseException;
    public void cacheManager();
}
