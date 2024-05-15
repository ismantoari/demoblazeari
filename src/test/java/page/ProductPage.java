package page;

import helper.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.BaseTest.driver;
import static page.HomePage.homePrice;

public class ProductPage {

    By productNameSelected (String productName){
        //return By.xpath("//a [@class='hrefch' and text()='" + productName + "']");
        return By.xpath("//a[text()='" + productName + "']");
    }

    By productPageName = By.xpath("//h2 [@class=\"name\"]");
    By buttonATC = By.xpath("//a [@class=\"btn btn-success btn-lg\" and text()='Add to cart']");
    By priceAreaOnProductPage = By.xpath("//h3");
    By productDescription = By.xpath("//div[@id=\"more-information\"]/child::strong");

    By imgPlace = By.xpath("//div[@id=\"imgp\"]/descendant::img");

    public String priceOnProductPage;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public void userClickProduct(String productName){
        wait.until(ExpectedConditions.presenceOfElementLocated(productNameSelected(productName)));
        // wait.until(ExpectedConditions.elementToBeClickable(productNameSelected(productName)));
        // String debugProductName = driver.findElement(productNameSelected(productName)).getText();
        //System.out.println("debug product name : " + debugProductName);
        driver.findElement(productNameSelected(productName)).click();
    }

    public void userIsOnProductPage(String productName) {

        //check correct product page name
        wait.until(ExpectedConditions.presenceOfElementLocated(productPageName));
        String pageName = driver.findElement(productPageName).getText();
        Assert.assertEquals(productName, pageName);
    }

    public void assertAppearanceOfAtcButton(){
        //check there is button ATC
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonATC));
        boolean appearButtonATC = driver.findElement(buttonATC).isDisplayed();
        Assert.assertTrue(appearButtonATC);
    }


    public void userClickButtonAddToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonATC));
        driver.findElement(buttonATC).click();
    }

    public void productPriceOnProductPageOf(String productName){
        wait.until(ExpectedConditions.presenceOfElementLocated(productPageName));
        String productPriceAppear = driver.findElement(priceAreaOnProductPage).getText();
        priceOnProductPage = productPriceAppear.replaceAll("[^\\d]", "");

    }

    public void productDescriptionOnProductPage(){
        String containerText = driver.findElement(productDescription).getText();
        Assert.assertEquals("Product description",containerText);
    }

    public void thereIsProductImageOnProductPage(String productImg){
        String actualProductImage = driver.findElement(imgPlace).getAttribute("src");
        String expectedProductImage = "https://www.demoblaze.com/imgs/"+productImg;
        Assert.assertEquals(expectedProductImage, actualProductImage);

    }

    public void userSeeSamePriceOfOnProductPage(String productName){
        productPriceOnProductPageOf(productName);
        Assert.assertEquals(homePrice,priceOnProductPage);
    }

}