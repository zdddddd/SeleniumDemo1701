package com.meyoung.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {

    @Test
    public void testCase1(){
        System.out.println("@Test testCase1");
    }

    @Test
    public void testCase2(){
        System.out.println("@Test testCase2");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("@BeforeMethod BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("@AfterMethod AfterMethod");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("@AfterTest AfterTest");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("@BeforeTest BeforeTest");
    }

}
