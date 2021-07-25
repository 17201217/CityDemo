package com.springrain.test.thread4;

/**
 * 多个线程操作同一个对象
 * 例如 ： 买票
 */
public class TestRunnable2 implements Runnable {

    //票
    private Integer k = 20;

    //标识位
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            //模拟网络延时 毫秒
            //放大问题的发生性
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //买票
            this.buy();
        }
    }

    // 锁的是this
    public synchronized void buy() {
        if (k <= 0) {
            flag = false;
            return;
        }
        // Thread.currentThread().getName()获取线程名字
        System.out.println(Thread.currentThread().getName() + "买到了第" + k-- + "张票");
    }

    public static void main(String[] args) {
        TestRunnable2 tr = new TestRunnable2();

        new Thread(tr, "小明").start();
        new Thread(tr, "李四").start();
        new Thread(tr, "张三").start();

    }
}

