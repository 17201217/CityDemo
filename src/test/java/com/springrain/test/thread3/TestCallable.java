package com.springrain.test.thread3;

import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("实现Callable接口线程");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable   c1 = new TestCallable();
        TestCallable   c2 = new TestCallable();
        TestCallable   c3 = new TestCallable();

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> result1 = service.submit(c1);
        Future<Boolean> result2 = service.submit(c2);
        Future<Boolean> result3 = service.submit(c3);

        //获取结果
        Boolean re1 = result1.get();
        Boolean re2 = result2.get();
        Boolean re3 = result3.get();

        //关闭服务
        service.shutdown();

    }
}
