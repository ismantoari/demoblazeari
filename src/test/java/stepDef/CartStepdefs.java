package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CartPage;

public class CartStepdefs {
    CartPage cartPage = new CartPage();


    @Then("user see product {string} in the cart")
    public void userSeeProductInTheCart(String productName) {
        cartPage.productIsAddedToCart(productName);
    }

    @Then("user see same price of {string} on cart")
    public void userSeeSamePriceOfOnCart(String productName) {
        cartPage.userSeeSamePriceOfOnCart(productName);
    }

    @When("user click delete for {string}")
    public void userClickDeleteFor(String productName) {
        cartPage.userClickDeleteFor(productName);
    }

    @Then("product {string} is reduce from cart")
    public void productIsReduceFromCart(String productName) throws InterruptedException {
        cartPage.productIsReduceFromCart(productName);
    }

    @And("user have no any product on cart")
    public void userHaveNoAnyProductOnCart() {
        cartPage.userHaveNoAnyProductOnCart();

    }

    @Then("user assert total amount in the cart")
    public void userAssertTotalAmountInTheCart() throws InterruptedException{
        cartPage.userAssertTotalAmountInTheCart();
    }

    @And("user click button Place Order")
    public void userClickButtonPlaceOrder() throws InterruptedException {
        Thread.sleep(1000);
        cartPage.userClickButtonPlaceOrder();
    }
}