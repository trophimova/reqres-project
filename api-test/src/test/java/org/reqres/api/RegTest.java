package org.reqres.api;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.reqres.api.payloads.UserPayload;
import org.reqres.api.services.UserApiService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.hamcrest.Matchers.*;
import static org.reqres.api.conditions.Conditions.*;

public class RegTest {

    private final UserApiService userApiService = new UserApiService();
    private Faker faker;


    @BeforeClass
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        faker = new Faker(new Locale(config.locale()));
        RestAssured.baseURI = config.baseUrl();
    }


    @Test
    public void testCanRegisterNewUser() {
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        UserPayload user = new UserPayload()
                .email("eve.holt@reqres.in")
                .password("pistol");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(isEmptyOrNullString())));

    }

    @Test
    public void testCanRegisterNewUserUsingFaker() {
        UserPayload user = new UserPayload()
                .email(faker.internet().emailAddress())
                .password("pistol");

        userApiService.registerUser(user)
                .shouldHave(statusCode(400));

    }

    @Test
    public void testCanNotRegisterNewUser() {
        UserPayload user = new UserPayload()
                .email("")
                .password("pistol");

        userApiService.registerUser(user)
                .shouldHave(statusCode(400));

    }

}
