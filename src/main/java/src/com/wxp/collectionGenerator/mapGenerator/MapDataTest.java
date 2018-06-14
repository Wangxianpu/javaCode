package src.com.wxp.collectionGenerator.mapGenerator;


/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/3<br>
 * <br>
 */
public class MapDataTest {
    public static void main(String[] args){
        System.out.println(MapData.map(new Letters(),11));
        System.out.println(MapData.map(new Letters(),"ccc",11));

    }
}
