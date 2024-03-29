package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutTest {
    @Test
    @Parameters({"usernameP","passwordP","successP"})
    public void logout(String usernameP, String paswordP,String successP){
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
        username.sendKeys(usernameP);

        //introducere parola
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys(paswordP);

        //click pe butonul de login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

        //login check
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        logoutButton.click();

        WebElement logout = driver.findElement(By.xpath("/html/body/div[1]/div/div"));
        Assert.assertTrue(logout.getText().contains(successP));
        driver.close();

    }



}
