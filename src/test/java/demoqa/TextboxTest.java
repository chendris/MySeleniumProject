package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextboxTest {
    WebDriver driver;
    String url = "https://demoqa.com/text-box";
    @BeforeTest
    public void inainte(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void textboxTest(){

        WebElement consent = driver.findElement(By.xpath("//button[@aria-label='Consent']"));
        if(consent.isDisplayed())consent.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys("Calin Andrei");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("calinandrei@yahoo.com");

        WebElement currAdr=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currAdr.sendKeys("Cluj-Napoca Str.Dorobantilor");

        WebElement permAdr = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permAdr.sendKeys("Abrud Str.Triaian");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        js.executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();

        WebElement success = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']"));
        Assert.assertTrue(success.isDisplayed());
        driver.quit();
    }
}
