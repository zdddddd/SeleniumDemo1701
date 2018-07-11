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

import java.util.Set;

public class TestRegister163Mail {
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
    public void testRegister(){
        driver.get(testUrl);
        //进入iframe再点击注册按钮
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.id("changepage")).click();
        //进入到新打开的窗口
        String currentHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for(String handle:allHandles){
            if(currentHandle.equals(handle)){
                continue;
            }else {
                driver.switchTo().window(handle);
            }
        }
        //输入注册信息
        //用时间戳自动生成不同的账号
        String timeMillis = String.valueOf(System.currentTimeMillis());
        driver.findElement(By.id("nameIpt")).sendKeys("test"+timeMillis);
        //driver.findElement(By.id("nameIpt")).sendKeys("test163333333");
        driver.findElement(By.id("mainPwdIpt")).sendKeys("test163");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("test163");
        driver.findElement(By.id("mainMobileIpt")).sendKeys("16316316316");
        driver.findElement(By.id("vcodeIpt")).sendKeys("test163");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("test163");
        //点击注册按钮
        driver.findElement(By.id("mainRegA")).click();
        //等待内容出现，并获得，校验内容
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='m_mainAcode']/span")));
        String text = driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span")).getText();
        Assert.assertEquals(text,"  手机验证码不正确，请重新填写");


    }
}
