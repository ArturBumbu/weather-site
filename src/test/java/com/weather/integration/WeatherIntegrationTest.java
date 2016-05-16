package com.weather.integration;

import com.jayway.restassured.RestAssured;
import com.weather.WeatherSiteApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by arthur on 15/05/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WeatherSiteApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class WeatherIntegrationTest {
    @Value("${local.server.port}")
    private int serverPort;


    @Before
    public void setUp() {
        RestAssured.port = serverPort;
    }

    @Test
    public void shouldGet200() {
        when().get("/weather/London").then().statusCode(HttpStatus.OK.value())
                .and()
                .body("cityName", equalTo("London"));
    }
}
