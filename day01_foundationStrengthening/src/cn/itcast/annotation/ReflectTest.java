package cn.itcast.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Pro(className = "cn.itcast.annotation.Demo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.获取上边的注解对象
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回值
        String s = annotation.className();
        String s1 = annotation.methodName();

        Class cls = Class.forName(s);

        Constructor constructor = cls.getConstructor();
        Object obj = constructor.newInstance();
        Method method = cls.getMethod(s1);
        method.invoke(obj);


    }

}
