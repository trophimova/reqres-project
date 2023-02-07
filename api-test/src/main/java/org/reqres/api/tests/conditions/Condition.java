package org.reqres.api.tests.conditions;

import io.restassured.response.Response;

public interface Condition {
    void check(Response response);
}
