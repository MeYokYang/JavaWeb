package com.itcase.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象功能
 */

public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {

        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();

        Document d = Jsoup.parse(new File(path), "utf-8");

        Elements elements = d.getElementsByTag("name");
        System.out.println(elements);

        System.out.println("-----------------");

        Element element_student = d.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        String number = element_student.attr("number");
        System.out.println(number);

        System.out.println("-----------------");

        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);
        System.out.println(html);

    }
}
