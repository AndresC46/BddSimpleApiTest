package com.locoman.apitest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

//import io.cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features"
        ,glue={"MyStepdefs"}
)
public class TestRunner
{

}
