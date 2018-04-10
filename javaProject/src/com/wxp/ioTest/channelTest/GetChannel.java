package com.wxp.ioTest.channelTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/9<br>
 * <br>
 */
public class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("something is  wrong!".getBytes()));
        fc.close();
        fc = new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("something other is correct!".getBytes()));
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        System.out.println(buff);
        while(buff.hasRemaining()){
            System.out.println((char)buff.get());
        }
    }
}
