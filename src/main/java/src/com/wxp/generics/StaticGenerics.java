package src.com.wxp.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2017/12/29<br>
 * <br>
 */
public class StaticGenerics {
    //所以说这个静态方法是必须要加泛型方法，对返回或是入参进行限制的
    public static <T> Collection<T> gen(T number){
        return new ArrayList<T>();
    }
}

class Genertor<A> implements Comparable<A>{

    private Class<A> type;

    public Genertor(Class<A> type) {
        this.type = type;
    }

    public static <T> Genertor<T> getbean(Class<T> type){
        return new Genertor<T>(type);
    }

    public A getBean(){
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int compareTo(A o) {
        return 0;
    }

}