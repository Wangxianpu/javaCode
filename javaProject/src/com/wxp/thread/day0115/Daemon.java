package com.wxp.thread.day0115;

import static com.wxp.util.Print.print;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public class Daemon implements Runnable {
    private Thread[] threads = new  Thread[10];
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            threads[i] = new Thread(new DaemonSpawn());
            threads[i].start();
            print("thread " + i + " started");
        }
        for(int i=0;i<10;i++){
            print("thread "+i+" daemon is " +threads[i].isDaemon()+".");
        }
        while(true)
        Thread.yield();
    }

    class DaemonSpawn implements Runnable{
        @Override
        public void run() {
            Thread.yield();
        }
    }

}
