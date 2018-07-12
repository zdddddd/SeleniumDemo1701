package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class TestOpenBrowser {

    @Test
    public void OpenFirefox(){
        WebDriver firefoxDriver = new FirefoxDriver();
        //链接需要写上http
        firefoxDriver.get("http://www.baidu.com");
        firefoxDriver.quit();
    }

    @Test
    public void OpenFirefox1(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void OpenChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\61619\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        //链接需要写上http
        chromeDriver.navigate().to("http://www.baidu.com");
        chromeDriver.quit();
    }

    @Test
    public void OpenIE(){
        System.setProperty("webdriver.ie.driver","C:\\Users\\61619\\IdeaProjects\\SeleniumDemo1701\\drivers\\IEDriverServer.exe");
        WebDriver ieDriver = new InternetExplorerDriver();
    }

    @Test
    public void OpenEdge(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\61619\\IdeaProjects\\SeleniumDemo1701\\drivers\\MicrosoftWebDriver.exe");
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("http://www.baidu.com");
        edgeDriver.quit();
    }

}
