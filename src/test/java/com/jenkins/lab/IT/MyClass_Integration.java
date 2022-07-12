package com.jenkins.lab.IT;

import com.jenkins.lab.Lock;
import com.jenkins.lab.MyClass;
import junit.framework.Assert;
import org.junit.Test;

public class MyClass_Integration {

    @Test
    public void IntegrationKeyTest(){

        MyClass myclass = new MyClass();

        myclass.setName("key");
        myclass.setId(2);
        myclass.setSecret(5);

        Lock lock = new Lock(10);
        Assert.assertEquals(true,lock.unlock(myclass.calculatorKey()));
        Assert.assertEquals(false,lock.isLocked());

        lock.lock(); //reset the lock

        myclass.setSecret(6);
        Assert.assertEquals(false,lock.unlock(myclass.calculatorKey()));
        Assert.assertEquals(true,lock.isLocked());

    }
}
