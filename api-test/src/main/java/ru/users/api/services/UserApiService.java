package ru.users.api.services;

import io.qameta.allure.Step;
import ru.users.api.assertions.AssertableResponse;
import ru.users.api.payloads.UserPayload;

public class UserApiService extends ApiService {

    @Step
    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("/tasks/rest/doregister"));
    }
}
