package com.meyoung.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

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
        System.out.println(title);
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

    @Test
    public void TestGetText() throws Exception{
        driver.get(baiduUrl);
        String text = driver.findElement(By.name("tj_trnews")).getText();
        System.out.println(text);
        Assert.assertEquals(text,"新闻");
    }

    @Test
    public void TestGetTagName() throws Exception{
        driver.get(baiduUrl);
        String tagName = driver.findElement(By.id("kw")).getTagName();
        System.out.println(tagName);
        Assert.assertEquals(tagName,"input");
    }

    @Test
    public void TestGetAttribute() throws Exception{
        driver.get(baiduUrl);
        String value = driver.findElement(By.id("su")).getAttribute("value");
        System.out.println(value);
        Assert.assertEquals(value,"百度一下");
    }

    @Test
    public void TestIsDisplayed() throws Exception{
        driver.get(baiduUrl);
        boolean displayed = driver.findElement(By.id("su")).isDisplayed();
        System.out.println(displayed);
        Assert.assertTrue(displayed);
    }

    @Test
    public void TestIsSelected() throws Exception{
        driver.get("file:///C:/Users/61619/Desktop/test/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath(".//*[@id='radio']/input[1]"));
        element.click();
        boolean selected = element.isSelected();
        System.out.println(selected);
        Assert.assertTrue(selected);
    }

    @Test
    public void TestIsEnabled() throws Exception{
        driver.get("file:///C:/Users/61619/Desktop/test/selenium_html/index.html");
        WebElement element = driver.findElement(By.name("buttonhtml"));
        boolean enabled = element.isEnabled();
        System.out.println(enabled);
        Assert.assertTrue(enabled);
    }

    @Test
    public void TestScreenShot(){
        driver.get(baiduUrl);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file,new File("C:\\Users\\61619\\Desktop\\test\\screenshot1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
