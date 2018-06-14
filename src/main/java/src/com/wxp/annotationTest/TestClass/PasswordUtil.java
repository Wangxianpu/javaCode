package src.com.wxp.annotationTest.TestClass;


import src.com.wxp.annotationTest.annotation.UserCase;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/11<br>
 * <br>
 */
public class PasswordUtil {
    @UserCase(id = 1,defaultValue = "jiushi")
    public void sayOneAnnotation(){
        System.out.println();
    }
    @UserCase(id=2)
    public void sayTwoAnnotation(){

    }
}
