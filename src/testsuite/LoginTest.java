package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{

    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //enter username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");

        //enter ‘password’
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //click on the ‘login’
        driver.findElement(By.tagName("button")).click();

                // Verify the text ‘Your username is invalid!’
        String expectedText = "Your username is invalid!\n" +"×";
        WebElement userNameIsInvalidAreaElement = driver.findElement(By.id("flash"));
        String actualText = userNameIsInvalidAreaElement.getText();
        Assert.assertEquals("Error varification", expectedText, actualText);
    }

    //Annotation
    @Test
    public void verifyThePasswordErrorMessage() {
        //click on the username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //click on the ‘invalid’ username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //click on the ‘login’
        driver.findElement(By.tagName("button")).click();

        //Verify the text ‘Your password is invalid!’
        String expectedText = "Your password is invalid!\n"+"x";
        WebElement yourPasswordIsInvalidElement = driver.findElement(By.id("flash"));
        String actualText = yourPasswordIsInvalidElement.getText();
        Assert.assertEquals(" ", expectedText, actualText);

    }

    @After
    public void tearDown() {
        driver.close();
    }




}
