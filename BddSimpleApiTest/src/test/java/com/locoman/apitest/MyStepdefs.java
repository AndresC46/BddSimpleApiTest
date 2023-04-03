package com.locoman.apitest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsItFriday {
    static String isItFriday(String today) {
        return "Nope";
    }
}

public class MyStepdefs {
    private String today;
    private String actualAnswer;

    @Given("today is Sunday")
    public void todayIsSunday() {
        today = "Sunday";
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string} mvn test")
    public void iShouldBeToldMvnTest(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
