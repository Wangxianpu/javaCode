package com.wxp.thread.day0116;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/16<br>
 * <br>
 */
public class AtomicityTest implements Runnable {

    private  int i = 0 ;
    public  int getValue(){
        return i;
    }

    public synchronized  void evenIncrement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while(true)
            evenIncrement();
    }
    public static void main(String args[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while(true){
            int val = at.getValue();
            if(val % 2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
