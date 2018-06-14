package src.com.wxp.thread.day0115;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static src.com.wxp.util.Print.print;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws InterruptedException {
        ExecutorService execute = Executors.newCachedThreadPool(
                new DaemonFactory()
        );
        for(int i=0;i<10;i++){
            execute.execute(new DaemonFromFactory());
        }
        print(" all daemons started");
        TimeUnit.MILLISECONDS.sleep(1000);

    }
}
