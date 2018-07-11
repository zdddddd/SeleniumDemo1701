package com.meyoung.day3;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class TestPhantomjs {

    @Test
    public void testPhantomjs(){
       System.setProperty("phantomjs.binary.path",".\\drivers\\phantomjs.exe");
        PhantomJSDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }
}
