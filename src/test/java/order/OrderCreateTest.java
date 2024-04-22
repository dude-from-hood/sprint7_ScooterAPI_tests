package order;
import java.util.List;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderCreateTest {
    private final Order order;
    private final OrderClient orderClient = new OrderClient();
    private final OrderAssertions check = new OrderAssertions();

    public OrderCreateTest(List<String> color) {
        order = Order.randomOrder(color);
    }

    @Parameterized.Parameters(name = "color: {0}")
    public static Object[] getColorsForTest() {
        return new Object[] {
                List.of("BLACK"),
                List.of("GREY"),
                List.of("BLACK", "GREY"),
                List.of(""),
        };
    }

    @Test
    @DisplayName("Checking of creating an order /api/v1/orders")
    @Description("Check possibility of creating an order with random colours")
    public void checkCreationOrderWithColorsForTest(){
        ValidatableResponse response = orderClient.create(order);
        check.createdSuccessfully(response);
    }
}
