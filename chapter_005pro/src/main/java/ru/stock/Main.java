package ru.stock;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by nik on 5/11/2017.
 */
public class Main {
    /**
     * Объект парсер.
     */
    private Parser saxp = new Parser();
    /**
     * Конструктор.
     * В нем вызывается парсер.
     * @param file - имя файла для парсинга.
     */
    public Main(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(file), saxp);
        } catch (Exception e) {
            System.out.println("!Exception: " + e.getStackTrace());
        }
    }

    /**
     * Точка входа в программу.
     * @param args - список передаваемых аргументов.
     */
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        Main book = new Main("orders.xml");
        Map<String, List<Order>> sell = book.saxp.getSell();
        Map<String, List<Order>> buy = book.saxp.getBuy();

        System.out.println("Buy operations:");
        for (Map.Entry<String, List<Order>> entry : buy.entrySet()) {
            System.out.println(entry.getKey());
            for (Order o : entry.getValue()) {
                System.out.println(o.getId() + " " + o.getOperation() + " " + o.getPrice() + " " + o.getVolume());
            }
        }

        System.out.println("\nSell operations:");
        for (Map.Entry<String, List<Order>> entry : sell.entrySet()) {
            System.out.println(entry.getKey());
            for (Order o : entry.getValue()) {
                System.out.println(o.getId() + " " + o.getOperation() + " " + o.getPrice() + " " + o.getVolume());
            }
        }

        System.out.print("Sec: ");
        System.out.println((System.currentTimeMillis() - t) / 1000);
    }
}
