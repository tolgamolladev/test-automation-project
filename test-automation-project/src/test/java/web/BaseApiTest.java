package web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;


import static io.restassured.RestAssured.given;

public class BaseApiTest
{

    @BeforeMethod
    public void before()
    {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        /*
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();

         */
    }

    protected Response createBooking()
    {
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(bookingObject("Tolga", "Molla"))
                .post("/booking");

        return response;
    }

    protected String createToken()
    {
        JSONObject adminUser = new JSONObject();
        adminUser.put("username", "admin");
        adminUser.put("password", "password123");

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(adminUser.toString())
                .post("/auth");

        return response.jsonPath().getJsonObject("token");
    }

    protected String bookingObject(String firstName, String lastName)
    {
        JSONObject booking = new JSONObject();

        booking.put("firstname", firstName);
        booking.put("lastname", lastName);
        booking.put("totalprice", 2000);
        booking.put("depositpaid", true);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2025-03-01");
        bookingDates.put("checkout", "2025-03-20");

        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "bira");

        return booking.toString();
    }


}
