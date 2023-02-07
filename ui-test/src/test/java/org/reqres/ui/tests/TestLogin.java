package org.reqres.ui.tests;

import com.github.javafaker.Faker;
import org.reqres.api.tests.conditions.Conditions;
import org.reqres.api.tests.payloads.UserPayload;
import org.reqres.api.tests.services.UserApiService;
import org.reqres.ui.MainPage;
import org.testng.annotations.Test;

import static org.reqres.api.tests.conditions.Conditions.*;

public class TestLogin extends BaseUITest {

    private final UserApiService userApiService = new UserApiService();
    private final Faker faker = new Faker();

    @Test
    public void userCanLoginWithValidCredentials() {
        UserPayload user = new UserPayload()
                .name(faker.name().username())
                .password(faker.internet().password())
                .email(faker.internet().emailAddress());

        userApiService.registerUser(user)
                .shouldHave(statusCode(200));


        MainPage.open()
                .loginAs(user.email(), user.password());

    }
}
