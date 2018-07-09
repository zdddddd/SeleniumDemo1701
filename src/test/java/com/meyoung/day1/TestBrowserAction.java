package com.meyoung.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBrowserAction {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\61619\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testGet() throws InterruptedException{
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
    }

    @Test
    public void testGet2() throws InterruptedException{
        driver.navigate().to("http://www.baidu.com");
        Thread.sleep(3000);
    }

    @Test
    public void testBack() throws InterruptedException{
        driver.navigate().to("http://www.baidu.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test
    public void testForward() throws InterruptedException{
        driver.navigate().to("http://www.baidu.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
    }

    @Test
    public void testRefresh() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }

    @Test
    public void testMaxmize() throws InterruptedException{
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void testSetSize() throws InterruptedException{
        Dimension dimension = new Dimension(300, 300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(2000);
    }

    @Test
    public void testGetCurrentURL(){
        driver.get("http://www.baidu.com");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://www.baidu.com/");
        System.out.println(currentUrl);
    }

    @Test
    public void testGetTitle(){
        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
