package Testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.Selenium.utilities.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.Selenium.utilities.ErrorHandler;


public class UpdateUserTest {

    @Test
    public void updateUser() {
        String userId = "1";  // Assuming user ID 1 exists
        String requestPayload = "{ \"name\": \"John Updated\", \"job\": \"Senior Developer\" }";

        try {
            // Send PUT request to update the user
            Response response = RestAssured.given()
                    .baseUri(new ConfigManager().getBaseUrl())
                    .contentType("application/json")
                    .body(requestPayload)
                    .put("/api/users/" + userId);

            System.out.println("Response Body: " + response.getBody().asString());

            // Validate the update response
            Assert.assertEquals(response.getStatusCode(), 200, "User update failed");
            Assert.assertEquals(response.jsonPath().getString("name"), "John Updated", "User name update failed");
        } catch (Exception e) {
            // Use the ErrorHandler utility to log the error
            ErrorHandler.handleError(e);
            Assert.fail("Test failed due to an exception");
        }
    }
}
