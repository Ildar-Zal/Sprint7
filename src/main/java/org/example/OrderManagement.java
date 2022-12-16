package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderManagement {
    protected final String BASE_URI = "http://qa-scooter.praktikum-services.ru";
    protected final String ROOT = "api/v1/orders";


    public ValidatableResponse createOrder(Order order) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(order)
                .when()
                .post(ROOT)
                .then().log().all();
    }

    public ValidatableResponse getListOrders(Orders orders) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(orders)
                .when()
                .get(ROOT)
                .then().log().all();
    }
}