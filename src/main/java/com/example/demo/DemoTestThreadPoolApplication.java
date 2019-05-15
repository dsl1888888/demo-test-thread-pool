package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTestThreadPoolApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(DemoTestThreadPoolApplication.class, args);
    }

    @Test
    public void test_fixedThreadPool()
    {
        // 1. 创建定长线程池对象 & 设置线程池线程数量固定为3
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        // 2. 创建好Runnable类线程对象 & 需执行的任务
        Runnable task = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("执行任务啦");
            }
        };

        // 3. 向线程池提交任务：execute（）
        fixedThreadPool.execute(task);

        // 4. 关闭线程池
        fixedThreadPool.shutdown();

    }

    @Test
    public void test_ScheduledThreadPool()
    {
        // 1. 创建 定时线程池对象 & 设置线程池线程数量固定为5
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        // 2. 创建好Runnable类线程对象 & 需执行的任务
        Runnable task = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("执行任务啦");
            }
        };
        // 3. 向线程池提交任务：schedule（）
        scheduledThreadPool.schedule(task, 1, TimeUnit.SECONDS); // 延迟1s后执行任务
        // scheduledThreadPool.scheduleAtFixedRate(task, 10, 1000,
        // TimeUnit.MILLISECONDS);// 延迟10ms后、每隔1000ms执行任务

        // 4. 关闭线程池
        scheduledThreadPool.shutdown();

    }

    @Test
    public void test_CachedThreadPool()
    {
        // 1. 创建可缓存线程池对象
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 2. 创建好Runnable类线程对象 & 需执行的任务
        Runnable task = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("执行任务啦");
            }
        };

        // 3. 向线程池提交任务：execute（）
        cachedThreadPool.execute(task);

        // 4. 关闭线程池
        cachedThreadPool.shutdown();

        // 当执行第二个任务时第一个任务已经完成
        // 那么会复用执行第一个任务的线程，而不用每次新建线程。

    }

    @Test
    public void test_SingleThreadExecutor()
    {
        // 1. 创建单线程化线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // 2. 创建好Runnable类线程对象 & 需执行的任务
        Runnable task = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("执行任务啦");
            }
        };

        // 3. 向线程池提交任务：execute（）
        singleThreadExecutor.execute(task);

        // 4. 关闭线程池
        singleThreadExecutor.shutdown();

    }

}
