package com.wxp.thread.day0112;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/12<br>
 * <br>
 */
public class LiftOff implements Runnable{

    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public LiftOff(){}

    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"),";
    }

    @Override
    public void run() {
        while(countDown-->0){
            System.out.print(status());
            Thread.yield();
        }
    }
}
