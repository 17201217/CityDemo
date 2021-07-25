package com.springrain.test.thread3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main开始");
        MyThread0 mt = new MyThread0();
        Thread thread = new Thread(mt, "子线程A");
        thread.start();
        thread.join();
        System.out.println("main结束");
    }

    public static void printTime() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        System.out.println(time);
    }
}

class MyThread0 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("主线程睡眠前的时间");
            TestJoin.printTime();
            Thread.sleep(2000);
            System.out.println("主线程睡眠结束的时间");
            TestJoin.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
