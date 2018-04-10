package com.wxp.thread.day0115;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor(){
        super(0,Integer.MAX_VALUE,60L, TimeUnit.SECONDS
                ,new SynchronousQueue<Runnable>(),new DaemonFactory());
    }
}
