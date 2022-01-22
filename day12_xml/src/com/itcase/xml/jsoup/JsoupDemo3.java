package com.itcase.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document对象功能
 */

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {

        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();

        Document d = Jsoup.parse(new File(path), "utf-8");

        Elements elements = d.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("----------------");

        Elements elements1 = d.getElementsByAttribute("id");
        System.out.println(elements1);

        System.out.println("----------------");

        Elements elements2 = d.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);

        System.out.println("----------------");

        Element element = d.getElementById("itcase");
        System.out.println(element);

    }
}
