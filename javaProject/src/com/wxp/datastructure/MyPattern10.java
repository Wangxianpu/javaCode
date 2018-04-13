package com.wxp.datastructure;

import java.util.Arrays;

/**
 * 正则表达式匹配
 * Created by v_shampoowang on 2018/4/13.
 */
public class MyPattern10 {
    public static void main(String[] args){
        MyPattern10 test = new MyPattern10();
        System.out.print(test.isMatch("aaa","..a"));
    }

    //pChar不一定是满的，所以要将最后的\u0000给过滤掉
    public boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();//用来被匹配的s串
        char[] pLen = p.toCharArray();//p的char数组
        char[] pChar = new char[p.length()*2];//用来当做匹配符的数组 如a*ba 格式为 a * b 1 a 1
        int index = 0;//pChar的下标
        //1、将pChar填充好 格式为 偶数坐标：字符  奇数坐标：次数 如a*ba 格式为 a * b 1 a 1
        for(int i =0;i<pLen.length;i++){
            //如果不是最后一位,并且下一位等于‘*’
            if(i<pLen.length-1&&pLen[i+1]=='*'){
                pChar[index] = pLen[i];
                index++;
                i++;
                pChar[index] = pLen[i];
            }else{
                pChar[index] = pLen[i];
                index++;
                pChar[index] = '1';
            }
            index++;
        }
        int usepCharLen = index ;
        //新弄一个pChar,保证里面每个书都是有意义的
//        pChar = Arrays.copyOfRange(pChar,0,index);

        //2、将sChar和pChar中的非*数据相匹配,如果全部包含，并且 顺序一致，则只需要判断str是否存在多余字符无法然pChar进行匹配

        index= 0;//记录pChar下标，保证顺序从左往右
        int sIndex =0;//记录sChar的下标，保证顺序从左往右
        //首先求出第一个非*匹配字符的下标
        while(index+1<usepCharLen&&pChar[index+1]=='*'){
            index+=2;
        }
        //进行匹配，如果pChar中的出现在str中，则pChar进行下一个匹配字符，sChar进入下一字符进行匹配
        while(index<usepCharLen&&sIndex<sChar.length){
            //如果在pChar中遇见是*的匹配字符，则不管其字符是什么，直接略过
            if(index+1<usepCharLen&&pChar[index+1]=='*'){
                index+=2;
                continue;
            }
            if(sChar[sIndex]==pChar[index] || pChar[index]=='.'){
                index+=2;
            }

            sIndex++;
        }
        //如果pChar的匹配字符没有全部走完，则返回失败
        if(index < usepCharLen){
            return false;
        }

        //3、此时已经确定了pChar中没有多余的匹配字符。现在只需要判断sChar中是否存在多余的字符

         index = 0;
        for(int i = 0 ;i<sChar.length;i++){
            if(index>=usepCharLen)
                return false;
            //如果匹配的上,则分情况，1、该匹配字符对应*,2、该匹配字符对应1
            if(sChar[i] == pChar[index] || pChar[index]=='.'){
                //如果该匹配字符对应1 则index+2 否则保留给下一位继续匹配
                if(index+1<usepCharLen&&pChar[index+1]=='1'){
                    index += 2;
                }
            }else if(index+1<usepCharLen&&pChar[index+1]=='*'){
                index += 2;
            }else{
                return false;
            }
        }
        return true;
    }
}
