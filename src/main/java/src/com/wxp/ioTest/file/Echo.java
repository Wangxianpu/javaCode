package src.com.wxp.ioTest.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/8<br>
 * <br>
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while((s=in.readLine())!=null){
            System.out.println(s);
        }
        in.close();
    }
}
