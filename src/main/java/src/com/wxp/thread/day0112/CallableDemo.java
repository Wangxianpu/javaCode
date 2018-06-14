package src.com.wxp.thread.day0112;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/12<br>
 * <br>
 */

class TaskWithResult implements Callable<String>{
    private int id ;
    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "the result of task is "+ id;
    }
}


public class CallableDemo {
    public static void main(String args[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<Future<String>>();
        for(int i= 0 ;i<10;i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for(Future<String> fs : results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}
