package src.com.wxp.ioTest.dir;

import java.io.*;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/8<br>
 * <br>
 */
public class DataInputOrOutputStream {
    public static void main(String args[]){
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
            out.writeDouble(3.14159);
            out.writeUTF("aaa嗷嗷你好a");
            out.writeLong(737);
            out.writeUTF("hello");
            out.flush();
            out.close();//记住关闭流

            in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
            System.out.println(in.readLong());
            System.out.println(in.readUTF());
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
