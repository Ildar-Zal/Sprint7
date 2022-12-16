import io.restassured.response.ValidatableResponse;
import org.example.OrderAssertions;
import org.example.OrderManagement;
import org.example.Orders;
import org.junit.Before;
import org.junit.Test;

public class OrdersTest {
    private ValidatableResponse response;
    private final OrderAssertions check = new OrderAssertions();
    OrderManagement management = new OrderManagement();

    @Before
    public void setUp(){
        Orders orders = new Orders("","","","");
        response= management.getListOrders(orders);
    }

    @Test
    public void testGotOrders(){
       check.gotOrdersSuccessfully(response);
    }
}
