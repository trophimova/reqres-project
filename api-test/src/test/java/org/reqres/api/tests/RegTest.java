package org.reqres.api.tests;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.reqres.api.tests.payloads.UserPayload;
import org.reqres.api.tests.services.UserApiService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.hamcrest.Matchers.*;
import static org.reqres.api.tests.conditions.Conditions.*;

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
        UserPayload user = new UserPayload()
                .name(faker.name().username())
                .password(faker.internet().password())
                .email(faker.internet().emailAddress());

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("avatar", not(isEmptyOrNullString())));

    }


}
