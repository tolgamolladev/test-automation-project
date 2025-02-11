package web;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ContactApiTests
{
    @Test
    public void testGetContactList()
    {
        Response userResponse = addUser();
        String token = userResponse.jsonPath().getJsonObject("token");

        Response contactResponse = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get("https://thinking-tester-contact-list.herokuapp.com/contacts");

        Assert.assertEquals(contactResponse.getStatusCode(), 200);
    }

    @Test
    public void updateUserPartially()
    {
        Response userResponse = addUser();
        String token = userResponse.jsonPath().getJsonObject("token");

        JSONObject partiallyBody = new JSONObject();
        partiallyBody.put("firstName", "osman");

        Response newResponse = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(partiallyBody.toString())
                .patch("https://thinking-tester-contact-list.herokuapp.com/users/me");

        Assert.assertEquals(newResponse.statusCode(), 200);
        Assert.assertEquals(newResponse.jsonPath().getJsonObject("firstName"), "osman");

        Response userResponse2 = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get("https://thinking-tester-contact-list.herokuapp.com/users/me");

        Assert.assertEquals(userResponse2.statusCode(), 200);
        Assert.assertEquals(userResponse2.jsonPath().getJsonObject("firstName"), "osman");

        userResponse2.prettyPrint();
    }

    public Response addUser()
    {
        String email = RandomStringUtils.randomAlphanumeric(10).toUpperCase() + "@test.com";
        JSONObject body = new JSONObject();

        body.put("firstName", "tolga");
        body.put("lastName", "molla");
        body.put("email", email);
        body.put("password", "tolga123");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://thinking-tester-contact-list.herokuapp.com/users");

        response.prettyPrint();

        return response;
    }

}
