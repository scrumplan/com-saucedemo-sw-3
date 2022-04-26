package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        sendTextToElement(By.id("user-name"), "standard_user");
        //enter password
        sendTextToElement(By.id("password"), "secret_sauce");
        //click on login button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        verifyElement("Product not found", "PRODUCTS", By.xpath("//span[contains(text(),'Products')]"));


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        String expectedProduct = "six products are displayed on page ";

        sendTextToElement(By.id("user-name"), "standard_user");

        sendTextToElement(By.id("password"), "secret_sauce");

        clickOnElement(By.xpath("//input[@id='login-button']"));

        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int totalProducts = productNo.size();

        int expectedNumber = 6;
        Assert.assertEquals("Products numbers not matching", expectedNumber, totalProducts);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
