package com.meyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAlert {
    WebDriver driver;
    String testUrl = "file:///C:/Users/61619/Desktop/test/selenium_html/index.html";

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\61619\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testAlert() throws Exception{
        driver.get(testUrl);
        driver.findElement(By.className("alert")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Thread.sleep(2000);
        alert.accept();
    }

    @Test
    public void testConfirm() throws Exception{
        driver.get(testUrl);
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Thread.sleep(2000);
        alert.dismiss();
        Thread.sleep(2000);
        alert.accept();
    }

    @Test
    public void testPrompt() throws Exception{
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver1 = new FirefoxDriver();
        driver1.get(testUrl);
        driver1.findElement(By.className("prompt")).click();
        Thread.sleep(2000);
        Alert alert = driver1.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.sendKeys("hahaha");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        alert.accept();
        driver1.close();
    }
}
