package src.com.wxp.annotationTest.TestClass;


import src.com.wxp.annotationTest.annotation.Test;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/11<br>
 * <br>
 */
public class Testable {
    public void execute(){
        System.out.println("executing ...");
    }
    @Test
    void testExecute(){
        execute();
    }
}
