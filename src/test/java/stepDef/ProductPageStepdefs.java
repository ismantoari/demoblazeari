package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ProductPage;

public class ProductPageStepdefs {

    ProductPage productPage = new ProductPage();

    @When("user click product {string}")
    public void userClickProduct(String productName) {
        productPage.userClickProduct(productName);

    }

    @Then("user is on product page {string}")
    public void userIsOnProductPage(String productName) {
        productPage.userIsOnProductPage(productName);
    }

    @When("user click button add to cart")
    public void userClickButtonAddToCart() {
        productPage.userClickButtonAddToCart();
    }

    @Then("user see same price of {string} on product page")
    public void userSeeSamePriceOfOnProductPage(String productName) {
        productPage.userSeeSamePriceOfOnProductPage(productName);
    }

    @Then("there is product description on product page")
    public void thereIsProductDescriptionOnProductPage() {
        productPage.productDescriptionOnProductPage();
    }

    @Then("there is product image {string} on product page")
    public void thereIsProductImageOnProductPage(String productImg) {
        productPage.thereIsProductImageOnProductPage(productImg);
    }

    @Then("there is button add to cart on product page")
    public void thereIsButtonAddToCartOnProductPage() {
        productPage.assertAppearanceOfAtcButton();
    }
}