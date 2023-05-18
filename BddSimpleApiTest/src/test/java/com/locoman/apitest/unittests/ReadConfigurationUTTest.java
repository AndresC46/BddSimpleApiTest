package com.locoman.apitest.unittests;

import com.locoman.apitest.Drivers.ReadConfig;
import com.locoman.apitest.Models.ApiDataConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

class ReadConfigurationUTTest {
    ReadConfig readConfig;
    boolean debug = true;
    Logger logger = LoggerFactory.getLogger("TDD_UnitTest");

    @Test
    public void readConfigCreatesInstanceOfApiConfigObj(){
        readConfig = new ReadConfig(logger,"LOCAL");
        assertTrue(readConfig.getDataConfig() instanceof ApiDataConfig);
    }

    @Test
    public void readConfigVerifyForMultipleEnvironmentsRead(){
        readConfig = new ReadConfig(logger, "LOCAL");
        if(debug){logger.info("Number of Environments Read in: " + readConfig.getSize());}
        assertTrue(readConfig.getSize() > 0);
    }

    @Test
    public void readConfigForLocalEndpoint(){
        String expectedEndPoint = "https://localhost:5001/";

        readConfig = new ReadConfig(logger, "LOCAL");
        String endPoint = readConfig.getConfiguration("BaseUrl");

        if(debug){logger.info("LOCAL environment EndPoint Read in: " + endPoint);}
        assertEquals(expectedEndPoint, endPoint);
    }

}