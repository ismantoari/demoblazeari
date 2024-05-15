package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.BaseTest.driver;

public class PlaceOrderPage {

    By placeOrderFormAppear = By.xpath("//div[@class='modal fade show']");

    By inputName = By.id("name");
    By inputCountry = By.id("country");
    By inputCity = By.id("city");
    By inputCc = By.id("card");
    By inputMonth = By.id("month");
    By inputYear = By.id("year");
    By buttonPurchase = By.xpath("//button[text()='Purchase']");
    By buttonClose = By.xpath("//div[@class='modal fade show']/descendant::button[text()='Close']");

    public String globalName, globalCardNumber;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void assertAppearPlaceOrderPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(placeOrderFormAppear));
        Assert.assertTrue(driver.findElement(placeOrderFormAppear).isDisplayed());
    }

    public void userInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
        this.globalName = name;

    }

    public void userInputCountry(String country) {
        driver.findElement(inputCountry).sendKeys(country);
    }

    public void userInputCity(String city) {
        driver.findElement(inputCity).sendKeys(city);
    }

    public void userInputCreditCard(String cc) {
        driver.findElement(inputCc).sendKeys(cc);
        this.globalCardNumber = cc;
    }

    public void userInputMonth(String month) {
        driver.findElement(inputMonth).sendKeys(month);
    }

    public void userInputYear(String year) {
        driver.findElement(inputYear).sendKeys(year);
    }

    public void userClickButtonPurchaseOnPlaceOrderForm() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonPurchase));
        driver.findElement(buttonPurchase).click();
    }

    public void userClickButtonCloseOnPlaceOrderForm() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonClose));
        driver.findElement(buttonClose).click();
    }

    public void formPlaceOrderIsClosed() {
        try {
            WebElement PlaceOrderForm = driver.findElement(placeOrderFormAppear);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }
}