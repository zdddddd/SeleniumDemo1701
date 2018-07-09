package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngDemo2 {

    public static String a ="aaa";
    public static String b = "bbb";
    public static String c="aaa";
    public static String d;

    @Test
    public void testAssertEquals1(){
        Assert.assertEquals(a,b);
    }
    @Test
    public void testAssertEquals2(){
        Assert.assertEquals(a,c);
    }

    @Test
    public void testAssertNotEquals1(){
        Assert.assertNotEquals(a,b);
    }
    @Test
    public void testAssertNotEquals2(){
        Assert.assertNotEquals(a,c);
    }

    @Test
    public void testAssertNotNull1(){
        Assert.assertNotNull(a);
    }
    @Test
    public void testAssertNotNull2(){
        Assert.assertNotNull(d);
    }

    @Test
    public void testAssertNull1(){
        Assert.assertNull(a);
    }
    @Test
    public void testAssertNull2(){
        Assert.assertNull(d);
    }
}
