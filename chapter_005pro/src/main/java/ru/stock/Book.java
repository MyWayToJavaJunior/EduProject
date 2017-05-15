package ru.stock;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.*;

/**
 * Created by nik on 5/11/2017.
 */
public class Book {

     Map<String, List<Order>> sell = new TreeMap<>();
     Map<String, List<Order>> buy = new TreeMap<>();
    private Map<String, List<Order>> books;



    public Book(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            Parser saxp = new Parser();
            parser.parse(new File(file), saxp);
            books = saxp.getBooks();
        } catch (Exception e) {
            System.out.println("!Exception: " + e.getStackTrace());
        }
    }

    public void devideForSellAndBuy(Map<String, List<Order>> books) {
        String key;
        for (Map.Entry<String, List<Order>> entry : books.entrySet())
        {
            key = entry.getKey();
            for (Order o : entry.getValue()){
                if (o.getOperation().equals(Order.Type.SELL)) {
                    if (!sell.containsKey(key)) {
                        sell.put(key, new ArrayList<>());
                    }
                    sell.get(key).add(o);
                } else if (o.getOperation().equals(Order.Type.BUY)) {
                    if (!buy.containsKey(key)) {
                        buy.put(key, new ArrayList<>());
                    }
                    buy.get(key).add(o);
                }
            }
        }
    }

    public void sumEqualsPrice(Map<String, List<Order>> map) {
        List<Order> list;
        String key;
        for (Map.Entry<String, List<Order>> entry : map.entrySet())
        {
            key = entry.getKey();
            list = entry.getValue();
            Collections.sort(list);
            for (int i = 0; list.size() - 1 > i; i++){
                if (list.get(i).getPrice() == list.get(i + 1).getPrice()) {
                    list.get(i + 1).setVolume(list.get(i + 1).getVolume() + list.get(i).getVolume());
                    list.remove(i);
                    i--;
                }
            }
            map.replace(key ,list);
        }
    }

    public void buyAndSellOperation() {
        List<Order> buyList;
        List<Order> sellList;
        String buyKey;
        String sellKey;

        Iterator<Map.Entry<String, List<Order>>> buyIter = buy.entrySet().iterator();
        Iterator<Map.Entry<String, List<Order>>> sellIter = sell.entrySet().iterator();

        while(buyIter.hasNext() || sellIter.hasNext())
        {
            Map.Entry<String, List<Order>> buyEntry;
            Map.Entry<String, List<Order>> sellEntry;
            if(buyIter.hasNext() && sellIter.hasNext()) {
                buyEntry = buyIter.next();
                sellEntry = sellIter.next();

                buyKey = buyEntry.getKey();
                sellKey = sellEntry.getKey();

                if(buyKey.equals(sellKey)) {
                    buyList = buyEntry.getValue();
                    sellList = sellEntry.getValue();

                    for (int i = 0; buyList.size() > i; i++) {
                        for (int j = 0; buyList.size() > j; j++) {
                            if (sellList.get(i).getPrice() <= buyList.get(j).getPrice()) {
                                if (sellList.get(i).getVolume() > buyList.get(j).getVolume()) {
                                    sellList.get(i).setVolume(sellList.get(i).getVolume() - buyList.get(j).getVolume());
                                    buyList.remove(j);
                                } else if (sellList.get(i).getVolume() < buyList.get(j).getVolume()) {
                                    buyList.get(j).setVolume(buyList.get(j).getVolume() - sellList.get(i).getVolume());
                                    sellList.remove(i);
                                } else {
                                    sellList.remove(i);
                                    buyList.remove(j);
                                }
                            }
                        }
                    }

                    buy.replace(buyKey, buyList);
                    sell.replace(sellKey, sellList);

                } else {
                    int tmp = buyKey.compareTo(sellKey);
                    if (tmp > 0 && buyIter.hasNext()) {
                        buyIter.next();
                    } else if (sellIter.hasNext()){
                        sellIter.next();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Book book = new Book("orders.xml");
        Map<String, List<Order>> map = book.books;
        book.devideForSellAndBuy(map);
        book.sumEqualsPrice(book.buy);
        book.sumEqualsPrice(book.sell);
        book.buyAndSellOperation();

        System.out.println("Buy operations:");
        for (Map.Entry<String, List<Order>> entry : book.buy.entrySet())
        {
            System.out.println(entry.getKey());
            for (Order o : entry.getValue()){
                System.out.println(o.getId() + " " + o.getOperation() + " " + o.getPrice() + " " + o.getVolume());
            }
        }

        System.out.println("\nSell operations:");
        for (Map.Entry<String, List<Order>> entry : book.sell.entrySet())
        {
            System.out.println(entry.getKey());
            for (Order o : entry.getValue()){
                System.out.println(o.getId() + " " + o.getOperation() + " " + o.getPrice() + " " + o.getVolume());
            }
        }

    }
}
