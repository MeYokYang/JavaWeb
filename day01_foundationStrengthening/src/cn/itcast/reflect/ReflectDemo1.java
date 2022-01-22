package cn.itcast.reflect;

import cn.itcast.domain.Person;

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        //1.Class.forName，多用于配置文件
        Class cls1 = Class.forName("cn.itcast.domain.Person");
        System.out.println(cls1);

        //2.类名.class，多用于参数的传递
        Class cls2 = Person.class;
        System.out.println(cls2);

        //3.对象.getClass，多用于对象获取字节码的方式
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
    }
}
