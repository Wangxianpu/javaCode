package com.wxp.datastructure;

/**
 * 动态规划  - 最长上升数列
 * Created by v_shampoowang on 2018/4/13.
 */
public class DpTest {
    public static void main(String[] args){
        int[] arr = {232,46554,43,6,765,876};
        System.out.println(riseLen(arr));
    }

    public static int riseLen(int[] arr){
        if(arr==null){
            return 0;
        }
        int[] p = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            p[i] = 1;
        }
        for(int i=1;i<p.length;i++){
            for(int j = 0;j<i;j++){
                if(arr[j]<arr[i]){
                    p[i] = Math.max(1,p[j]+1);
                }
            }
        }
        return p[p.length-1];
    }

}
