package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestWait {
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
    public void testWait() throws InterruptedException {
        driver.get(testUrl);
        driver.findElement(By.className("wait")).click();
        //找元素，找10秒，10秒还没找到，就报错
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        String red = driver.findElement(By.className("red")).getText();
        System.out.println(red);
        Assert.assertEquals(red,"wait for display");
    }

    @Test
    public void testWait2() throws InterruptedException {
        driver.get(testUrl);
        driver.findElement(By.className("wait")).click();

        //比上一个全局等待更智能
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.className("red")));

        String red = driver.findElement(By.className("red")).getText();
        System.out.println(red);
        Assert.assertEquals(red,"wait for display");
    }
}
