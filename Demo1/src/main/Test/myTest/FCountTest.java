package myTest;


import com.cskaoyan.bean.FinalCount;
import com.cskaoyan.bean.Vo.FinalCountVo;
import com.cskaoyan.mapper.FinalCountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@WebAppConfiguration
public class FCountTest {

    @Autowired
    FinalCountMapper finalCountMapper;

    @Test
    public void  testDemo()
    {
//        List<FinalCount> list = finalCountMapper.selectAll();
//        System.out.println("list:"+list);
        List<FinalCountVo> list = finalCountMapper.selectByOrderId("000006");
        System.out.println("listSize:"+list.size());



    }


}
