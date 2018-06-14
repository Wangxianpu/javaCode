package src.com.wxp.collectionGenerator.arrayListGenerator;

import java.util.ArrayList;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/3<br>
 * <br>
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen,int quantity){
        for(int i = 0;i<quantity;i++){
            add(gen.next());
        }
    }
    public static <T> CollectionData<T> list(Generator<T> gen,int quantity){
        return new CollectionData<T>(gen,quantity);
    }
}
