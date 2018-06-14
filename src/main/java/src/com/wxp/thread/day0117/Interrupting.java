package src.com.wxp.thread.day0117;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/17<br>
 * <br>
 */
class SleepBlocked implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SleepBlocked exit...");
    }
}

class IOBlocked implements Runnable{

    private InputStream in;

    public IOBlocked(InputStream in){
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("wait for input!");
            in.read();
        } catch (IOException e) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("IOBlocked is interrupted");
            }else{
                throw new RuntimeException(e);
            }
        }
        System.out.println("IOBlocked exit...");
    }
}

class SynchronizedBlocked implements Runnable{

    public synchronized void f(){
        while(true){
            Thread.yield();
        }
    }
    public SynchronizedBlocked(){
        new Thread(){
            public void run(){
                f();
            }
        };
    }

    @Override
    public void run() {
        System.out.println("try to run SynchronizedBlocked");
        f();
        System.out.println("SynchronizedBlocked exit...");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    public static void test(Runnable r) throws InterruptedException {
        Future<?> f =exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("interrupting "+r.getClass().getName());
        f.cancel(true);
        System.out.println("interrupt send to "+r.getClass().getName());
    }
    public static void main(String args[]) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        System.out.println("Aborting all exit");
        System.exit(0);
    }
}
