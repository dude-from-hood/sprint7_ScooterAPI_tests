package courier;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import java.util.Map;

public class CourierTest {
    // указываем объекты с типом final чтобы были неизменяемыми после создания
    private final CourierGenerator generator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();

    private int courierId;  // default value

    @After
    @DisplayName("Courier - Удаление курьера, /api/v1/courier")
    @Description("Check sucsessfull deletion of courier")
    public void deleteCourier() {
        if (courierId > 0) {
            ValidatableResponse response = client.delete(courierId);
            check.deletedSuccessfully(response);
        }
    }

    @Test
    @DisplayName("Успешное создание & логин курьера")
    @Description("Check successfull creation new courier & his login")
    public void creationCourier() {
        Courier courier = generator.random();
        ValidatableResponse creationResponse = client.create(courier);
        check.createdSuccessfully(creationResponse);

        Credentials creds = Credentials.from(courier);
        ValidatableResponse loginResponse = client.login(creds);
        courierId = check.loggedInSuccessfully(loginResponse);

        assert courierId > 100;
    }

    @Test
    @DisplayName("Checking of failed creation")
    @Description("Check possibility of creating a courier without password")
    public void creationFails() {
        Courier courier = generator.generic();
        courier.setPassword(null);

        ValidatableResponse loginResponse = client.create(courier);
        String message = check.creationFailed(loginResponse);
        assert !message.isBlank();
    }

    @Test
    @DisplayName("Checking of double creation")
    @Description("Check possibility of creating a courier with the same creds")
    public void alreadyCreated(){
        Courier courier = generator.generic();

        ValidatableResponse loginResponse = client.create(courier);
        String message = check.createdAlready(loginResponse);
        assert !message.isBlank();
    }

    @Test
    @DisplayName("Checking of failed login")
    @Description("Check possibility of login without first_name")
    public void loginFails() {
        ValidatableResponse loginResponse = client.login(Map.of("password", "null"));
        check.loginFailed(loginResponse);
    }
}