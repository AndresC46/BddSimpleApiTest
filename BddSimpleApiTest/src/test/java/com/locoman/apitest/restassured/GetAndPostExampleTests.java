package com.locoman.apitest.restassured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class GetAndPostExampleTests {
    String baseUri = "https://reqres.in/api";
    String addUser = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

    Logger logger;

    @BeforeSuite
    public void setUpTest(){
        logger = LoggerFactory.getLogger("TEST_NGLogger");
    }

    @Test
    public void restAssuredGetReqResIO(){


        given().get(baseUri + "/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Rachel"));
    }

    @Test
    public void restAssuredPostReqResIO(){
//        Map<String, String> map = new Hashtable<String, String>();
//        map.put("name", "Bozo");
//        map.put("job", "Clown");

        JSONObject request = new JSONObject();
        request.put("name", "Bozo");
        request.put("job", "Clown");
        logger.info("JSON Request: "+ request.toString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().post(baseUri + "/users").
                then().statusCode(201)
                .log().all();
//                .body("data[4].first_name", equalTo("George"))
//                .body("data.first_name", hasItems("George", "Rachel"));
    }

}
