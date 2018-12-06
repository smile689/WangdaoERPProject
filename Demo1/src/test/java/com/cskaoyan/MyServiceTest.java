package com.cskaoyan;

import com.cskaoyan.service.CorderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyServiceTest {

    @Autowired
    CorderService corderService;


    @Test
    public void testSelectOrderById(){
        System.out.println(corderService.findOrderById("000001"));
    }
}
