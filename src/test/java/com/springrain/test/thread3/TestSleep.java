package com.springrain.test.thread3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程休眠
 * sleep()不会释放锁
 */
public class TestSleep implements Runnable{
    @Override
    public void run() {
        // 获取当前系统时间
        Date date = new Date(System.currentTimeMillis());
        while(true) {
            // 格式化时间并输出
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            // 更新时间
            date = new Date(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep).start();
    }

}

