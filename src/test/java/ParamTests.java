
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.example.CourierAssertions;
import org.example.Order;
import org.example.OrderAssertions;
import org.example.OrderManagement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class ParamatrizedTest {
    private ValidatableResponse loginResponse;
    private final OrderAssertions check = new OrderAssertions();
    OrderManagement management = new OrderManagement();
    List<String>color;

    Order order;
    public ParamatrizedTest (List<String> color){
        this.color = color;
    }

    @Before
    public void setUp(){
         order = new Order("Kon","Zal","Sever5","Yaroslavskkaya","8900123123","5","2020-06-06","test",color);
         loginResponse =  management.createOrder(order);
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSex() {
        return new Object[][]{
                {Arrays.asList("BLACK","GREY")},
                {Arrays.asList("GREY")},
                {Arrays.asList("BLACK")},
                {Arrays.asList()},
        };
    }

    @Test
    public void testCreateOrder(){
        check.createdSuccessfully(loginResponse);
    }
}
