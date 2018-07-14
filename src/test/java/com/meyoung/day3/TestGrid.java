package com.meyoung.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;

public class TestGrid {

    @Test
    public void testChrome() throws Exception{
        //实例化DesiredCapabilities 类
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.28:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testFail() throws Exception{
        //实例化DesiredCapabilities 类
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.28:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        driver.quit();
        Assert.assertTrue(false);
    }



    @DataProvider(name="data1")
    public Object [][] test1(){
        return new Object[][]{
                {"http://192.168.1.28:5555","firefox"},
                {"http://192.168.1.28:6666","chrome"}
        };
    }

    @Test(dataProvider = "data1")
    public void testGird2(String nodeUrl,String browser)throws Exception{
        DesiredCapabilities dc = null;
        if(browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else if(browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            System.err.println("error");
        }

        WebDriver driver = new RemoteWebDriver(new URL(nodeUrl+"/wd/hub"),dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        driver.quit();
    }
}
