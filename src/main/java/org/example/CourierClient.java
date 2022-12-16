package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;


public class CourierClient {
    protected final String BASE_URI = "http://qa-scooter.praktikum-services.ru";
    protected final String ROOT = "/api/v1/courier";


    public ValidatableResponse create(Courier courier) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all();
    }

    public ValidatableResponse login(Credentials creds) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(creds)
                .when()
                .post(ROOT + "/login")
                .then().log().all();
    }

    public ValidatableResponse delete(int courierId) {
       Delete delete = new Delete(courierId);
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(delete)
                .when()
                .delete(ROOT + "/" + courierId)
                .then().log().all();
    }

    public ValidatableResponse loginWithWrongData() {
        String json = String.format("{\"login\": \"wronglogin\", \"password\": \"passwod\"}");
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(json)
                .when()
                .post(ROOT + "/login")
                .then().log().all();
    }
    public int getCourierId(ValidatableResponse response){
        return response
                .extract().path("id");
    }
}
