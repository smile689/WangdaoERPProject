package com.cskaoyan;

import com.cskaoyan.service.CorderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
//如果web里配置了静态资源的路径resources，那么要加webAppConfiguration不然报错
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class MyServiceTest {

    @Autowired
    CorderService corderService;


    @Test
    public void testSelectOrderById(){
        System.out.println(corderService.findOrderById("000001"));
    }
}
