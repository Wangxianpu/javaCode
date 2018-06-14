package src.com.wxp.collectionGenerator.mapGenerator;

import java.util.Map;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/4<br>
 * <br>
 */
public class MapNode {
    public static Map<String,String> getData(){
        Map<String,String> map = new MyHashMap<String,String>();
        map.put("1","1-1");
        map.put("2","2-1");
        map.put("3","3-1");
        map.put("4","4-1");
        return map;
    }
    public static void main(String[] args){
       Map<String,String> map = getData();
//       MyHashMap.MyNode<String,String> node = (MyHashMap.MyNode<String, String>) map.entrySet();
//       System.out.println(node);
//       for(Set<MyHashMap.MyNode<String,String>> n:node){
//
//       }

    }
}
