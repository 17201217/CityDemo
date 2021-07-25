package com.springrain.test.thread3;

/**
 * 线程礼让  yield()
 * 但不一定成功，礼让之后看cpu决定
 */
public class TestYield{

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"B").start();
        new Thread(myYield,"A").start();

    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始运行");
        //礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止结束");
    }
}


