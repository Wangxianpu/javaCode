package com.wxp.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取最长回文子串
 * Created by v_shampoowang on 2018/4/8.
 */
public class CycString {
    public static void main(String[] args){
        System.out.println("syss".substring(0,2));
    }

    public static String longestPalindrome(String s) {
        //存储不同长度的回文串
        List<StringBuffer> sbList = new ArrayList<StringBuffer>();
        boolean isTwoCycle = false;
        boolean isThreeCycle = false;
        sbList.add(new StringBuffer());
        for(int i = 1; i < s.length() ;i++){
            //如果发现复合回文串的要求的字符串，则将其添加到sbList中
            if(s.charAt(i) == s.charAt(i-1)){
                sbList.add(new StringBuffer(s.substring(i-1,i+1)));
                isTwoCycle = true;
            }
            if(i >= 2 && (s.charAt(i)==s.charAt(i-2))){
                sbList.add(new StringBuffer(s.substring(i-2,i+1)));
                isThreeCycle = true;
            }

            //如果是以两个重复字为回文串
            if(isTwoCycle){
                
            }
            //如果是以三个字，为开始的回文串
            if(isThreeCycle){

            }

        }

        return null;
    }
}
