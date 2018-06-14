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
public class Daemons {
    public static void main(String args[]) throws InterruptedException {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        print("t de daemon is "+ t.isDaemon());
        TimeUnit.MILLISECONDS.sleep(2);

    }
}
