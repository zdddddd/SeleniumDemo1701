package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCloseBroswer {

    @Test
    public void closeChrome() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\61619\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        Thread.sleep(5000);
        chromeDriver.close();
    }

    @Test
    public void closeChrome1() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\61619\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        Thread.sleep(5000);
        chromeDriver.quit();
    }



}


