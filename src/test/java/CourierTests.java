import io.restassured.response.ValidatableResponse;
import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourierTest {

    private final CourierGenerator generator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();

    private int courierId;

    private Courier courier;

    private ValidatableResponse creationResponse;

    private ValidatableResponse loginResponse;

    private ValidatableResponse deleteResponse;

    private Credentials creds;


@Before
public void setupCurier(){
    courier = generator.random();
    creationResponse = client.create(courier);
    creds = Credentials.from(courier);
    loginResponse = client.login(creds);
    courierId = client.getCourierId(loginResponse);
}

    @After
    public void deleteCourier() {
        if (courierId > 0) {
            deleteResponse = client.delete(courierId);
            check.deletedtedSuccessfully(deleteResponse);
        }
    }

    @Test
    public void testLoginCreate() {
       check.createdSuccessfully(creationResponse);
    }

    @Test
    public void testLoginExist(){
        ValidatableResponse response = client.create(courier);
        check.logginAlreadyExist(response);

    }
    @Test
    public void testCreateFailNoPassword(){
        Courier courier = generator.genericNoPassword();
        ValidatableResponse response = client.create(courier);
        check.createFailed(response);
    }
    @Test
    public void testCreateFailNoLogin(){
        Courier courier = generator.genericNoLogin();
        ValidatableResponse response = client.create(courier);
        check.createFailed(response);
    }

    @Test
    public void testLoggedIn(){
        check.loggedInSuccessfully(loginResponse);
    }

    @Test
    public void testLogInNoPassword(){
        Courier courier = generator.genericNoLogin();
        creds = Credentials.from(courier);
        loginResponse = client.login(creds);
        check.logInFailed(loginResponse);
    }
    @Test
    public void testLogInWrongLogin(){
        loginResponse = client.loginWithWrongData();
        check.wrongData(loginResponse);
    }

}
