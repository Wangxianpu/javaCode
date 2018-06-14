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
public class ADaemon implements Runnable{
    @Override
    public void run() {
        print("starting ADaemon ...");
        try {
            TimeUnit.MILLISECONDS.sleep(1);
                    print("starting ADaemon ...1");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            print("this is the finally method");
        }
    }
    public static void main(String args[]){
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
