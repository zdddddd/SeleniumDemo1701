package com.meyoung.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestFindElement {

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
    public void TestByID() throws InterruptedException{
        driver.get(baiduUrl);
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("hahaha");
        Thread.sleep(2000);
    }

    @Test
    public void TestByName() throws InterruptedException{
        driver.get(baiduUrl);
        WebElement element = driver.findElement(By.name("wd"));
        element.sendKeys("hahaha");
        Thread.sleep(2000);
    }

    @Test
    public void TestByClass() throws InterruptedException{
        driver.get(baiduUrl);
        WebElement element = driver.findElement(By.className("s_ipt"));
        element.sendKeys("hahaha");
        Thread.sleep(2000);
    }

    @Test
    public void TestByLinkText() throws InterruptedException{
        driver.get(baiduUrl);
        WebElement element = driver.findElement(By.linkText("新闻"));
        element.click();
        Thread.sleep(2000);
    }

    @Test
    public void TestByPartialLinkText() throws InterruptedException{
        driver.get(baiduUrl);
        WebElement element = driver.findElement(By.partialLinkText("闻"));
        element.click();
        Thread.sleep(2000);
    }

    @Test
    public void TestByXPath() throws InterruptedException{
        driver.get(baiduUrl);
        WebElement element = driver.findElement(By.xpath("//*[@id='kw']"));
        element.sendKeys("hahaha");
        Thread.sleep(2000);
    }

    @Test
    public void TestByCSS() throws InterruptedException{
        driver.get(baiduUrl);
        WebElement element = driver.findElement(By.cssSelector("#kw"));
        element.sendKeys("hahaha");
        Thread.sleep(2000);
    }

    @Test
    public void TestByXPath2(){
        driver.get(baiduUrl);
        List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i = 0; i < elements.size() ; i++) {
            System.out.println(elements.get(i).getText());
        }
    }


}
