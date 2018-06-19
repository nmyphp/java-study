package com.free.spring.quartz.demo;

import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义任务
 */
public class SimpleTask {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 真正的任务操作
     * <ul><li>到了cron制定时间，Spring每次都会新建一个线程执行excute方法</li>
     * <li>如果前一个任务没有执行完成，后一个任务是否会执行，取决于@{code org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean.concurrent}属性</li></ul>
     */
    @Test
    public void excute() {
        Thread currentThread = Thread.currentThread();
        String msg = String.format("[%s-%s] %s", currentThread.getId(), currentThread.getName(), dtf.format(LocalDateTime.now()));
        System.out.println(msg);
        long s = System.currentTimeMillis();
        while (true) {
            System.out.println(msg + "running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((System.currentTimeMillis() - s) > 60000) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");
        ctx.start();
        System.out.println("调度开启...");
    }
}
