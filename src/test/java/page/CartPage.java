package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static helper.BaseTest.driver;
import static page.HomePage.homePrice;


public class CartPage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    By bodyProductAtc = By.xpath("//tbody[@id=\"tbodyid\"]");
    By countOfRowAtc = By.xpath("//tbody[@id=\"tbodyid\"]//following-sibling::tr");
    By cartProduct (String listCart){
        return By.xpath("//tbody/tr["+listCart +"]/td[2]");
    }

    By productPriceOnProductPage (String counterProduct){
        return By.xpath("//tbody/tr["+counterProduct+"]/td[2]/following-sibling::td[1]");
    }
    By buttonDeleteProduct = By.xpath("//a[text()='Delete']");
    By buttonDeleteProductTarget (String indexProductDelete){
        return By.xpath("(//tbody/tr["+indexProductDelete+"]/td[2]/following-sibling::td[2])//a");
    }
    By displayTotalPrice = By.xpath("//h3");
    By buttonPlaceOrder = By.xpath("//button[text()='Place Order']");
    ThanksOrderPage thanksOrderPage = new ThanksOrderPage();

    public int countProductAtc;
    public ArrayList<String> productInTheCart = new ArrayList<String>();
    public void countingProductOnCart(){
        //menghitung jumlah row cart
        List<WebElement> rowProduct = driver.findElements(countOfRowAtc);
        this.countProductAtc = rowProduct.size();
        //debug// System.out.println("jumlah row product : " + countProductAtc);
    }

    public void getAllProductOnChart(){
        //melihat product di row cart
        for (int i = 0; i < countProductAtc; i++) {
            int countProduct = i + 1;
            String j = Integer.toString(countProduct);
            String productAtc = driver.findElement(cartProduct(j)).getText();
            // System.out.println("product ATC : " + j + ". " + productAtc); //debug
            this.productInTheCart.add(productAtc);
        }
        //debug System.out.println("isi di cart : " + productInTheCart);
    }

    public void productIsAddedToCart (String productName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(bodyProductAtc));
        countingProductOnCart();
        //cek product ada di dalam cart
        getAllProductOnChart();
        boolean checkingContain = productInTheCart.contains(productName);
        Assert.assertTrue(checkingContain);
    }


    public void userSeeSamePriceOfOnCart(String productName){
        wait.until(ExpectedConditions.presenceOfElementLocated(bodyProductAtc));
        countingProductOnCart();

        for (int i=0; i< countProductAtc; i++) {
            int counter = i + 1;
            String counterProduct = Integer.toString(counter);
            String productAtc = driver.findElement(cartProduct(counterProduct)).getText();
            if (productAtc.contentEquals(productName)) {
                String actualPriceProductPage = driver.findElement(productPriceOnProductPage(counterProduct)).getText();
                //debug// System.out.println(actualPriceProductPage);
                Assert.assertEquals(homePrice,actualPriceProductPage);
            }
        }
    }
    public int countProductTargetBeforeDelete, countProductTargetAfterDelete;
    public void userClickDeleteFor(String productName){
        wait.until(ExpectedConditions.presenceOfElementLocated(bodyProductAtc));
        countingProductOnCart();
        this.countProductTargetBeforeDelete = countProductAtc;

        ArrayList<String> numberProductTargeted = new ArrayList<String>();
        for (int i=0; i< countProductAtc; i++) {
            int counter = i + 1;
            String counterProduct = Integer.toString(counter);
            String productAtc = driver.findElement(cartProduct(counterProduct)).getText();
            if (productAtc.contentEquals(productName)) {
                numberProductTargeted.add(counterProduct);
            }
        }
        String deleteTarget = numberProductTargeted.get(0);
        // System.out.println("index target to delete = " + deleteTarget); //debug
        driver.findElement(buttonDeleteProductTarget(deleteTarget)).click();
    }

    public void productIsReduceFromCart(String productName) throws InterruptedException {
        Thread.sleep(2000);
        countingProductOnCart();
        getAllProductOnChart();
        countProductTargetAfterDelete = countProductAtc;
        // System.out.println("Product Target Before : "+ countProductTargetBeforeDelete); //debug
        countingProductOnCart();
        getAllProductOnChart();
        // System.out.println("Product Target After : "+ countProductTargetAfterDelete); //debug
        int expectedCountProduct = countProductTargetBeforeDelete-1;
        Assert.assertEquals(expectedCountProduct,countProductTargetAfterDelete);
    }

    public void userHaveNoAnyProductOnCart(){
        countingProductOnCart();
        for (int i=0; i< countProductAtc; i++) {
            int counter = i + 1;
            String deleteProduct = Integer.toString(counter);
            driver.findElement(buttonDeleteProductTarget(deleteProduct)).click();
        }
    }

    public int totalPriceOnCartPage;
    public String  actualPriceOnCartPage;
    public int sumPriceProduct;

    public void getPriceOnCartPage(){
        this.actualPriceOnCartPage = driver.findElement(displayTotalPrice).getText();
        //debug// System.out.println("string price On Cart Page: " +actualPriceOnCartPage);
        //int totalPrice = Integer.parseInt(totalPriceText);
        this.totalPriceOnCartPage = Integer.parseInt(actualPriceOnCartPage);
        // debug// System.out.println("Total Price : "+totalPrice); //debug
    }


    public void sumPriceAllProduct(){
        sumPriceProduct = 0;
        for (int i=0; i< countProductAtc; i++) {
            int counter = i + 1;
            String counterProduct = Integer.toString(counter);
            String priceProductOnCartPage = driver.findElement(productPriceOnProductPage(counterProduct)).getText();
            int pricePerProduct = Integer.parseInt(priceProductOnCartPage);
            //debug// System.out.println("Price product " + counterProduct + " : "+pricePerProduct); //debug
            sumPriceProduct = sumPriceProduct + pricePerProduct;
        }
        //debug// System.out.println("Sum Price All Product: "+ sumPriceProduct); //debug
    }

    public void userAssertTotalAmountInTheCart() throws InterruptedException{
        Thread.sleep(3000);
        countingProductOnCart();
        sumPriceAllProduct();
        getPriceOnCartPage();

        Assert.assertEquals(sumPriceProduct,totalPriceOnCartPage);
    }

    public void userClickButtonPlaceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonPlaceOrder));
        driver.findElement(buttonPlaceOrder).click();
    }

}