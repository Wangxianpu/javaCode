package src.com.wxp.thread.day0115;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try{
            currentEvenValue++;
            Thread.yield();
            currentEvenValue++;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String args[]){
        EvenChecker.test(new MutexEvenGenerator());
    }
}
