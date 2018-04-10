package com.wxp.thread.day0117;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/17<br>
 * <br>
 */
public class MultiLock {
    public synchronized void f1( int count){
        if(count-- >0){
            System.out.println("f1() calling f2() with count "+ count);
            f2(count);
        }
    }
    private synchronized  void f2(int count){
        if(count-- > 0){
            System.out.println("f2() calling f1() with count "+ count);
            f1(count);
        }
    }

    public static void main(String[] args){
        final MultiLock ml = new MultiLock();
        new Thread(){
            public void run(){
                ml.f1(10);
            }
        }.start();
    }
}
