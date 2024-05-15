package page;

import net.bytebuddy.asm.Advice;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import static helper.BaseTest.driver;
import static helper.WebEndpoint.demoblaze;

public class SignupPage {
    By menuSignup = By.id("signin2");
    By inputUsername = By.id("sign-username");
    By inputPassword = By.id ("sign-password");
    By buttonSignup = By.xpath("//button[text()='Sign up']");
    By buttonClose = By.xpath("(//button[text()='Sign up']/parent::*)/button[text()='Close']");
    String newUsername;

    public void userIsOnSignupForm(){
        driver.get(demoblaze);
        driver.findElement(menuSignup).click();
    }

    public void userInputNewUsername(){
        createUnixUsername();
        //debug//  System.out.println("this newUsername : " + newUsername);
        driver.findElement(inputUsername).sendKeys(newUsername);
    }
    public void createUnixUsername(){
        // generate unix username
        //String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String newUsername = "";
        String temp = RandomStringUtils.randomAlphanumeric(5); // Panjang random string 5 karakter
        newUsername = "SQA-" + temp;
        this.newUsername = newUsername;
    }

    public void userInputUsername(String userName){
        driver.findElement(inputUsername).sendKeys(userName);
    }

    public void userInputPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void userClickSignupButton(){
        driver.findElement(buttonSignup).click();
    }

    public void userClickCloseButton(){
        driver.findElement(buttonClose).click();

    }

}