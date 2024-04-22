package courier;
import io.restassured.response.ValidatableResponse;
import static java.net.HttpURLConnection.*;
import static org.hamcrest.Matchers.*;

// Класс, содержащий методы для проверки ответов API, связанных с операциями над курьерами.
//  Каждый метод соответствует определенному сценарию и проверяет ожидаемое поведение API.
public class CourierAssertions {
    public void createdSuccessfully(ValidatableResponse response) {
        response.assertThat()
                .statusCode(HTTP_CREATED)
                .body("ok", is(true))
        ;

    }
    public int loggedInSuccessfully(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(HTTP_OK)
                .body("id", greaterThan(0))
                .extract()
                .path("id")
                ;

    }

    public String creationFailed(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(HTTP_BAD_REQUEST)
                .body("message", notNullValue())
                .extract()
                .path("message")
                ;
    }

    public String createdAlready(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(HTTP_CONFLICT)
                .body("message", notNullValue())
                .extract()
                .path("message")
                ;
    }

    public void loginFailed(ValidatableResponse response) {
        response.assertThat()
                .statusCode(HTTP_BAD_REQUEST)
                .body("message", notNullValue());
    }

    public void deletedSuccessfully(ValidatableResponse response) {
        response.assertThat()
                .statusCode(HTTP_OK)
                .body("ok", is(true))
        ;
    }
}