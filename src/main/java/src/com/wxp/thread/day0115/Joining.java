package src.com.wxp.thread.day0115;

import static src.com.wxp.util.Print.print;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        this.duration = sleepTime;
        start();
    }
    public void run(){
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            print(getName()+" has been interrupted ; "
                    + "isInterrupted(): "+isInterrupted());
            return;
        }
        print(getName()+" has been awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run(){
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print(getName()+" joined completed");
    }
}

public class Joining {
    public static void main(String args[]){
        Sleeper sleeper1 = new Sleeper("sleeper1",1500);
        Sleeper sleeper2 = new Sleeper("sleeper2",1500);
        Joiner joiner1 = new Joiner("join1",sleeper1);
        Joiner joiner2 = new Joiner("join2",sleeper2);
        sleeper1.interrupt();
    }
}
