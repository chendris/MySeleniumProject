package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLogin {
    @Test
    public void loginWithInvalidUser(){
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
        username.sendKeys("tomsmith45");

        //introducere parola
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("SuperSecretPassword!");

        //click pe butonul de login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

        //login check
        WebElement invalid = driver.findElement(By.id("flash"));
        String invalidUserMsg = "Your username is invalid!";
        Assert.assertTrue(invalid.getText().contains(invalidUserMsg));
        driver.close();


    }

    @Test
    public void loginWithInvalidPswd(){
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
        password.sendKeys("SuperSecretPassword!11");

        //click pe butonul de login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

        //login check
        WebElement invalid = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String invalidUserMsg = "Your password is invalid!";
        Assert.assertTrue(invalid.getText().contains(invalidUserMsg));
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
