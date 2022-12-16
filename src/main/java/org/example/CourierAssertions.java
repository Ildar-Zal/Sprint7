package org.example;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class CourierAssertions {
    public void createdSuccessfully(ValidatableResponse response){
            response.assertThat()
                    .statusCode(201)
                    .body("ok", is(true));

    }
    public void loggedInSuccessfully(ValidatableResponse response){
            response.assertThat()
                .statusCode(200)
                .body("id", greaterThan(0));
    }
    public void createFailed(ValidatableResponse response){
            response
                .assertThat()
                .statusCode(400)
                .and().body("message",equalTo("Недостаточно данных для создания учетной записи"));

    }
    public void logInFailed(ValidatableResponse response){
        response
                .assertThat()
                .statusCode(400)
                .and().body("message",equalTo("Недостаточно данных для входа"));
    }
    public void deletedtedSuccessfully(ValidatableResponse response) {
         response.assertThat()
                .statusCode(200)
                .body("ok", equalTo(true));
    }
    public void logginAlreadyExist(ValidatableResponse response) {
        response.assertThat()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }
    public void wrongData(ValidatableResponse response) {
        response.assertThat()
                .statusCode(404)
                .body("message", equalTo("Учетная запись не найдена"));
    }
}
