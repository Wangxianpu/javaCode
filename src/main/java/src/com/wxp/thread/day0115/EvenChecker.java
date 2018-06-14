package src.com.wxp.thread.day0115;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator gen,int id){
        this.intGenerator = gen;
        this.id = id;
    }

    @Override
    public void run() {
        while(!intGenerator.isCanceled()){
            int val = intGenerator.next();
            if(val%2 !=0){
                System.out.println(val + "the number is not even!");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator gen,int count){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++)
            exec.execute(new EvenChecker(gen,count));
        exec.shutdown();
    }

    public static void test(IntGenerator gen){
        test(gen,10);
    }
}
