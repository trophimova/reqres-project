package org.reqres.api.tests.assertions;

import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reqres.api.tests.conditions.Condition;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {

    private final Response response;

    @Step("then api response should have {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }

    public Headers headers() {
        return response.getHeaders();
    }
}
