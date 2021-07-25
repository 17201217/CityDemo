package com.springrain.test.message;


/**
 * 测试：生产者消费者模型-->管城法
 * 生产者
 * 消费者
 * 产品
 * 缓冲区
 */
public class TestPC {

    public static void main(String[] args) {
        //创建容器
        SynContainer synContainer = new SynContainer();

        //创建生产者
        new Producer(synContainer).start();
        //创建消费者
        new Consumer(synContainer).start();
    }
}

/**
 * 生产者
 */
class Producer extends Thread {

    //容器
    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    /*
        生产者生产
     */
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了" + i + "鸡");
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {

    //容器
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    /*
        消费者消费
     */
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("消费了第" + synContainer.pop().id + "只鸡");
        }
    }
}

/**
 * 产品
 */
class Chicken {
    int id = 0;

    public Chicken(int id) {
        this.id = id;
    }
}

/**
 * 缓冲区 容器
 */
class SynContainer {

    //定义一个容器
    Chicken[] chickens = new Chicken[10];

    //容器计数器
    int count = 0;

    //把产品放入容器
    public synchronized void push(Chicken chicken) {
        //如果容器满了，就等待
        if (chickens.length == count) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果容器没满，就生产
        chickens[count++] = chicken;

        //唤醒消费者
        this.notifyAll();
    }

    //从容器取出产品
    public synchronized Chicken pop() {
        //判断容器是否有产品
        if (count == 0) {
            try {
                //等待生产者生产
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //有产品就消费
        Chicken chicken = chickens[--count];

        //产品消费完了，唤醒生产者
        this.notifyAll();
        return chicken;
    }
}




