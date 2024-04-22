package toporStyle;

import courier.Courier;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import io.qameta.allure.Description; // импорт Description

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

// тест на проверку логина курьера

public class TestCourierToporStyle {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    //тест на проверку логина
    @Test
    @DisplayName("Check login of /courier/login") // имя теста
    @Description("Basic test for /courier/login") // описание теста
    public void checkCourierLogin() {
        Courier courier = new Courier("wayan", "1234", "gede");
        Response response =
                given().log().all()
                        .contentType(ContentType.JSON)
                        .and()
                        .body(courier)
                        .when()
                        .post("/api/v1/courier/login");
        response.then().log().all().
                assertThat().body("id", notNullValue())
                .and()
                .statusCode(200);
    }
}


