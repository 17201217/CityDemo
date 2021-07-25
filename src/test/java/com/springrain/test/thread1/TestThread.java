package com.springrain.test.thread1;

public class TestThread extends Thread{

    @Override
    public void run() {
        System.out.println("继承Thread的线程");
    }

    public static void main(String[] args) {
        TestThread tt = new TestThread();
        tt.start();
    }
}
