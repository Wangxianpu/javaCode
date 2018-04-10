package com.wxp.thread.day0116;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/16<br>
 * <br>
 */
class DualSync{
    private Object syncObject = new Object();
    public synchronized void f(){
        for(int i = 0;i<5;i++){
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g(){
        synchronized(syncObject){
            for(int i = 0;i<5;i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String args[]){
        final DualSync dualSync = new DualSync();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                dualSync.f();
            }
        });
        t.start();
        dualSync.g();
    }
}
