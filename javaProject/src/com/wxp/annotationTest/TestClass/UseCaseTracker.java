package com.wxp.annotationTest.TestClass;

import com.wxp.annotationTest.annotation.UserCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/11<br>
 * <br>
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCase,Class<?> clz){
        for(Method m : clz.getDeclaredMethods()){
            UserCase uc = m.getAnnotation(UserCase.class);
            if(uc!=null){
                System.out.println("userCase的注解的内容如下：id-->"+uc.id()
                        +",另外一个值为-->"+uc.defaultValue());
                useCase.remove(uc.id());
            }
        }
    }
    public static void main(String[] args){
        List<Integer> useCase = new ArrayList<Integer>();
        Collections.addAll(useCase,1,2,3);
        trackUseCases(useCase,PasswordUtil.class);
    }
}
