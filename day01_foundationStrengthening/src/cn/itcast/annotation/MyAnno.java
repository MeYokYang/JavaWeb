package cn.itcast.annotation;

public @interface MyAnno {

    int show1();
    String show2() default "Tom";

    Person per();
    MyAnno2 anno2();

    String[] strs();
}
