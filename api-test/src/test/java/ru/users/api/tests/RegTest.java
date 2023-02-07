package ru.users.api.tests;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import ru.users.api.ProjectConfig;
import ru.users.api.payloads.UserPayload;
import ru.users.api.services.UserApiService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.users.api.conditions.Conditions;

import java.util.Locale;

import static org.hamcrest.Matchers.*;

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
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("avatar", not(isEmptyOrNullString())));

    }


}
