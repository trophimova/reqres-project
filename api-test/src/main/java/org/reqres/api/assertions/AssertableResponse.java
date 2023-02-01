package org.reqres.api.assertions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.reqres.api.conditions.Condition;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response register;

//    public AssertableResponse(Response register) {
//        this.register = register;
//    }

    public void shouldHave(Condition condition) {

    }


}
