package ru.users.ui.tests;

import com.github.javafaker.Faker;
import ru.users.api.conditions.Conditions;
import ru.users.api.payloads.UserPayload;
import ru.users.api.services.UserApiService;
import ru.users.ui.MainPage;
import org.testng.annotations.Test;

import static ru.users.api.conditions.Conditions.*;

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
