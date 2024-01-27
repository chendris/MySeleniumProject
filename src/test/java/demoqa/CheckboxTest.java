package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxTest {

    WebDriver driver;
    String url = "https://demoqa.com/checkbox";

    @BeforeTest
    public void setup(){
        driver=new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void checkbox(){
        WebElement expand = driver.findElement(By.xpath("//button[@title='Expand all']"));
        expand.click();

        WebElement checkBox = driver.findElement(By.xpath("//label[contains(.,'Commands')]"));
        checkBox.click();

        WebElement isChecked = driver.findElement(By.xpath("//span[@class='text-success']"));

        Assert.assertTrue(isChecked.getText().contains("commands"));
        driver.quit();
    }
}
