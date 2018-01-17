package com.free.study.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2018/1/17
 */
public class Printer {

    public static ExecutorService executor = null;

    static {
        int cpuCount = Runtime.getRuntime().availableProcessors();
        executor = new ThreadPoolExecutor(cpuCount, cpuCount, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(20000),
                new ThreadFactory() {
                    private AtomicInteger idGenerator = new AtomicInteger(1);
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "Printer_" + idGenerator.getAndIncrement());
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());
        System.out.println("Initialized executor successful! Thread count is " + cpuCount);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Printer.executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("Current thread name is " + Thread.currentThread().getName());
                    }
                }
            );
        }
        Printer.executor.shutdown();
    }
}
