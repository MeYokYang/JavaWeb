package cn.itcast.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JacksonTest {
    //Java对象转为JSON字符串
    @Test
    public void test1() throws IOException {
        //1.创建Person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");

        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //3.转换
        /*
            转换方法：
                writeValue(参数1， obj)：
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutPutStream：将obj对象转换为JSON字符串，并将json数据填充到字节输入流中
                writeValueAsString(obj):将对象转换为json字符串
         */
        String json = mapper.writeValueAsString(person);
        System.out.println(json);


        mapper.writeValue(new File("D://a.txt"), person);

        mapper.writeValue(new FileWriter("D://b.txt"), person);

    }

    @Test
    public void test2() throws IOException {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(person);
        System.out.println(json);

    }

    @Test
    public void test3() throws IOException {
        Person person1 = new Person();
        person1.setName("张三");
        person1.setAge(23);
        person1.setGender("男");
        person1.setBirthday(new Date());

        Person person2 = new Person();
        person2.setName("张三");
        person2.setAge(23);
        person2.setGender("男");
        person2.setBirthday(new Date());

        Person person3 = new Person();
        person3.setName("张三");
        person3.setAge(23);
        person3.setGender("男");
        person3.setBirthday(new Date());

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(list);
        System.out.println(json);

    }

    @Test
    public void test4() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        map.put("gender", "男");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(map);
        System.out.println(json);

    }

    //演示 JSON字符串转换为Java对象
    @Test
    public void test5() throws IOException {
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);

    }


}
