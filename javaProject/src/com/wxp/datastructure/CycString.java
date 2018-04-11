package com.wxp.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 获取最长回文子串
 * Created by v_shampoowang on 2018/4/8.
 */
public class CycString {
    public static void main(String[] args){
        System.out.println(longestPalindrome("aaa"));
    }

    public static String longestPalindrome(String s) {
        //存储不同长度的回文串
        List<StringBuffer> sbList = new ArrayList<StringBuffer>();
        boolean isTwoCycle = false;
        boolean isThreeCycle = false;
        //默认将第一个字符传入list，作为默认最长回文串
        sbList.add(new StringBuffer(String.valueOf(s.charAt(0))));
        for(int i = 1; i < s.length() ;i++){
            //判断当前字符是否构成回文串，是奇数还是偶数
            if(s.charAt(i) == s.charAt(i-1)){
                isTwoCycle = true;
            }
            if(i >= 2 && (s.charAt(i)==s.charAt(i-2))){
                isThreeCycle = true;
            }

            int cursor = 1;
            //如果是以两个重复字为回文串
            if(isTwoCycle){
                //字符串下标不能小于0,同时不能超过字符串长度
                while(i-cursor>=0 && i+cursor-1<s.length()){
                    //符合回文串规则
                    if(s.charAt(i-cursor) == s.charAt(i+cursor-1)){
                        cursor++;
                    }else{
                        break;
                    }
                }
                sbList.add(new StringBuffer(s.substring(i-cursor+1,i+cursor-1)));
                //可能该字符同时符合奇偶回文串，如ccc，故分开置为1
                cursor = 1;
                isTwoCycle = false;
            }
            //如果是以三个字，为开始的回文串，同时不能超过字符串长度
            if(isThreeCycle){
                while(i-cursor-1>=0 && i+cursor-1<s.length()){
                    if(s.charAt(i-cursor-1) == s.charAt(i+cursor-1)){
                        cursor++;
                    }else{
                        break;
                    }
                }
                sbList.add(new StringBuffer(s.substring(i-cursor,i+cursor-1)));
                cursor=1;
                isThreeCycle = false;
            }
        }

        Collections.sort(sbList, new Comparator<StringBuffer>() {
            @Override
            public int compare(StringBuffer sb1, StringBuffer sb2) {
                return -(sb1.length() - sb2.length());
            }
        });

        return sbList.get(0).toString();
    }
}

