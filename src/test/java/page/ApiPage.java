package page;

import helper.ApiEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import utility.RestUtil;

import java.io.File;
import java.util.List;

import static helper.ApiEndpoint.GET_LIST_USER;
import static org.assertj.core.api.Assertions.assertThat;
import static utility.RestUtil.*;

public class ApiPage {

    String setURL, id_user;
    Response res;
    public static String idUser;

    public void urlForExecute(String urlGiven){
        switch (urlGiven) {
            case "GET_LIST_USERS":
                setURL = GET_LIST_USER;
                System.out.println("setURL : " + setURL);
                break;
            case "CREATE_NEW_USERS":
                setURL = ApiEndpoint.CREATE_NEW_USER;
                System.out.println("setURL : " + setURL);
                break;
            case "UPDATE_USERS":
                setURL = ApiEndpoint.UPDATE_USER;
                break;
            case "GET_TAG":
                setURL = ApiEndpoint.GET_TAG;
                System.out.println("setURL : " + setURL);
                break;

            default:
                System.out.println("input correct url");
        }
    }


    public void urlForGetListUserById(String byId){

        setURL = GET_LIST_USER + "/"+ byId;
        System.out.println(" SET URL NYA : " + setURL);

    }



    public static Response getListUsers(String endpoint) {
        headersNoAuth();
        return request.when().get(endpoint);
    }
    public void apiToGetListUsers(){
        res = getListUsers(setURL);
        System.out.println("respnse body: " + res.getBody().asString());
    }


    public void validationStatusCode(int statusCode){
        assertThat(res.statusCode()).isEqualTo(statusCode);
        System.out.println("status code : "+ res.statusCode());
    }

    public void validationResponseBodyGetListUsers(){

        List<Object> id = res.jsonPath().getList("data.id");
        List<Object> title = res.jsonPath().getList("data.title");
        List<Object> firstName = res.jsonPath().getList("data.firstName");
        List<Object> lastName = res.jsonPath().getList("data.lastName");
        List<Object> picture = res.jsonPath().getList("data.picture");

        assertThat(id.get(0)).isNotNull();
        assertThat(title.get(0)).isIn("mrs","ms","miss","mr");
        assertThat(firstName.get(0)).isNotNull();
        assertThat(lastName.get(0)).isNotNull();
        assertThat(picture.get(0)).isNotNull();

    }

    public void validationResponseBodyGetListUsersById(){

        String id = res.jsonPath().get("id");
        String title = res.jsonPath().get("title");
        String firstName = res.jsonPath().get("firstName");
        String lastName = res.jsonPath().get("lastName");
        String picture = res.jsonPath().get("picture");

        assertThat(id).isNotNull();
        assertThat(title).isIn("mrs","ms","miss","mr");
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(picture).isNotNull();

    }

    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = RestUtil.getJSONSchemaFile(filename);
        System.out.println("JSONFilenya : "+JSONFile);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void apiToCreateNewUsers(){
        res = CreateNewUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyCreateNewUsers(){
        String idNo = res.jsonPath().get("id");
        //debug System.out.println("idNo : "+idNo);
        //int id = Integer.parseInt(idNo);
        String title = res.jsonPath().get("title");
        String firstName = res.jsonPath().get("firstName");
        String lastName = res.jsonPath().get("lastName");
        String email = res.jsonPath().get("email");
        String picture = res.jsonPath().get("picture");


        assertThat(idNo).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();

        //id_user = Integer.toString(id);
        this.id_user = idNo;
        idUser = id_user;
    }


    public void apiToCreateNewUsersWithoutFirstName() {
        res = CreateNewUsersWithoutFirstName(setURL);
        System.out.println(res.getBody().asString());
    }

    public void apiToCreateNewUsersWithoutEmail(){
        res = CreateNewUsersWithoutEmail(setURL);
        System.out.println(res.getBody().asString());

    }

    public void apiToUpdateEmailAndUsersName(){
        System.out.println("id yang akan di update : " + id_user);
        res = RestUtil.updateUser(GET_LIST_USER,id_user);
        System.out.println("update data : " +res.getBody().asString());
    }

    public void validationResponseBodyUpdateUser(){
        String id = res.jsonPath().get("id");
        String firstName = res.jsonPath().get("firstName");
        String lastName = res.jsonPath().get("lastName");
        String email = res.jsonPath().get("email");


        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();

    }

    public void apiToDeleteUsers(){
        System.out.println("id yang akan di delete : " + id_user);
        res = RestUtil.deleteUser(GET_LIST_USER,id_user);

    }

    public static Response getListTag(String endpoint) {
        headersNoAuth();
        return request.when().get(endpoint);
    }

    public void apiToGetTag(){
        res = getListTag(setURL);

        // System.out.println("Set URL : " + setURL);
        // System.out.println("respnse body: " + res.getBody().asString());

    }
}