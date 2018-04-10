package com.wxp.ioTest.channelTest;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/9<br>
 * <br>
 */
public class AvailableCharSets {
    public static void main(String args[]){
        SortedMap<String,Charset> charset = Charset.availableCharsets();
        for(Map.Entry<String,Charset> entry :charset.entrySet()){
            System.out.print(entry.getKey());
            Iterator<String> aliases = entry.getValue().aliases().iterator();
            if(aliases.hasNext())
                System.out.print(":");
            while(aliases.hasNext()){
               System.out.print(aliases.next());
               if(aliases.hasNext())
                   System.out.print(",");

            }
            System.out.println();
        }
    }
}
