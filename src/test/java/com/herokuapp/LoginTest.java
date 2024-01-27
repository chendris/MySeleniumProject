package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    String url="https://the-internet.herokuapp.com/";
    @BeforeTest
    public void inainte(){
        //deschide pagina form authenticator
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }
    @Test
    @Parameters ({"usernameP","passwordP","successP"})
    public void login(String usernameP, String passwordP, String successP){
        inainte();

        //click pe Form authenticator
        WebElement loginPage = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a"));
        loginPage.click();

        //introducere username
        WebElement username=driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys(usernameP);

        //introducere parola
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys(passwordP);

        //click pe butonul de login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

        //login check
        WebElement success = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4"));
        Assert.assertEquals(success.getText(),successP);
        driver.close();
    }
    public static void sleep(int millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
