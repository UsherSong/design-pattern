package com.gupaoedu.user;

import static org.junit.Assert.assertTrue;

import com.gupaoedu.user.services.ThreadTest;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.applet.Main;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    public static void main(String[] args){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("service-test.xml");
        ThreadTest threadTest = (ThreadTest)ctx.getBean("threadTest");
        threadTest.test();

    }
}
