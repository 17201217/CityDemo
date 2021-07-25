package com.springrain.test.thread3;

/**
 * 测试Stop
 * 1.建议线程自动停止
 * 2.建议使用标志位 --> 设置一个标志位
 * 3.不要使用stop或者destroy等过时的方法
 */
public class TestStop implements Runnable {

    // 设置一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int n = 0;
        while (flag) {
            System.out.println("运行中" + n++);
        }
    }

    // 设置一个公开的停止线程方法
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop ts = new TestStop();
        new Thread(ts).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            if (i == 500) {
                //调用自己实现的停止方法
                ts.stop();
                System.out.println("线程已停止!");
                break;
            }
        }
    }
}


