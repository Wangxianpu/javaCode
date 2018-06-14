package src.com.wxp.ioTest.dir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/8<br>
 * <br>
 */
public class FileOutputShortCut {
    static String file = "D:\\IdealWorkspace\\javaProject\\src\\com\\wxp\\ioTest\\dir\\FileOutputShortCut.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("D:\\IdealWorkspace\\javaProject\\src\\com\\wxp\\ioTest\\dir\\FileOutputShortCut.java")));
        PrintWriter out = new PrintWriter(file);
        String s = null;
        while((s=in.readLine())!=null){
            out.println(s);
        }
        out.flush();
        in.close();
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
