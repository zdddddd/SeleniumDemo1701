package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAction {
    WebDriver driver;
    String baiduUrl = "http://www.baidu.com";

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\61619\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void TestClick() throws Exception{
        driver.get(baiduUrl);
        driver.findElement(By.linkText("新闻")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"http://news.baidu.com/");
    }

    @Test
    public void TestSendkeys() throws Exception{
        driver.get(baiduUrl);
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    @Test
    public void TestClear() throws Exception{
        driver.get(baiduUrl);
        driver.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(2000);
        driver.findElement(By.id("kw")).clear();
        Thread.sleep(2000);
    }


}
