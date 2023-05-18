package com.locoman.apitest.Models;

import java.util.Arrays;

public class Environments implements Cloneable {
    String environment;
    EnvironmentData[] environmentData;


    public Environments() {
        super();
    }

    public Environments(String environment, EnvironmentData[] environmentData) {
        this.environment = environment;
        this.environmentData = environmentData;
    }

    // Setter and Getters
    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }

    public EnvironmentData[] getEnvironmentData() { return environmentData; }
    public void setEnvironmentData(EnvironmentData[] environmentData) { this.environmentData = environmentData; }


    /**
     * Clone Object
     * @return clone of Metadata object
     */
    @Override
    public Object clone()  {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new Error("Something unexpected just happened");
        }
    } // end clone


    /**
     * To String override
     * @return Environments to string override
     */
    @Override
    public String toString() {
        return  this.environment + ", " +
                Arrays.toString(this.environmentData);
    }

} // end class
