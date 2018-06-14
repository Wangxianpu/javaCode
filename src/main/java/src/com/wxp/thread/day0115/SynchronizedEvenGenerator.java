package src.com.wxp.thread.day0115;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private  int currentEvenValue;
    @Override
    public synchronized int next() {
        currentEvenValue++;
        Thread.yield();
        currentEvenValue++;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
