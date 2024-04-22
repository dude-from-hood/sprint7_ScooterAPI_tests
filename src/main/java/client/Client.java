package client;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

// Базовый класс, который предоставляет общую логику для работы с API
public class Client {
    protected final String BASE_URI = "https://qa-scooter.praktikum-services.ru";
    protected final String API_PREFIX = "/api/v1";

    protected RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(API_PREFIX)
                ;
    }
}

//Используем метод spec() для получения настроенного объекта RequestSpecification
// и затем добавляют специфичные для своего API параметры (например, путь к конкретному ресурсу, тело запроса).
