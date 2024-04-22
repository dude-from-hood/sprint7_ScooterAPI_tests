package courier;
import client.Client;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

//Класс CourierClient выступает как специализированный клиент для работы с API курьеров.
// Он инкапсулирует логику отправки запросов, обработки ответов и предоставляет удобные методы для взаимодействия с API.
//  Ниже созданы методы для создания, авторизации и удаления курьеров.
//  Этот класс скрывает детали реализации HTTP-запросов (URL, заголовки, тело) и обработки ответов.

public class CourierClient extends Client {
    protected final String ROOT = "/courier";

    public ValidatableResponse create(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all();
    }

    public ValidatableResponse login(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(ROOT + "/login")
                .then().log().all();
    }

    public ValidatableResponse login(Map<String, String> creds) {
        return spec()
                .body(creds)
                .when()
                .post(ROOT + "/login")
                .then().log().all();
    }

    public ValidatableResponse delete(int courierId) {
        String json = String.format("{\"id\": \"%d\"}", courierId);

        return spec()
                .body(json)
                .when()
                .delete(ROOT + "/" + courierId)
                .then().log().all();
    }
}
