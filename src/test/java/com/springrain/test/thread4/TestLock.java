package com.springrain.test.thread4;

import java.util.concurrent.locks.ReentrantLock;




/**
 * 测试Lock锁
 * 显式的定义锁和解锁
 * 1.Lock是显式锁(手动开启和关闭锁) synchronized是隐式锁，出了作用域自动释放
 * 2.Lock只有代码块锁,synchronized有代码块锁和方法锁
 * 3.使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性(提供更多的子类)
 *
 *
 *
 *
 */
public class TestLock {

    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {

    private int ticket = 20;
    // 定义Lock锁 它拥有与synchronized相同的并发性和内存语义，在实现线程安全的控制中，比较常用的是ReentrantLock，可以显式加锁、释放锁。
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //加锁
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("票剩余" + ticket--);
                } else break;
            } finally {
                //解锁
                lock.unlock();
            }

        }
    }
}


