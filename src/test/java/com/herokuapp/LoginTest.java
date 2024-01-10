package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void login(){
        //deschide pagina form authenticator
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);
        driver.manage().window().maximize();

        //click pe Form authenticator
        WebElement loginPage = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a"));
        loginPage.click();

        //introducere username
        WebElement username=driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("tomsmith");

        //introducere parola
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("SuperSecretPassword!");

        //click pe butonul de login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

        //login check
        WebElement success = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        Assert.assertTrue(success.isDisplayed()," You logged into a secure area!");

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
