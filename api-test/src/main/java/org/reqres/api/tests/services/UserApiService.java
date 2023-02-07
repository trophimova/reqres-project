package org.reqres.api.tests.services;

import io.qameta.allure.Step;
import org.reqres.api.tests.assertions.AssertableResponse;
import org.reqres.api.tests.payloads.UserPayload;

public class UserApiService extends ApiService {

    @Step
    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("/tasks/rest/doregister"));
    }
}
