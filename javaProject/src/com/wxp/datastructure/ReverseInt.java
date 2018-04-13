package com.wxp.datastructure;

/**
 * 7颠倒整数
 * Created by v_shampoowang on 2018/4/12.
 */
public class ReverseInt {
    public static void main(String[] args){
        ReverseInt test = new ReverseInt();
        System.out.println(test.reverse(-1534236460));
    }

    //将整数转化为String，进行转换,再比较是否大于MAX
    public int reverse(int x) {
        //如果是个位数，直接返回
        if (x < 10&& x >= 0) {
            return x;
        }
        char[] intChar = String.valueOf(x).toCharArray();
        char temp;
        //将数组倒序
        for (int i = 0; i < intChar.length / 2; i++) {
            temp = intChar[i];
            intChar[i] = intChar[intChar.length - 1 - i];
            intChar[intChar.length - 1 - i] = temp;
        }
        //默认符号，1表示整数，-1 表示负数
        int sign = 1;
        if(intChar[intChar.length-1]=='-'){
            sign*=-1;
        }
        int index = 0;
        //记录首位不位零的数字
        while (intChar[index] == '0') {
            index++;
        }
        String intStr = String.valueOf(intChar).substring(index,(sign==1)?intChar.length:(intChar.length-1));
        try {
            return  Integer.valueOf(intStr)*sign;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
