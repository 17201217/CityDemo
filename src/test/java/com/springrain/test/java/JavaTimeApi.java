package com.springrain.test.java;

import com.springrain.SpringBootWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)

public class JavaTimeApi {

    @Test
    public void testLocalDataTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间： "+currentTime);
    }
}
