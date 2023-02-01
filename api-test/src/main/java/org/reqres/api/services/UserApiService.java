package org.reqres.api.services;

import org.reqres.api.assertions.AssertableResponse;
import org.reqres.api.payloads.UserPayload;

public class UserApiService extends ApiService {


    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("api/register"));
    }
}
