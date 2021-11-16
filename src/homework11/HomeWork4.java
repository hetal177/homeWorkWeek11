package homework11;
/*
https://opensource-demo.orangehrmlive.com/
        ( Username : Admin | Password : admin123 )
        Enter username
        Enter password
        Click login
        Verify that the text “Welcome Paul”
        After Paul one symbol there so click on the symbol for logout.
        Verify the below text.
        LOGIN Panel
*/


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeWork4 extends BaseTest  {
    @Before
    public void start() {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        openBrowser(baseUrl);

    }
    @Test
    public void Login(){
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        driver.findElement(By.xpath("//a[@id='welcome']")).click();

      String expectedMessage = "Welcome paul";



       WebElement messsage= driver.findElement(By.partialLinkText("Welcome"));
        System.out.println(messsage);
        if(messsage.equals("Welcome paul")){
            System.out.println("Welcome paul- correct title");
        }
        else{
            System.out.println("In-correct message");
        }
        //WebElement message = driver.findElement(By.xpath("//a[@id='welcome']"));

       driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
      //  driver.findElement(By.xpath("//div[@id='logInPanelHeading']"));

        String expectedMessage1 = "LOGIN Panel";

     WebElement message1 = driver.findElement(By.xpath("//div[@id='logInPanelHeading']"));
      //  WebElement message1 = driver.findElement(By.xpath("//font[text()='LOGIN Panel']"));

        String actualMessage1 = message1.getText();
        Assert.assertEquals(expectedMessage1, actualMessage1);
        System.out.println(message1.getText());


    }
}

