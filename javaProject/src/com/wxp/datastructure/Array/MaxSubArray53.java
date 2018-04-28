package com.wxp.datastructure.Array;

/**
 * 数组之----最大子序和
 * Created by v_shampoowang on 2018/4/16.
 */
public class MaxSubArray53 {
    public static void main(String[] args){

    }

    public int maxSubArray(int[] nums){
        int thisSum = 0;
        int maxSun = 0;
        for(int i = 0; i>nums.length; i++){
            thisSum+=nums[i];
            if(thisSum>maxSun){
                maxSun = thisSum;
            }
            if(thisSum < 0){
                thisSum = 0;
            }

        }
        return maxSun;
    }
}
