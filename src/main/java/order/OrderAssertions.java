package order;
import io.restassured.response.ValidatableResponse;
import static java.net.HttpURLConnection.*;
import static org.hamcrest.Matchers.*;

public class OrderAssertions {
    public void createdSuccessfully(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_CREATED)
                .body("track", greaterThan(0));
    }

    public void getListOrdersSuccessfully(ValidatableResponse response){
          response.assertThat()
                .statusCode(HTTP_OK)
                .body("orders", not(empty()))
                ;
    }
}
