package src.com.wxp.thread.day0118;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/18<br>
 * <br>
 */

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this){
                    wait();//如果没菜了就等着
                }
                System.out.println("上菜"+restaurant.meal);
                synchronized (restaurant.chef){
                    restaurant.meal = null;//上完菜，将菜置空
                    restaurant.chef.notifyAll();//上玩菜之后通知厨师做菜
                }
            }
        } catch (InterruptedException e) {
            System.out.println("waitPerson 服务员被打断了 interrupted");
        }
    }
}

class Chef implements Runnable {

    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                synchronized (this){
                    if(restaurant.meal!=null){//如果还有菜，则让服务员上完之后再做菜
                        wait();
                    }
                }
                if(count++==10){
                    System.out.println("我已经做了10盘菜了，不做了");
                    restaurant.exec.shutdownNow();
                }
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);//该厨师做的第几盘菜
                    restaurant.waitPerson.notifyAll();//做完菜之后，叫服务员去上菜
                }
            }
        } catch (InterruptedException e) {
            System.out.println("厨师被中断了 interrupted");
        }
    }
}

public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);

    public Restaurant() {
        exec.execute(waitPerson);
        exec.execute(chef);
    }

    public static void main(String args[]){
        new Restaurant();
    }

}
