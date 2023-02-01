package org.reqres.api;


import io.restassured.RestAssured;
import org.reqres.api.payloads.UserPayload;
import org.reqres.api.services.UserApiService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class RegresTest {

    private final UserApiService userApiService = new UserApiService();


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/";
    }


    @Test
    public void testCanRegisterNewUser() {
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";


        UserPayload user = new UserPayload()
                .email("eve.holt@reqres.in")
                .password("pistol");

        userApiService.registerUser(user)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));
    }

}
