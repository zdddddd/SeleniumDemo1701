package com.meyoung.day4;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPO {
    //示例，在page中定义好各个按钮输入框等的定位方式，用例中直接调用
       public static void login(WebDriver driver, String account, String password){
        driver.get("http://mail.163.com");
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(LoginPage.emailInput).sendKeys(account);
        driver.findElement(LoginPage.pwdInput).sendKeys(password);
        driver.findElement(LoginPage.loginButton).click();
    }

}
