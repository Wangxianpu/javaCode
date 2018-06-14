package src.com.wxp.ioTest.dir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/8<br>
 * <br>
 */
public class BufferedInputFile {

    public static String read(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s = null;
        StringBuffer sb = new StringBuffer();
        while((s=br.readLine())!=null){
            sb.append(s);
        }
        br.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("BufferedInputFile.java"));
    }
}
