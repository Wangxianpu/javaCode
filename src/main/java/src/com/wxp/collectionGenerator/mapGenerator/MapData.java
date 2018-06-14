package src.com.wxp.collectionGenerator.mapGenerator;


import src.com.wxp.collectionGenerator.arrayListGenerator.Generator;

import java.util.LinkedHashMap;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/3<br>
 * <br>
 */
public class MapData<K,V> extends LinkedHashMap<K,V>{
    //直接使用generator生成Pair
    public MapData(Generator<Pair<K,V>> gen, int quantity){
        for(int i = 0;i<quantity;i++){
            Pair<K,V> pair = gen.next();
            put(pair.key,pair.value);
        }
    }
    //使用generator生成key
    public MapData(Generator<K> genK,V value,int quantity){
        for(int i = 0;i<quantity;i++){
            put(genK.next(),value);
        }
    }
    //使用generator生成value和key
    public MapData(Generator<K> genK , Generator<V> genV, int quantity){
        for(int i = 0 ; i< quantity;i++){
            put(genK.next(),genV.next());
        }
    }
    //使用iteranble遍历key，generator生成value
    public MapData(Iterable<K> itK,Generator<V> genV){
        for(K key : itK){
            put(key,genV.next());
        }
    }
    //使用iterable 遍历key
    public MapData(Iterable<K> itK , V value){
        for(K key : itK){
            put(key,value);
        }
    }

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
        return new MapData( gen,quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> genK,V value,int quantity){
        return new MapData<K, V>(genK,value,quantity);
    }
    public static <K,V> MapData<K,V> map(Generator<K> genK , Generator<V> genV, int quantity){
        return new MapData<K, V>(genK,genV,quantity);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> itK,Generator<V> genV){
        return new MapData<K, V>(itK,genV);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> itK , V value){
        return new MapData<K, V>(itK,value);
    }
}
