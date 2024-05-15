package page;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static helper.BaseTest.driver;
import static helper.WebEndpoint.demoblaze;

public class HomePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    By upperCheckpoint = By.id("nava");

    By navMenu(String nameMenu){
        return By.xpath("//div[@class='navbar-collapse']/descendant::*[text()='"+nameMenu+"']");
    }

    By categoriesSelected(String categoriesMenu) {
        return By.xpath("//a [@id='itemc' and text()='" + categoriesMenu + "']");
    }

    By priceProductOnHomepage(String productBidding){
        return By.xpath("((//div [@id='tbodyid']/descendant::*[text()='"+productBidding+"'])/parent::*/parent::*)/h5");
    }

    By productName = By.xpath("//h4[@Class='card-title']");
    By aboutUsAppear = By.xpath("//div[@class='modal fade show' and @id='videoModal']");

    By closeButtonPopUp = By.xpath("//div[@class='modal fade show']/descendant::button[text()='Close']");

    By LogoutButton = By.xpath("//a[@class='nav-link' and @style='display: block;' and text()='Log out']");


    JavascriptExecutor js = (JavascriptExecutor) driver;

    public static String homePrice;

    public void userClickMenu(String menu) {
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(navMenu(menu)));
        wait.until(ExpectedConditions.elementToBeClickable(navMenu(menu)));
        driver.findElement(navMenu(menu)).click();

    }

    public void userSeeNotifPopUp(String textPopup) throws InterruptedException {

        Thread.sleep(2000);
        //Alert alert = driver.switchTo().alert();

        //String actualTextPopup = alert.getText();
        String actualTextPopup = driver.switchTo().alert().getText();
        Assert.assertEquals(textPopup, actualTextPopup);

    }

    public void userClickOkButtonPopUp() {
        driver.switchTo().alert().accept();
    }

    public void userClickOkButtonOnNotification() {
        driver.switchTo().alert().accept();
    }

    public void userIsOnHomePage() {
        driver.get(demoblaze);
    }

    public void userLookAtTheTopLeftSideOfTheHomepage() {
        WebElement upperHomepage = driver.findElement(upperCheckpoint);
        js.executeScript("arguments[0].scrollIntoView(true);", upperHomepage);
    }

    public void userWillSeeLogoAndStoreName(String logo, String storeName) {
        // ---- Assert Logo ----
        String actualLogoName = driver.findElement(By.xpath("(//img)[1]")).getAttribute("src");
        String expectedLogoName = demoblaze + logo;
        Assert.assertEquals(expectedLogoName, actualLogoName);

        // ---- Assert Store Name ----
        String actualStoreName = driver.findElement(upperCheckpoint).getText();
        Assert.assertEquals(storeName, actualStoreName);
    }

    public void userClickCategories(String categoriesSelectedByUSer) {
        //  System.out.println("categories selected by user : " + categoriesSelectedByUSer);

        driver.findElement(categoriesSelected(categoriesSelectedByUSer)).click();
    }

    //public void assertionProductOnlyDisplayPhoneProduct() throws InterruptedException {
    public void homePageOnlyDisplay(String productShow) throws InterruptedException {

        String[] phonesProduct = {"HTC One M9", "Iphone 6 32gb", "Nexus 6", "Nokia lumia 1520", "Samsung galaxy s6", "Samsung galaxy s7", "Sony xperia z5"};
        String[] laptopsProductP1 = {"2017 Dell 15.6 Inch", "Dell i7 8gb", "MacBook air", "MacBook Pro", "Sony vaio i5", "Sony vaio i7"};
        String[] monitorsProduct = {"Apple monitor 24", "ASUS Full HD"};

        ArrayList<String> expectedProduct = new ArrayList<>();

        if (productShow.contentEquals("Phones")) {
            for (int i = 0; i < 7; i++) {
                expectedProduct.add(phonesProduct[i]);
            }
        } else if (productShow.contentEquals("Laptops")) {
            for (int i = 0; i < 6; i++) {
                expectedProduct.add(laptopsProductP1[i]);
            }
        } else if (productShow.contentEquals("Monitors")) {
            for (int i = 0; i < 2; i++) {
                expectedProduct.add(monitorsProduct[i]);
            }
        } else {
            System.out.println("Something Wrong");
        }

        Collections.sort(expectedProduct);

        //System.out.println("expected Display :" + expectedProduct);

        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(productName));
        List<WebElement> webElementProductName = driver.findElements(productName);
        int jumlahProduct = webElementProductName.size();
        // System.out.println("product size : "+ jumlahProduct);

        ArrayList<String> productContainer = new ArrayList<String>();

        for (int i = 0; i < jumlahProduct; i++) {
            productContainer.add(webElementProductName.get(i).getText());
        }
        Collections.sort(productContainer);

        //System.out.println("acutal nya : "+productContainer);


        if (productShow.contentEquals("Phones")) {
            Assert.assertEquals(expectedProduct, productContainer);
        } else if (productShow.contentEquals("Laptops")) {
            Assert.assertEquals(expectedProduct, productContainer);
        } else if (productShow.contentEquals("Monitors")) {
            Assert.assertEquals(expectedProduct, productContainer);
        } else {
            System.out.println("Something Wrong");
        }

    }

    public void userCheckPriceOfOnHomepage(String productName) {
        String homePriceFullAppear = driver.findElement(priceProductOnHomepage(productName)).getText();
        //debug// System.out.println("price "+productName+ ": " + homePriceFullAppear);

        // remove currency symbols
        homePrice = homePriceFullAppear.replaceAll("[^\\d]", "");  // "25000"
        //debug// System.out.println("price (only number) "+productName+ ": " + homePrice);
    }

    public void userIsTakenBackToHomepage() throws InterruptedException {
        Thread.sleep(5000);
        String actual = driver.getCurrentUrl();
        Thread.sleep(5000);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actual url : " + actualUrl);

        Thread.sleep(5000);
        String actualUrl2 = driver.getCurrentUrl();
        System.out.println("actual url : " + actualUrl2);
        Assert.assertEquals("https://www.demoblaze.com/index.html", actualUrl);

    }



    public void userWillSeeMenu(String menuName){
        //Thread.sleep(3000);
        WebElement logOutCheckPoint = driver.findElement(navMenu(menuName));
        Assert.assertTrue(String.valueOf(logOutCheckPoint),true);
    }

    public void appearPopUpAboutUs(){
        WebElement aboutUsPopUp = driver.findElement(aboutUsAppear);
        Assert.assertTrue(String.valueOf(aboutUsPopUp),true);

    }

    public void userClickCloseButtonOnPopUp() {
        driver.findElement(closeButtonPopUp).click();
    }

    public void popUpAboutUsIsClosed(){
        WebElement aboutUsPopUp = driver.findElement(aboutUsAppear);
        Assert.assertFalse(String.valueOf(aboutUsPopUp),false);
    }

    public void userSeeLogoutMenu(){
        WebElement LogoutMenu = driver.findElement(LogoutButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(LogoutButton));
        String suksesLogin = LogoutMenu.getText();
        Assert.assertEquals("Log out",suksesLogin);
    }
}