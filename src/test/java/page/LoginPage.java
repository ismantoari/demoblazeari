package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.BaseTest.driver;
import static helper.WebEndpoint.demoblaze;

public class LoginPage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By menuLogin = By.id("login2");
    By inputUsername = By.id("loginusername");
    By inputPassword = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");
    By loginCheckPoint = By.xpath("//a[@class='nav-link' and @id='login2' and @style='display: none;']");
    By textGreeting = By.xpath("//a[@id='nameofuser']");

    By popUpLoginOpen = By.xpath("//div[@class='modal fade show' and @id='logInModal']");
    By popUpLoginClose= By.xpath ("//div[@class='modal fade' and @id='logInModal']");


    public void userClickLoginMenu(){
        driver.findElement(menuLogin).click();
    }

    public void userInputLoginUsername(String username){
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void userInputLoginPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void userClickLoginButton()  throws InterruptedException {
        driver.findElement(loginButton).click();
        // Thread.sleep(2000);
    }

    public void userSeeLoginGreeting(String loginGreeting)  {
        String actualLoginGreeting = driver.findElement(textGreeting).getText();
        Assert.assertEquals(loginGreeting,actualLoginGreeting);
    }


    public void popUpLoginWillOpened(){
        boolean present;
        try {
            driver.findElement(popUpLoginOpen);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        Assert.assertTrue(present);
    }
}