package com.jenkins.lab.UnitTest;

import com.jenkins.lab.MyClass;
import junit.framework.Assert;
import org.junit.Test;
public class MyClassTest {


    @Test
    public void testKey(){
        MyClass myclass =  new MyClass();

        myclass.setId(2);
        myclass.setSecret(5);
        myclass.setName("My Secret Key");

        Assert.assertEquals(myclass.calculatorKey().intValue(),10);
    }
}
