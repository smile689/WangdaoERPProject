package com.cskaoyan;

import com.cskaoyan.bean.Corder;
import com.cskaoyan.mapper.CorderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyMapperTest {

    @Autowired
    CorderMapper cOrderMapper;

    @Test
    public void testSelectById(){
        Corder cOrder = cOrderMapper.selectByPrimaryKey("000001");
        System.out.println(cOrder);
    }
}
