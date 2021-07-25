package com.springrain.test.message;



/**
 * 测试：生产者消费者模型-->信号灯法
 * 通过标志位解决
 */
class TestPc2 {

    public static void main(String[] args) {
        TV tv = new TV();

        new Player(tv).start();
        new Watcher(tv).start();
    }
}

/**
 * 生产者  演员
 */
class Player extends Thread {

    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("《天龙八部》");
            } else {
                this.tv.play("《快乐星球》");
            }
        }
    }
}

/**
 * 消费者  观众
 */
class Watcher extends Thread {

    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

/**
 * 产品  节目
 */
class TV {
    //演员表演，观众等待
    //观众观看，演员等待

    //表演节目
    String voice;
    //标志位
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("演员表演了：" + voice);

        //通知观众观看
        this.notifyAll();
        this.voice = voice;
        flag = !flag;
    }

    //观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了：" + voice);

        this.flag = !flag;

        //通知演员表演
        this.notifyAll();
    }
}

