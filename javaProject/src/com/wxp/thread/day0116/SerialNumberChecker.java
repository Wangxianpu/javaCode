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

class CircularSet{
    private int len;
    private int[] array;
    private int index = 0;
    public CircularSet(int size){
        array = new int[size];
        len = size;
        for(int i= 0;i<size;i++)
            array[i] = -1;
    }
    public synchronized void add(int i){
        array[index] = i;
        index = ++index%len;
    }
    public synchronized boolean contains(int val){
        for(int i = 0;i<len;i++){
            if(array[i]==val){
                return true;
            }
        }
        return false;
    }
}

public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable{

        @Override
        public void run() {
            while(true){
                int serial = SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serial)){
                    System.out.println("duplicate " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String args[]){
        for(int i=0;i<SIZE;i++)
        exec.execute(new SerialChecker());
    }

}
