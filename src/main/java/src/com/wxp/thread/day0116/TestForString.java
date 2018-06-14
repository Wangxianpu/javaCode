package src.com.wxp.thread.day0116;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/16<br>
 * <br>
 */
public class TestForString {
    public static void main(String args[]){
        StringBuffer sb = new StringBuffer("12345-ka3.");
        System.out.println("length:"+sb.length()+" lastIndexOf:"+sb.lastIndexOf("."));
        String str = sb.substring(0,sb.lastIndexOf("."));
        System.out.println("最后的结果为："+str);
    }
}
