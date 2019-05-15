package com.example.demo.opt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

public class ThreadCondition implements Runnable
{

    private static int count = 0;

    @Test
    public void testThreadPool()
    {
        Runtime run = Runtime.getRuntime();// 当前程序运行对象
        run.gc();// 调用垃圾回收机制，减少内存误差
        Long freememroy = run.freeMemory();// 获取当前空闲内存
        Long protime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++)
        {
            new Thread(new ThreadCondition()).start();
        }
        System.out.println("独立创建" + 10000 + "个线程需要的内存空间" + (freememroy - run.freeMemory()));
        System.out.println("独立创建" + 10000 + "个线程需要的系统时间" + (System.currentTimeMillis() - protime));

        System.out.println("---------------------------------");
        Runtime run2 = Runtime.getRuntime();// 当前程序运行对象
        run2.gc();// 调用垃圾回收机制，减少内存误差
        Long freememroy2 = run.freeMemory();// 获取当前空闲内存
        Long protime2 = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10000; i++)
        {
            service.execute(new ThreadCondition());
        }
        System.out.println("线程池创建" + 10000 + "个线程需要的内存空间" + (freememroy2 - run.freeMemory()));
        service.shutdown();

        System.out.println("线程池创建" + 10000 + "个线程需要的系统时间" + (System.currentTimeMillis() - protime2));

        System.out.println("---------------------------------");
        Runtime run22 = Runtime.getRuntime();// 当前程序运行对象
        run22.gc();// 调用垃圾回收机制，减少内存误差
        Long freememroy22 = run22.freeMemory();// 获取当前空闲内存
        Long protime22 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++)
        {
            new ThreadCondition();
        }
        System.out.println("独立创建" + 10000 + "个线程需要的内存空间" + (freememroy22 - run22.freeMemory()));
        System.out.println("独立创建" + 10000 + "个线程需要的系统时间" + (System.currentTimeMillis() - protime22));

    }

    @Override
    public void run()
    {
        // System.out.println(count++);
    }

}
