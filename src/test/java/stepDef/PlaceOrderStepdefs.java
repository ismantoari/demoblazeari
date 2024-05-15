package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.PlaceOrderPage;
import page.ThanksOrderPage;

public class PlaceOrderStepdefs {
    PlaceOrderPage placeOrderPage = new PlaceOrderPage();
    ThanksOrderPage thanksOrderPage = new ThanksOrderPage();

    @Then("user see form Place Order")
    public void userSeeFormPlaceOrder() throws InterruptedException {
        Thread.sleep(1000);
        placeOrderPage.assertAppearPlaceOrderPage();
    }

    @And("User input name {string}")
    public void userInputName(String name) {
        placeOrderPage.userInputName(name);
    }

    @And("user input country {string}")
    public void userInputCountry(String country) {
        placeOrderPage.userInputCountry(country);
    }

    @And("user input city {string}")
    public void userInputCity(String city) {
        placeOrderPage.userInputCity(city);
    }

    @And("user input credit card {string}")
    public void userInputCreditCard(String cc) {
        placeOrderPage.userInputCreditCard(cc);
    }

    @And("user input month {string}")
    public void userInputMonth(String month) {
        placeOrderPage.userInputMonth(month);

    }

    @And("user input year {string}")
    public void userInputYear(String year) {
        placeOrderPage.userInputYear(year);
    }

    @When("user click button Purchase on place order form")
    public void userClickButtonPurchaseOnPlaceOrderForm(){
        placeOrderPage.userClickButtonPurchaseOnPlaceOrderForm();
    }


    @Then("user see thanks page {string}")
    public void userSeeThanksPage(String thanksGreeting) {
        thanksOrderPage.textThanksGreeting (thanksGreeting);
    }

    @When("user click button OK")
    public void userClickButtonOK() {
        thanksOrderPage.clickButtonOk();
    }

    @Then("user assert data name {string} and credit card {string} on thank you page")
    public void userAssertDataNameAndCreditCardOnThankYouPage(String name, String cardNumber) {
        thanksOrderPage.assertDataNameAndCreditCard(name, cardNumber);
    }

    @Then("pop up thanks page is close")
    public void popUpThanksPageIsClose() {
        thanksOrderPage.popUpThanksPageIsClose();

    }

    @When("user click button Close on place order form")
    public void userClickButtonCloseOnPlaceOrderForm() throws InterruptedException {
        Thread.sleep(1000);
        placeOrderPage.userClickButtonCloseOnPlaceOrderForm();
    }

    @Then("form place order is closed")
    public void formPlaceOrderIsClosed() throws InterruptedException {
        Thread.sleep(1000);
        placeOrderPage.formPlaceOrderIsClosed();

    }
}