package order;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;


public class OrderListTest {
    private final OrderClient orderClient = new OrderClient();
    private final OrderAssertions check = new OrderAssertions();

    @Test
    @DisplayName("Check the route of /api/v1/orders")
    @Description("Checking getting the list of orders ")
    public void checkGettingOrders() {
        ValidatableResponse ordersList = orderClient.getListOrders();
        check.getListOrdersSuccessfully(ordersList);
    }
}
