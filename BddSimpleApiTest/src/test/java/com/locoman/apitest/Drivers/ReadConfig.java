package com.locoman.apitest.Drivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.locoman.apitest.Models.*;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Driver for reading in Configuration Items by Environment
 */
public class ReadConfig {
    String environment;
    ApiDataConfig dataConfig;
    String apidata = "D:\\Development\\sandbox\\BddSimpleApiTest\\BddSimpleApiTest" +
            "\\src\\test\\java\\com\\locoman\\apitest\\Config\\API_DATA.json";

    /**
     * Read in JSON configuration file and convert to ApiDataConfig Object
     * @param environment specifies the test environment
     */
    public ReadConfig(Logger logger, String environment) {
        this.environment = environment;
        ObjectMapper mapper = new ObjectMapper();
        try {
            dataConfig = mapper.readValue(new File(apidata), ApiDataConfig.class);
        } catch (IOException e) {
            logger.error("Problem with reading configuration file: "+ e);
        }
    }

    // Setter and Getters
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public ApiDataConfig getDataConfig() {
        return dataConfig;
    }

    public void setDataConfig(ApiDataConfig dataConfig) {
        this.dataConfig = dataConfig;
    }

    public int getSize() {
        return dataConfig.getDataByEnvironment().length;
    }



    public String getConfiguration(String configValue) {

        String dataValue = "";

        Environments[] envs = dataConfig.getDataByEnvironment();
        for (Environments env : envs)
        {
            if(env.getEnvironment().equals(environment)){
                dataValue = readDataValue(env, configValue);
            }
        }

        return dataValue;
    }

    private String readDataValue(Environments env, String configValue) {
        EnvironmentData[] envData = env.getEnvironmentData();
        HashMap<String, String> dataHash = convertToHashMap(envData);
        return dataHash.get(configValue);
    }

    private HashMap<String, String> convertToHashMap(EnvironmentData[] envData) {
        HashMap<String, String> map = new HashMap <>();
        for (EnvironmentData env: envData){
            map.put(env.getKey(), env.getValue());
        }
        return map;
    }

}  // end class
