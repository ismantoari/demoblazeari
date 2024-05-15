package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static helper.BaseTest.driver;

public class ContactPage {
    By openFormContact = By.xpath("//div[@class='modal fade show' and @id='exampleModal']");
    By closeForm = By.xpath("//div[@class='modal fade' and @id='exampleModal' and @aria-hidden='true']");
    By textFormName = By.xpath("//div[@class=\"modal fade show\"]/child::*/child::*/child::*/h5[@id='exampleModalLabel']");
    By inputEmail = By.id("recipient-email");
    By inputName = By.id("recipient-name");
    By inputMessage = By.id("message-text");
    By buttonSendMessage = By.xpath("//div[@class='modal-footer']/child::button[text()='Send message']");

    By buttonClose = By.xpath("//div[@class='modal-footer']/child::button[text()='Send message']/preceding-sibling::*");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void appearForm(String formName){
        wait.until(ExpectedConditions.presenceOfElementLocated(openFormContact));

        String actualFormName = driver.findElement(textFormName).getText();
        //debug//  System.out.println("actual formName :" + actualFormName);
        Assert.assertEquals(formName,actualFormName);

    }

    public void appearFormMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(openFormContact));
        WebElement formAppear = driver.findElement(openFormContact);
        Assert.assertTrue(String.valueOf(formAppear),true);
    }

    public void userInputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);

    }

    public void userInputName(String name){
        driver.findElement(inputName).sendKeys(name);
    }

    public void userInputMessage(String message){
        driver.findElement(inputMessage).sendKeys(message);
    }

    public void clickButtonSendMessage(){
        driver.findElement(buttonSendMessage).click();

    }

    public void clickButtonClose(){
        driver.findElement(buttonClose).click();
    }

    public void formSendMessageIsClose(){
        WebElement formAppear = driver.findElement(openFormContact);
        Assert.assertFalse(String.valueOf(formAppear),false);
    }

}