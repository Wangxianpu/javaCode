package com.wxp.thread.day0117;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
class Count{
    private int count = 0;
    private Random rand = new Random(47);
    public synchronized int increment(){
        int temp = count;
        if(rand.nextBoolean()){
            Thread.yield();
        }
        return (count = ++temp);
    }
    public synchronized int getValue(){
        return count;
    }
}

class Entrance implements Runnable{
    private static Count count = new Count();
    private static List<Entrance> list = new ArrayList<Entrance>();
    private final int id ;
    private static volatile boolean canceled = false;
    private int number = 0;
    public static void cancel(){
        canceled = true;
    }
    public Entrance(int id){
        this.id = id;
        list.add(this);
    }

    public synchronized int getValue(){
        return number;
    }

    @Override
    public void run() {
        while(!canceled){
            synchronized (this){
                number++;
            }
            System.out.println(this + "total :"+count.increment());
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }

    public static int getTotal(){
        return count.getValue();
    }

    public static int sumEntrance(){
        int sum = 0;
        for(Entrance entrance:list){
            sum +=entrance.getValue();
        }
        return sum;
    }

    public String toString(){
        return "entrance id "+id+" :"+getValue();
    }

}


public class OrnametalGarden {
    public static void main(String args[]) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i =0 ;i<5;i++){
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(2);
        Entrance.cancel();
        exec.shutdown();
        System.out.println("total: "+ Entrance.getTotal());
        System.out.println("sum: "+ Entrance.sumEntrance());

    }
}
