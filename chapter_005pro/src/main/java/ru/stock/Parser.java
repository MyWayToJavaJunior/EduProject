package ru.stock;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Created by nik on 5/11/2017.
 */
public class Parser extends DefaultHandler {
    /**
     * Заявки на продажу.
     */
    private Map<String, List<Order>> sell = new TreeMap<>();
    /**
     * Заявки на покупку.
     */
    private Map<String, List<Order>> buy = new TreeMap<>();
    /**
     * Все заявки.
     */
    private Map<String, Map<Integer, Order>> books = new TreeMap<>();
    /**
     * Геттер селл.
     * @return -
     */
    public Map<String, List<Order>> getSell() {
        return sell;
    }
    /**
     * Геттер бай.
     * @return -
     */
    public Map<String, List<Order>> getBuy() {
        return buy;
    }
    /**
     * Заявка.
     */
    private Order order;
    /**
     * Массив атрибутов заявки.
     */
    private String[] elems = new String[5];

    /**
     * Разделение заявок на 2 мапа, на покупку и на продажу.
     * @param books -
     */
    public void devideForSellAndBuy(Map<String, Map<Integer, Order>> books) {
        String key;
        for (Map.Entry<String, Map<Integer, Order>> entry : books.entrySet()) {
            key = entry.getKey();
            Iterator<Map.Entry<Integer, Order>> iter = entry.getValue().entrySet().iterator();
            while (iter.hasNext()) {
                Order o = iter.next().getValue();
                if (o.getOperation().equals(Order.Type.SELL)) {
                    if (!sell.containsKey(key)) {
                        sell.put(key, new ArrayList<>());
                    }
                    sell.get(key).add(o);
                } else { //if (o.getOperation().equals(Order.Type.BUY)) {
                    if (!buy.containsKey(key)) {
                        buy.put(key, new ArrayList<>());
                    }
                    buy.get(key).add(o);
                }
            }
        }
    }

    /**
     * Суммирование заяков с одинаковой ценой.
     * @param map -
     */
    public void sumEqualsPrice(Map<String, List<Order>> map) {
        List<Order> list;
        String key;
        for (Map.Entry<String, List<Order>> entry : map.entrySet()) {
            key = entry.getKey();
            list = entry.getValue();
            Collections.sort(list);
            for (int i = 0; list.size() - 1 > i; i++) {
                if (list.get(i).getPrice() == list.get(i + 1).getPrice()) {
                    list.get(i + 1).setVolume(list.get(i + 1).getVolume() + list.get(i).getVolume());
                    list.remove(i);
                    i--;
                }
            }
            map.replace(key, list);
        }
    }

    /**
     * Операции покупки-продажи.
     */
    public void buyAndSellOperation() {
        List<Order> buyList;
        List<Order> sellList;
        String buyKey;
        String sellKey;

        Iterator<Map.Entry<String, List<Order>>> buyIter = buy.entrySet().iterator();
        Iterator<Map.Entry<String, List<Order>>> sellIter = sell.entrySet().iterator();

        while (buyIter.hasNext() || sellIter.hasNext()) {
            Map.Entry<String, List<Order>> buyEntry;
            Map.Entry<String, List<Order>> sellEntry;
            if (buyIter.hasNext() && sellIter.hasNext()) {
                buyEntry = buyIter.next();
                sellEntry = sellIter.next();

                buyKey = buyEntry.getKey();
                sellKey = sellEntry.getKey();

                if (buyKey.equals(sellKey)) {
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
                    } else if (sellIter.hasNext()) {
                        sellIter.next();
                    }
                }
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        int lenght = attributes.getLength();

        if (qName.equals("AddOrder")) {
            for (int i = 0; i < lenght; i++) {
                elems[i] = attributes.getValue(i);
            }
        } else if (qName.equals("DeleteOrder")) {
            for (int i = 0; i < lenght; i++) {
                elems[i] = attributes.getValue(i);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("AddOrder")) {
            order = new Order(elems[0], Order.Type.valueOf(elems[1]), new Float(elems[2]), Integer.valueOf(elems[3]), Integer.valueOf(elems[4]));
            if (!books.containsKey(elems[0])) {
                books.put(elems[0], new TreeMap<>());
            }
            books.get(elems[0]).put(Integer.valueOf(elems[4]), order);
        } else {
            Map<Integer, Order> map = books.get(elems[0]);
            map.remove(Integer.valueOf(elems[1]));
            books.put(elems[0], map);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        devideForSellAndBuy(books);
        sumEqualsPrice(sell);
        sumEqualsPrice(buy);
        buyAndSellOperation();
    }
}
