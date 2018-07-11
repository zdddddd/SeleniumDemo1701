package com.meyoung.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestRobot {
    WebDriver driver;
    String testUrl = "file:///C:/Users/61619/Desktop/test/selenium_html/index.html";
    String baiduUrl="http://www.baidu.com";
    String dragUrl="file:///C:/Users/61619/Desktop/test/selenium_html/dragAndDrop.html";

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
    public void saveHtml() throws Exception{
        driver.get(baiduUrl);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);




    }
}
