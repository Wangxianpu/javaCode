package src.com.wxp.thread.day0115;

import java.util.concurrent.TimeUnit;

import static src.com.wxp.util.Print.print;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread()+" "+this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        for(int i = 0;i<5;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        print("all thread starting...");
        TimeUnit.MILLISECONDS.sleep(100);
    }

}

