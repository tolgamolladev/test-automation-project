package web;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest extends BaseApiTest
{
    private Response newBooking;
    private int bookingId;
    private static final String ALL_BOOKINGS_URL = "https://restful-booker.herokuapp.com/booking";

    @BeforeMethod
    public void setUp()
    {
        newBooking = createBooking();
        bookingId = newBooking.jsonPath().getJsonObject("bookingid");
    }

    @Test
    public void testCreateBooking()
    {
        Assert.assertEquals(newBooking.jsonPath().getJsonObject("booking.firstname"), "Tolga");
    }

    @Test
    public void testGetAllBooking()
    {
        Response response = given()
                .when()
                .get("/booking");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testGetBooking()
    {
        Response response = given()
                .when()
                .get("/booking/" + bookingId);

        response
                .then()
                .statusCode(201)
                .body("firstname", equalTo("tolga"));

        String firstName = response.jsonPath().getJsonObject("firstname");

        Assert.assertEquals(firstName, "Tolga");
    }

    @Test
    public void testUpdateBooking()
    {
        String token = createToken();

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(bookingObject("Ahmet", "Mehmet"))
                .put("/booking/" + bookingId);

        String firstName = response.jsonPath().getJsonObject("firstname");

        Assert.assertFalse(firstName.equals("Tolga"));
        Assert.assertTrue(firstName.equals("Ahmet"));
    }

    @Test
    public void testPartiallyUpdate()
    {
        String token = createToken();

        JSONObject body = new JSONObject();
        body.put("firstname", "osman");
        body.put("depositpaid", false);

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(body.toString())
                .patch("/booking/" + bookingId);

        String firstName = response.jsonPath().getJsonObject("firstname");
        boolean depositPaid = response.jsonPath().getJsonObject("depositpaid");

        Assert.assertEquals(firstName, "osman");
        Assert.assertEquals(depositPaid, false);
    }

    @Test
    public void testDeleteBooking()
    {
        String token = createToken();

        given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .delete("/booking/" + bookingId);

        Response response = given()
                .when()
                .get("/booking/" + bookingId);

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
