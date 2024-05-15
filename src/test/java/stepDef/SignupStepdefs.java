package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.LoginPage;
import page.SignupPage;


public class SignupStepdefs {
    SignupPage signup = new SignupPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user is on sign up form")
    public void userIsOnSignupForm() {
        signup.userIsOnSignupForm();
    }

    @And("user input new username")
    public void userInputNewUsername() {
        signup.userInputNewUsername();
    }

    @And("user input username {string}")
    public void userInputUsername(String userName) {
        signup.userInputUsername(userName);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        signup.userInputPassword(password);
    }

    @When("user click sign up button")
    public void userClickSignupButton() {
        signup.userClickSignupButton();
    }

    @When("user click close button on sign up form")
    public void userClickCloseButtonOnSignUpForm() {
        signup.userClickCloseButton();
    }

    @Then("username {string} with password {string} will not registered or {string}")
    public void usernameWithPasswordWillNotRegisteredOr(String username, String password, String notif) throws InterruptedException {
        homePage.userIsOnHomePage();
        loginPage.userClickLoginMenu();
        loginPage.userInputLoginUsername(username);
        loginPage.userInputLoginPassword(password);
        loginPage.userClickLoginButton();
        homePage.userSeeNotifPopUp(notif);
    }


}