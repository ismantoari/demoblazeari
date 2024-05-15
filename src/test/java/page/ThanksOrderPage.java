package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.BaseTest.driver;



public class ThanksOrderPage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    By placeThanksGreeting = By.xpath("//h2[text()='Thank you for your purchase!']");
    By buttonOk = By.xpath("//button[text()='OK']");
    By selectTextOnThanksPage = By.xpath("//p [text()[contains(.,'Amount:')]]");


    public void textThanksGreeting (String thanksGreeting){

        String actualThanksGreeting = driver.findElement(placeThanksGreeting).getText();
        System.out.println("text : " + actualThanksGreeting);
        Assert.assertEquals(thanksGreeting, actualThanksGreeting);
    }

    public void clickButtonOk(){
        driver.findElement(buttonOk).click();
    }

    public String textOnThanksPage, actualCardNumber, actualName;

    public void getTextOnThanksPage(){
        this.textOnThanksPage = driver.findElement(selectTextOnThanksPage).getText();
        //System.out.println("text on thanks page : " + textOnThanksPage);
    }

    public void getCardNumberOnThanksPage(){
        getTextOnThanksPage();
        String[] manageTextOnThanksPage = textOnThanksPage.split("Card Number:");
        String manageTextOnTextPage2 = manageTextOnThanksPage[1];
        String[] displayCardNumber = manageTextOnTextPage2.split("Name:");
        this.actualCardNumber = displayCardNumber[0].replaceAll("[^\\d]", "");
        //System.out.println("actual card number : "+actualCardNumber);
    }

    public void getNameOnThanksPage(){
        getTextOnThanksPage();
        //debug//System.out.println("text on thanks page GET NAME: " + textOnThanksPage);

        String[] manage2TextOnThanksPage = textOnThanksPage.split("Name:");
        String manage2TextOnTextPage2 = manage2TextOnThanksPage[1];
        //debug//System.out.println("Hasil Split : " + manage2TextOnTextPage2);

        String[] displayName = manage2TextOnTextPage2.split("Date:");
        //debug// System.out.println("display name [0] : " + displayName[0]);
        this.actualName = displayName[0].replaceAll(" ", "");
        this.actualName = actualName.replaceAll("\\r", "");
        this.actualName = actualName.replaceAll("\\n","");

    }
    public void assertDataNameAndCreditCard(String name, String cardNumber){
        getNameOnThanksPage();
        //debug//  System.out.println("actual name : "+actualName);
        String expectedName = name.replaceAll(" ", "");
        Assert.assertEquals(expectedName,actualName);

        getCardNumberOnThanksPage();
        //debug // System.out.println("actual card number : "+actualCardNumber);
        String expectedCardNumber = cardNumber.replaceAll("[^\\d]", "");;
        Assert.assertEquals(expectedCardNumber,actualCardNumber);

    }

    By popUpThanksGreeting = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");
    public void popUpThanksPageIsClose(){
        boolean present;
        try {
            driver.findElement(popUpThanksGreeting);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        Assert.assertFalse(present);
    }

    // WebElement popUpThanksText = driver.findElement(popUpThanksGreeting);



}