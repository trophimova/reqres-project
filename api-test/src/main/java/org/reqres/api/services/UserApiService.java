package org.reqres.api.services;

import io.qameta.allure.Step;
import org.reqres.api.assertions.AssertableResponse;
import org.reqres.api.payloads.UserPayload;

public class UserApiService extends ApiService {

    @Step
    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("api/register"));
    }
}
