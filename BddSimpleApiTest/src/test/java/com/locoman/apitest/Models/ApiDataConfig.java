package com.locoman.apitest.Models;

import java.util.Arrays;

public class ApiDataConfig implements Cloneable {

    Environments[] dataByEnvironment;

    public ApiDataConfig() { super(); }

    public ApiDataConfig(Environments[] getDataByEnvironment) { dataByEnvironment = getDataByEnvironment; }

    // Setter and Getters
    public Environments[] getDataByEnvironment() { return dataByEnvironment; }
    public Environments getEnvironment(int i) { return dataByEnvironment[i]; }

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
        return Arrays.toString(this.dataByEnvironment);
    }




}  // end class
