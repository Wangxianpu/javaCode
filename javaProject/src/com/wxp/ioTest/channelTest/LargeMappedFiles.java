package com.wxp.ioTest.channelTest;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static com.wxp.util.Print.print;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/9<br>
 * <br>
 */
public class LargeMappedFiles {
    static int LENGTH = 0x8FFFFFF; //128MB
    public static void main(String[] args) throws IOException {
        MappedByteBuffer out = new RandomAccessFile("data.txt","rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE,0,LENGTH);
        for(int i =0;i<LENGTH;i++){
            out.put((byte)'X');
        }
        print("finished writing");
        for(int i = LENGTH/2;i<LENGTH/2+6;i++)
            print((char)out.get(i));
    }
}
