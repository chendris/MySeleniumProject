package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadiobuttonTest {

    WebDriver driver;
    String url = "https://demoqa.com/radio-button";

    @BeforeTest
    public void inainte(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void radio(){

        WebElement consent = driver.findElement(By.xpath("//button[@aria-label='Consent']"));
        if(consent.isDisplayed())consent.click();

        WebElement radioYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioYes.click();

        WebElement success = driver.findElement(By.xpath("//span[@class='text-success']"));
        Assert.assertTrue(success.getText().contains("Yes"));
        driver.quit();
    }
}
