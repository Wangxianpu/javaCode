package src.com.wxp.thread.day0118;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/18<br>
 * <br>
 */

class Blocker{
    synchronized void waitingCall(){
        try {
            while(!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread()+"  ");
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }
    synchronized void prod(){
        notify();
    }
    synchronized  void prodAll(){
        notifyAll();
    }
}

class Task implements Runnable{
    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable{
    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}


public class NotifyVsNotifyAll {
    public static void main(String args[]) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++)
            exec.execute(new Task());
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if(prod){
                    System.out.println("notify()  ");
                    Task.blocker.prod();
                    prod = false;
                }else{
                    System.out.println("notifyAll()  ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        },400,400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Timer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.blocker.prodAll()");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("exec.shutdownNow()");
        exec.shutdownNow();
    }
}
