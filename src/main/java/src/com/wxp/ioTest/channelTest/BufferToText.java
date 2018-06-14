package src.com.wxp.ioTest.channelTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/9<br>
 * <br>
 */
public class BufferToText {
    private static final int BSIZE = 1024;
    public static void main(String args[]) throws IOException {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("this is a file".getBytes()));
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();//做好读准备
        System.out.println(buff.asCharBuffer());

        buff.rewind();
        String decoding = System.getProperty("file.encoding");
        System.out.println("decoede using :"+decoding+":"+ Charset.forName(decoding).decode(buff));

        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("this is data2".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        fc = new FileOutputStream("data3.txt").getChannel();
        buff = ByteBuffer.allocate(64);
        buff.asCharBuffer().put("this is the data3");
        fc.write(buff);
        fc.close();
        fc = new FileInputStream("data3.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

    }
}
