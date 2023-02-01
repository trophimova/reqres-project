package org.reqres.api.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.reqres.api.payloads.UserPayload;

public class UserApiService {


    public Response registerUser(UserPayload user) {
        return RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("api/register");
    }
}
