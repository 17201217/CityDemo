package com.springrain.test.thread2;

import com.springrain.SpringBootWebApplication;
import com.springrain.config.GetBeanUtil;
import com.springrain.entity.AreaCode;
import com.springrain.service.AreaCodeService;
import com.springrain.util.AreaCodeConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
public class TestThread2 implements Runnable, AreaCodeConstant {

    @Autowired
    private AreaCodeService areaCodeService2;



    @Test
    public void test2(){
        System.out.println(areaCodeService2);
        List<AreaCode> cityVOsList = areaCodeService2.getAllAreaCodes(SECOND_CONDITION);
        cityVOsList.forEach(item -> {
            System.out.println(item);
        });
    }

    @Override
    public void run() {
        AreaCodeService areaCodeService = (AreaCodeService) GetBeanUtil.getBean("areaCodeServiceImpl");
        System.out.println(areaCodeService);

        areaCodeService.test();
        List<AreaCode> cityVOsList = areaCodeService.getAllAreaCodes(FIRST_CONDITION);
        System.out.println(cityVOsList.size());
        cityVOsList.forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void testMul() {
        TestThread2 tr = new TestThread2();
        Thread thread = new Thread(tr);
        tr.run();
        thread.start();

        TestThread2 tr2 = new TestThread2();
        Thread thread2 = new Thread(tr2);
        tr2.run();
        thread2.start();
    }

    public static void test() {
        System.out.println("hello");
    }
}
