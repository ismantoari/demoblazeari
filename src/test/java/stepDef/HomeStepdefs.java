
package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

public class HomeStepdefs {
    HomePage homePage = new HomePage();

    @Then("user see notification pop up {string}")
    public void userSeeNotifPopUp(String textPopup) throws InterruptedException {
        Thread.sleep(1000);
        homePage.userSeeNotifPopUp(textPopup);
    }

    @And("user click OK button on notification")
    public void userClickOkButtonOnNotification() {
        homePage.userClickOkButtonOnNotification();
    }

    @Given("user is on home page")
    public void   userIsOnHomePage() {
        homePage.userIsOnHomePage();
    }

    @When("user look at the top left side of the homepage")
    public void userLookAtTheTopLeftSideOfTheHomepage() {
        homePage.userLookAtTheTopLeftSideOfTheHomepage();
    }

    @Then("user will see logo {string} and store name {string}")
    public void userWillSeeLogoAndStoreName(String logo, String storeName) {
        homePage.userWillSeeLogoAndStoreName(logo, storeName);
    }


//    @Then("Product only display phone product")
//    public void productOnlyDisplayPhoneProduct() throws InterruptedException {
//        homePage.assertionProductOnlyDisplayPhoneProduct();
//    }

    @When("user click categories {string}")
    public void userClickCategories(String categories) {
        homePage.userClickCategories(categories);
    }

    @Then("home page only display {string}")
    public void homePageOnlyDisplay (String productShow) throws InterruptedException {
        homePage.homePageOnlyDisplay(productShow);
    }

    @When("user click menu {string}")
    public void userClickMenu(String menu){
        homePage.userClickMenu(menu);
    }

    @And("user click ok button pop up")
    public void userClickOkButtonPopUp(){
        homePage.userClickOkButtonPopUp();
    }

    @And("user check price of {string} on homepage")
    public void userCheckPriceOfOnHomepage(String productName) {
        homePage.userCheckPriceOfOnHomepage(productName);
    }

    @Then("user is taken back to homepage")
    public void userIsTakenBackToHomepage() throws InterruptedException {
        homePage.userIsTakenBackToHomepage();
    }

    @Then("user will see menu {string}")
    public void userWillSeeMenu(String menuName) {
        homePage.userWillSeeMenu(menuName);
    }

    @Then("appear pop up about us")
    public void appearPopUpAboutUs() {
        homePage.appearPopUpAboutUs();
    }

    @When("user click close button on pop up")
    public void userClickCloseButtonOnPopUp() {
        homePage.userClickCloseButtonOnPopUp();
    }

    @Then("pop up About us is closed")
    public void popUpAboutUsIsClosed() {
        homePage.popUpAboutUsIsClosed();
    }


}