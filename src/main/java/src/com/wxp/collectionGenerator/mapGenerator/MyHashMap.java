package src.com.wxp.collectionGenerator.mapGenerator;

import java.util.*;

public class MyHashMap<K,V> extends HashMap<K, V> {

    static class MyNode<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        MyHashMap.MyNode<K,V> next;

        MyNode(int hash, K key, V value, MyHashMap.MyNode<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return (key==null   ? 0 : key.hashCode()) ^
                    (value==null ? 0 : value.hashCode());
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            Map.Entry e = (Map.Entry)o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }
    }

}