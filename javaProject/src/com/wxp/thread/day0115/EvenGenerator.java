package com.wxp.thread.day0115;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public int next() {
        currentEvenValue++;
        currentEvenValue++;
        return currentEvenValue;
    }
    public static void main(String args[]){
        EvenChecker.test(new EvenGenerator());
    }
}
