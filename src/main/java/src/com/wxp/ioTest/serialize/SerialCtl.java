package src.com.wxp.ioTest.serialize;

import java.io.*;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/10<br>
 * <br>
 */
public class SerialCtl implements Serializable{
    private String a ;
    private transient String b;
    public SerialCtl(String a ,String b){
        this.a = a ;
        this.b = b ;
    }
    public String toString(){
        return a+b;
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(b);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        b = (String) in.readObject();
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        SerialCtl serial = new SerialCtl("a","b");
        System.out.println("Before Serializable:-->");
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("text.out"));
        out.writeObject(serial);
        out.flush();
        out.close();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("text.out")
        );
        serial = (SerialCtl) in.readObject();
        System.out.println("result: a->"+serial.a+",b->"+serial.b);
        in.close();
    }
}
