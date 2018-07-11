package com.meyoung.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestJS {

    WebDriver driver;
    String testUrl = "file:///C:/Users/61619/Desktop/test/selenium_html/index.html";
    String baiduUrl="http://www.baidu.com";

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
    public void testJS() throws InterruptedException {
        driver.get(baiduUrl);
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"selenium\")");
        Thread.sleep(5000);
    }
}
