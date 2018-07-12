package com.meyoung.day3;

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

public class testLogin163Mail {
    public static WebDriver driver;
    public static String testUrl="http://mail.163.com";

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

    @Test
    public void testLoginError(){
        driver.get(testUrl);
        //进入iframe再输入账号密码
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("zd47001");
        driver.findElement(By.name("password")).sendKeys("zd888888");
        //点击登录按钮
        driver.findElement(By.id("dologin")).click();

        //等待内容出现，并获得内容
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nerror']/div[2]")));
        String text = driver.findElement(By.xpath("//*[@id='nerror']/div[2]")).getText();
        //校验
        Assert.assertEquals(text,"帐号或密码错误");
    }

    //可以把公共部分提取出来，多个用例只需要调用同一个方法即可。
    public static void login(WebDriver driver,String account,String password){
        driver.get(testUrl);
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(account);
        driver.findElement(By.name("password")).sendKeys(password);
        //点击登录按钮
        driver.findElement(By.id("dologin")).click();
    }

    @Test
    public void testSendEmail(){
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //调用登录方法
        login(driver,"zd47001","zd262115");
        //等待内容出现，并获得内容
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        //点击写信按钮
        driver.findElement(By.xpath("//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //输入收件人
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("zd47001@163.com");
        //输入主题
        driver.findElement(By.xpath("//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("testSendEmail");

        //上传附件
        driver.findElement(By.xpath("//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("C:\\Users\\61619\\Desktop\\test\\selenium_html\\index.html");

        //输入正文
        //找到iframe
        WebElement iframe = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("/html/body")).sendKeys("hahaha");

        //发送
        //退到上一层frame
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='发送'][1]")).click();

        //校验发送成功
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        boolean displayed = driver.findElement(By.xpath("//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(displayed);

    }
}

