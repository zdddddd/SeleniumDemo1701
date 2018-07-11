package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestActions2 {
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

    /**
     * 在按钮上右击
     */
    @Test
    public void TestRightClick(){
        driver.get(baiduUrl);
        WebElement su = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.contextClick(su).perform();
    }

    /**
     * 在按钮上双击
     */
    @Test
    public void TestDoubleClick(){
        driver.get(baiduUrl);
        WebElement su = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(su).perform();
    }

    /**
     * 鼠标移动到某个按钮上
     */
    @Test
    public void TestMoveToElement(){
        driver.get(testUrl);
        WebElement element = driver.findElement(By.className("over"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //System.out.println(driver.findElement(By.xpath("//*[text()='Hello World!']")).getText());
    }

    /**
     * 把XX拖动到（x，y）
     */
    @Test
    public void TestDragAndDrop(){
        driver.get(dragUrl);
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
    }

    /**
     * 把XX拖动到另一个元素
     */
    @Test
    public void TestDragAndDrop2(){
        driver.get(dragUrl);
        WebElement element1 = driver.findElement(By.id("drag"));
        WebElement element2 = driver.findElement(By.tagName("h1"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(element1).moveToElement(element2).release(element2).perform();
    }

    /**
     * 下拉框多选
     */
    @Test
    public void TestMoreSelect(){
        driver.get(testUrl);
        WebElement select = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(options.get(1)).click(options.get(3)).keyUp(Keys.CONTROL).build().perform();
    }
}
