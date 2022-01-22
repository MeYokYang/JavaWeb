package cn.itcast.annotation.Demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();

        Class<? extends Calculator> cls = c.getClass();
        Method[] methods = cls.getMethods();
        int number = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method m : methods){
            if (m.isAnnotationPresent(Check.class)){
                try {
                    m.invoke(c);
                } catch (Exception e) {
                    ++number;
                    bw.write(m.getName()+"方法出现了异常");
                    bw.newLine();
                    bw.write("异常的名称"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("----------------");
                    bw.newLine();
                }
            }

        }

        bw.write("一共出现"+number+"次错误");
        bw.flush();
        bw.close();

    }



}
