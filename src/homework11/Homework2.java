package homework11;
/*
Homework – 2
        Navigate to website "https://demo.nopcommerce.com/"
        Click on the register link.
        Fill in all the fields.
        Click on the register button.
        Verify that the user registered successfully.
*/

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework2 extends BaseTest {
    @Before
    public void start() {
        String baseUrl = "https://demo.nopcommerce.com/";
        openBrowser(baseUrl);

        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
    }
    @Test
    public void Register(){
        driver.findElement(By.xpath("//input[@id='gender-male' or @id='gender-female']")).click();
        driver.findElement((By.xpath("//input[@id='FirstName']"))).sendKeys("Ravan");
        driver.findElement((By.xpath("//input[@id='LastName']"))).sendKeys("Patel");
        driver.findElement((By.xpath("//select[@name='DateOfBirthDay']"))).sendKeys("23");
        driver.findElement((By.xpath("//select[@name='DateOfBirthMonth']"))).sendKeys("February");
        driver.findElement((By.xpath("//select[@name='DateOfBirthYear']"))).sendKeys("1940");
        driver.findElement((By.xpath("//input[@name='Email']"))).sendKeys("ravan+@google.com");// "+"sign will work as new email every time
        driver.findElement((By.xpath("//input[@id='Company']"))).sendKeys("Ayodhay");
        driver.findElement((By.xpath("//input[@id='Newsletter']"))).click();
        driver.findElement((By.xpath("//input[@id='Password']"))).sendKeys("sita123");
        driver.findElement((By.xpath("//input[@id='ConfirmPassword']"))).sendKeys("sita123");
        driver.findElement((By.xpath("//button[@id='register-button']"))).click();

        String expectedMessage = "Your registration completed";

        WebElement message = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println(message.getText());

    }
    @After
    public void finished(){

    }
}
