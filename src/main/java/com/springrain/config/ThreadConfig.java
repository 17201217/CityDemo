package com.springrain.config;

import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

//public class ThreadConfig implements AsyncConfigurer {
//
//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(20);//核心线程数目
//        executor.setMaxPoolSize(Integer.MAX_VALUE);//最大线程数目
//        executor.setQueueCapacity(20);//队列中最大的数目
//        executor.initialize();
//        return executor;
//    }
//}
