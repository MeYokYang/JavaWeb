package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Person p = new Person();

        //2.getMethod
        Method eat = personClass.getMethod("eat");
        eat.invoke(p);

        Method eat1 = personClass.getMethod("eat", String.class);
        eat1.invoke(p, "apple");
    }
}
