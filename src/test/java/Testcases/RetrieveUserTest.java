package Testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.Selenium.utilities.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.Selenium.utilities.ErrorHandler;


public class RetrieveUserTest {


    @Test
    public void retrieveUser() {
        String userId = "2";

        try {
            // Send GET request to retrieve user
            Response response = RestAssured.given()
                    .baseUri(new ConfigManager().getBaseUrl())
                    .get("/api/users/" + userId);


            System.out.println("Response Body: " + response.getBody().asString());

            // Validate the response and ensure user details are correct
            Assert.assertEquals(response.getStatusCode(), 200, "User retrieval failed");
            Assert.assertEquals(response.jsonPath().getString("data.id"), userId, "User ID mismatch");
        } catch (Exception e) {
            // Use the ErrorHandler utility to log the error
            ErrorHandler.handleError(e);
            Assert.fail("Test failed due to an exception");
        }
    }
}
