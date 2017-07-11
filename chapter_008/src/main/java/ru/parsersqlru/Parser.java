package ru.parsersqlru;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by nik on 6/29/2017.
 */
public class Parser {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.sql.ru/forum/job").get();
        Elements el = doc.select("a");
        for(Element e : el) {
            if (!e.attr("href").contains(".aspx?") && e.attr("href").contains("sql.ru")) {
                System.out.println(e.attr("href"));
                System.out.println(e.text());
                System.out.println("------------------------------------------------------------------");
            }
        }
    }
}
