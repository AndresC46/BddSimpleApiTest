package com.locoman.apitest.Models;

public class EnvironmentData implements Cloneable {
    String key;
    String value;

    public EnvironmentData() {
        super();
    }

    public EnvironmentData(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // Setters and Getters
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }


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
     * @return Environmental Data to string override
     */
    @Override
    public String toString() {
        return  this.key + ", " +
                this.value;
    }

} // end class
