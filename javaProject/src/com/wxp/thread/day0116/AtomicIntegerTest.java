package com.wxp.thread.day0116;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/16<br>
 * <br>
 */
public class AtomicIntegerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue(){
        return i.get();
    }
    public void evenIncrement(){
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while(true)
            evenIncrement();
    }

    public static void main(String args[]){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("aborting");
                System.exit(0);
            }
        },5000);

        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while(true){
            int val = ait.getValue();
            if(val % 2!=0){
                System.out.print("数据错误");
                System.exit(0);
            }
        }
    }
}
