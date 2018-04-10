package com.wxp.thread.day0112;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/12<br>
 * <br>
 */
public class MainThread {
    public static void main(String args[]){
        ExecutorService execute = Executors.newSingleThreadExecutor();
        for(int i = 0;i<5;i++){
            execute.execute(new LiftOff());
        }
        execute.shutdown();
    }
}
