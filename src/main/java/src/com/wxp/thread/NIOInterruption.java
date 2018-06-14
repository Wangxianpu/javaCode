package src.com.wxp.thread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/17<br>
 * <br>
 */
class NIOBlocked implements Runnable{

    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc){
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            sc.read(ByteBuffer.allocate(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


public class NIOInterruption {
}
