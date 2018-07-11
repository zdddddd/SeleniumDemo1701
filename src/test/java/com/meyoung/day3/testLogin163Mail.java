package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testLogin163Mail {
    WebDriver driver;
    String testUrl="http://mail.163.com";

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
    public void testLogin163Mail(){
        driver.get(testUrl);
        //进入iframe再输入账号密码
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("zd47001");
        driver.findElement(By.name("password")).sendKeys("zd262115");
        //点击登录按钮
        driver.findElement(By.id("dologin")).click();

        //等待内容出现，并获得内容
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String text = driver.findElement(By.linkText("退出")).getText();
        //退出登录
        driver.findElement(By.linkText("退出")).click();
        //校验
        Assert.assertEquals(text,"退出");
    }
}

