package org.reqres;


import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.reqres.api.*;
import org.reqres.api.services.UserApiService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class RegresTest {

    private final UserApiService userApiService = new UserApiService();


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/";
    }

//    @Test
//    public void checkAvatarAndIdTest() {
//        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
//        List<UserData> users = given()
//                .when()
//                .get("org/reqres/api/users?page=2")
//                .then().log().all()
//                .extract().body().jsonPath().getList("data", UserData.class);
//
//        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));
//    }


    @Test
    public void testCanRegisterNewUser() {
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        UserPayload user = new UserPayload()
                .email("eve.holt@reqres.in")
                .password("pistol");

        userApiService.registerUser(user);


        RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));
    }

}
