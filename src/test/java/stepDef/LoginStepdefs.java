package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.LoginPage;

public class LoginStepdefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user click login menu")
    public void userClickLoginMenu() {
        loginPage.userClickLoginMenu();
    }

    @And("user input login username {string}")
    public void userInputLoginUsername(String username) throws InterruptedException {
        Thread.sleep(1000);
            loginPage.userInputLoginUsername(username);
    }

    @And("user input login password {string}")
    public void userInputLoginPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        loginPage.userInputLoginPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton()  throws InterruptedException {
        Thread.sleep(1000);
        loginPage.userClickLoginButton();
    }

    @Then("user see login greeting {string}")
    public void userSeeLoginGreeting(String loginGreeting) throws InterruptedException {
        Thread.sleep(1000);
        loginPage.userSeeLoginGreeting(loginGreeting);
        Thread.sleep(1000);
    }


    @Then("pop up login will opened")
    public void popUpLoginWillOpened() {
        loginPage.popUpLoginWillOpened();
    }

    @Then("user see logout menu")
    public void userSeeLogoutMenu() {
        homePage.userSeeLogoutMenu();
    }
}