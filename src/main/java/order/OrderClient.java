package order;

import client.Client;
import io.restassured.response.ValidatableResponse;

public class OrderClient extends Client {
    protected final String ROOT = "/orders";

    //ValidatableResponse - это класс из библиотеки RestAssured,
    // который предоставляет удобные методы для проверки и валидации ответов от API.
    //  Он является оберткой над объектом Response и добавляет функциональность
    public ValidatableResponse create(Order order){
        return spec()
                .body(order)
                .when()
                .post(ROOT)
                .then().log().all();
    }

    public ValidatableResponse getListOrders(){
        return spec()
                .get(ROOT)
                .then().log().all();
    }
}
