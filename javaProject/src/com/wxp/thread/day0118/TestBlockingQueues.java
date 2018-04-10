package com.wxp.thread.day0118;

import com.wxp.thread.day0112.LiftOff;

import java.util.concurrent.*;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/18<br>
 * <br>
 */

class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> q) {
        this.rockets = q;
    }

    public void add(LiftOff liftOff) {
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            System.out.println("interrupt during add()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
           System.out.println("waking from take()");
        }
        System.out.println("exiting LiftOffRun()");
    }
}

public class TestBlockingQueues {
    static int i = 0;
    public static void test(BlockingQueue<LiftOff> blockingQueue) throws InterruptedException {
        System.out.println("这是第一 "+ ++i +" 条测试数据");
        final LiftOffRunner runner = new LiftOffRunner(blockingQueue);
        Thread t = new Thread(runner);
        t.start();
        new Thread(){
            public void run(){
                for(int j = 0 ; j< 5 ;j++)
                    runner.add(new LiftOff(5));
            }
        }.start();
        TimeUnit.SECONDS.sleep(5);
        t.interrupt();
        System.out.println("第 "+ i +" 条数据测试完成！" );
    }
    public static void main(String args[]) throws InterruptedException {
        test(new LinkedBlockingDeque<LiftOff>());
        test(new LinkedBlockingDeque<LiftOff>(3));
        test(new ArrayBlockingQueue<LiftOff>(5));
        test(new SynchronousQueue<LiftOff>());
    }
}
