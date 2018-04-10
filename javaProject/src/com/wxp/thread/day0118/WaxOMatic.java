package com.wxp.thread.day0118;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/17<br>
 * <br>
 */
class Car{
    private boolean waxOn = false;
    public synchronized void waxed(){
        waxOn = true;
        notify();
    }

    public synchronized  void buffed(){
        waxOn = false;
        notify();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while(waxOn==false){
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn==true){
            wait();
        }
    }
}

class WaxOn implements Runnable{

    private Car car ;

    public WaxOn(Car car){
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax On!!!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WaxOff implements Runnable{

    private Car car ;

    public WaxOff(Car car){
        this.car = car;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                System.out.println("Wax Off!!!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
                car.waitForWaxing();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class WaxOMatic {
    public static void main(String args[]) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
