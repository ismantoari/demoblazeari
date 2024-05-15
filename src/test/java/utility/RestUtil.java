package utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

import java.io.File;

public class RestUtil {
    public static RequestSpecification request;

    public static void headersNoAuth() {
        request = RestAssured.given()
                .header("app-id", "66385a6077f0107804b753a8")
                .header("Content-type", "application/json")
                .header("Accept", "application/json");

    }


    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/utility/JSONSchemaData/" + JSONFile);
    }

    public static String randomEmail() {
        //String allowedChars = "abcdefghijklmnopqrstuvwxyz"+"1234567890"+"_";
        String email;
        String temp = RandomStringUtils.randomAlphanumeric(5);//panjang email 5 karakter
        email = temp + "@arisaja.com";
        return email;

    }

    public static Response CreateNewUsers(String alamatURL) {
        String firstName = "Ari";
        String lastName = "Sragen";
        String email = randomEmail();

        JSONObject bodyReq = new JSONObject();

        bodyReq.put("firstName", firstName);
        bodyReq.put("lastName", lastName);
        bodyReq.put("email", email);

        headersNoAuth();
        return request.body(bodyReq.toString()).when().post(alamatURL);
    }

    public static Response CreateNewUsersWithoutFirstName(String alamatURL) {
        String firstName = "";
        String lastName = "Sragen";
        String email = randomEmail();

        JSONObject bodyReq = new JSONObject();

        bodyReq.put("firstName", firstName);
        bodyReq.put("lastName", lastName);
        bodyReq.put("email", email);

        headersNoAuth();
        return request.body(bodyReq.toString()).when().post(alamatURL);
    }

    public static Response CreateNewUsersWithoutEmail(String alamatURL) {
        String firstName = "Ari";
        String lastName = "Sragen";
        String email = "";

        JSONObject bodyReq = new JSONObject();

        bodyReq.put("firstName", firstName);
        bodyReq.put("lastName", lastName);
        bodyReq.put("email", email);

        headersNoAuth();
        return request.body(bodyReq.toString()).when().post(alamatURL);
    }

    public static Response updateUser(String endpoint, String id_user) {

        String updateEndpoint = endpoint + "/" + id_user;

        System.out.println("target URL : " + updateEndpoint);

        String firstName = "Ari Update";
        String lastName = "Sragen";
        String email = randomEmail();


        JSONObject payload = new JSONObject();

        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);

        headersNoAuth();

        return request.body(payload.toString())
                .when()
                //.patch(updateEndpoint);
                .put(updateEndpoint);


    }

    public static Response deleteUser(String endpoint, String id_user) {
        String deleteEndpoint = endpoint + "/" + id_user;
        headersNoAuth();
        return request
                .when()
                .delete(deleteEndpoint);

    }
}