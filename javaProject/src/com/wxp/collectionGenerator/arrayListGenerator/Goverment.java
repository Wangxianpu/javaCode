package com.wxp.collectionGenerator.arrayListGenerator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/3<br>
 * <br>
 */
public class Goverment implements Generator<String> {
    String[] arrStr = ("hello 大 家 好 ！ a b c d f s da fa dfdfa fas das das f ds").split(" ");
    private int index;
    @Override
    public String next() {
        return arrStr[index++];
    }

    public static void main(String[] args){
        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<String>(new Goverment(),15));
        //set.addAll(CollectionData.list(new Goverment(),15));
        System.out.println(set);
    }
}
