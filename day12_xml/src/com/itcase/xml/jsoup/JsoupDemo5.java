package com.itcase.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 选择器查询
 */

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {

        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();

        Document d = Jsoup.parse(new File(path), "utf-8");

        Elements elements = d.select("name");
        System.out.println(elements);

        System.out.println("--------------");

        Elements elements1 = d.select("#itcase");
        System.out.println(elements1);

        System.out.println("--------------");

        Elements elements2 = d.select("student[number='heima_0001']");
        System.out.println(elements2);

        System.out.println("--------------");

        Elements elements3 = d.select("student[number='heima_0001'] > age");
        System.out.println(elements3);


    }
}
