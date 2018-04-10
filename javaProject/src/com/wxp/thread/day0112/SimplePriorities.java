package com.wxp.thread.day0112;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/12<br>
 * <br>
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for(int i = 0;i<100000;i++){
                d += (Math.PI + Math.E)/i;
                if(1%1000 ==0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown == 0){
                return;
            }
        }
    }

    public static void main(String args[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }

}
