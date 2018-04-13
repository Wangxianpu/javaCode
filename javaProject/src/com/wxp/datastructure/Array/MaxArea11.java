package com.wxp.datastructure.Array;

/**
 * Created by v_shampoowang on 2018/4/13.
 */
public class MaxArea11 {
    public static void main(String[] args){
        int[] height =new int[15000];
        for(int i = 0; i < 15000;i++)
            height[i] = i+1;
        long start = System.currentTimeMillis();
        System.out.println(maxArea(height));
        long end = System.currentTimeMillis();
        System.out.println("执行结束，耗时："+(end-start));
    }

    public static int maxArea2(int[] height) {
        if(height==null) return 0;
        int max = 0;//最大面积
        for(int i = 2 ;i<=height.length;i++){
            for(int j = 1 ; j<i ;j++){
                max = Math.max(max,Math.abs(i-j)*Math.min(height[i-1],height[j-1]));
            }
        }
        return max;
    }

    public static int maxArea(int[] height){
        if(height == null) return 0;
        int max = 0;//最大面积
        int left = 0 ;
        int right = height.length - 1;
        while(left<right){
            max = Math.max(max,Math.abs(right-left)*Math.min(height[right],height[left]));
            if(height[right]<height[left]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
}
