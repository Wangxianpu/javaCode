package com.wxp.collectionGenerator.mapGenerator;

/**
 * 数据传输对象，信使
 * 功能说明:  <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/3<br>
 * <br>
 */
public class Pair<K,V> {
    public final K key;
    public final V value;
    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }
}
