package org.reqres.api.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.reqres.api.payloads.UserPayload;

public class UserApiService extends ApiService {


    public Response registerUser(UserPayload user) {
        return setUp()
                .body(user)
                .when()
                .post("api/register");
    }
}
