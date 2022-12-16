package org.example;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class OrderAssertions {

    public void createdSuccessfully(ValidatableResponse response){
        response.assertThat()
                .statusCode(201)
                .body("track", greaterThan(0));
    }
    public void gotOrdersSuccessfully(ValidatableResponse response){
        response.assertThat()
                .statusCode(200)
                .body("orders",is(notNullValue()));
    }
}
