package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Person p = new Person();

        //1.getFields,获取public
        Field[] fields = personClass.getFields();
        for (Field field : fields){
            System.out.println(field);
        }
        System.out.println("---------------------");
        Field a = personClass.getField("a");
        //获取a的值
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p, "Tom");
        System.out.println(p);

        //2.getDeclaredFields,获取所有
        Field d = personClass.getDeclaredField("d");
        d.setAccessible(true);
        d.set(p, "Bob");
        System.out.println(p);
    }
}
