package com.wxp.thread.day0116;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/16<br>
 * <br>
 */

class Accessor implements Runnable{

    private final int id ;

    public Accessor(int id){
        this.id = id;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString(){
        return "#"+ id + " : "+ThreadLocalVariableHolder.getValue();
    }
}

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random rand =new Random(47);
        protected synchronized Integer initialValue(){
            return rand.nextInt(10000);
        }
    };

    public static void increment(){
        value.set(value.get()+1);
    }

    public static Integer getValue(){
        return value.get();
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Accessor(6));
        TimeUnit.MILLISECONDS.sleep(3);
        exec.shutdown();
    }

}
