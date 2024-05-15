package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ContactPage;

public class ContactStepdefs {

    ContactPage contactPage = new ContactPage();

    @Then("appear form {string}")
    public void appearForm(String formName) {
        contactPage.appearForm(formName);
    }

    @And("user input email {string}")
    public void userInputEmail(String email) {
        contactPage.userInputEmail(email);
    }

    @And("user input name {string}")
    public void userInputName(String name) {
        contactPage.userInputName(name);
    }

    @And("user input message {string}")
    public void userInputMessage(String message) {
        contactPage.userInputMessage(message);
    }

    @When("user click button Send message")
    public void userClickButtonSendMessage() {
        contactPage.clickButtonSendMessage();
    }

    @When("user click button Close")
    public void userClickButtonClose() {
        contactPage.clickButtonClose();
    }

    @And("appear form message")
    public void appearFormMessage() {
        contactPage.appearFormMessage();
    }

    @Then("form send message is close")
    public void formSendMessageIsClose() {
        contactPage.formSendMessageIsClose();
    }
}