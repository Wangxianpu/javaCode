package com.wxp.thread.day0116;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/16<br>
 * <br>
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static synchronized int nextSerialNumber(){
        return serialNumber++;  //not thread-safe ,在线程中不加上synchronized就是不安全的
    }
}
