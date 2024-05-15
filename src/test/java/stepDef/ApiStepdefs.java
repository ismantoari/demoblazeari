package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ApiPage;


public class ApiStepdefs {
    ApiPage apiPage = new ApiPage();

    @Given("url for {string}")
    public void urlFor(String urlGiven) {
        apiPage.urlForExecute(urlGiven);
    }

    @Given("url for get list user by id {string}")
    public void urlForGetListUserById(String byId) {
        apiPage.urlForGetListUserById(byId);
    }

    @When("hit api to get list users")
    public void hitApiToGetListUsers() {
        apiPage.apiToGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statusCode) {
        apiPage.validationStatusCode(statusCode);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();

    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String fileName) {
        apiPage.validationResponseJsonWithJSONSchema(fileName);

    }


    @Then("validation response body get list users by id")
    public void validationResponseBodyGetListUsersById() {
        apiPage.validationResponseBodyGetListUsersById();
    }

    @And("hit api to create new users")
    public void hitApiToCreateNewUsers() {
        apiPage.apiToCreateNewUsers();
    }

    @Then("validation response body create new users")
    public void validationResponseBodyCreateNewUsers() {
        apiPage.validationResponseBodyCreateNewUsers();
    }

    @And("hit api to create new users without first name")
    public void hitApiToCreateNewUsersWithoutFirstName() {
        apiPage.apiToCreateNewUsersWithoutFirstName();

    }

    @And("hit api to create new users without email")
    public void hitApiToCreateNewUsersWithoutEmail() {
        apiPage.apiToCreateNewUsersWithoutEmail();
    }

    @And("hit api to update data users")
    public void hitApiToUpdateDataUsers() {
        apiPage.apiToUpdateEmailAndUsersName();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();

    }

    @And("hit api to delete users")
    public void hitApiToDeleteUsers() {
        apiPage.apiToDeleteUsers();
    }

    @When("hit api to get tag")
    public void hitApiToGetTag() {
        apiPage.apiToGetTag();
    }


}