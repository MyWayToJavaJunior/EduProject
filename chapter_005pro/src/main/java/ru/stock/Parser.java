package ru.stock;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

/**
 * Created by nik on 5/11/2017.
 */
public class Parser extends DefaultHandler {

    private Map<String, List<Order>> books = new TreeMap<>();

    public Map<String, List<Order>> getBooks() {
        return books;
    }

    Order order;

    private String[] elems = new String[5];

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        int lenght = attributes.getLength();

        if(qName.equals("AddOrder")) {
            for (int i = 0; i < lenght; i++) {
                elems[i] = attributes.getValue(i);
            }
        } else if(qName.equals("DeleteOrder")) {
            for (int i = 0; i < lenght; i++) {
                elems[i] = attributes.getValue(i);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("AddOrder")) {
            order = new Order(elems[0], Order.Type.valueOf(elems[1]), new Float(elems[2]), new Integer(elems[3]), new Integer(elems[4]));
            if(!books.containsKey(elems[0])) {
                books.put(elems[0], new ArrayList<>());
            }
            books.get(elems[0]).add(order);
        } else  if(qName.equals("DeleteOrder")) {
            List<Order> list = books.get(elems[0]);
            int counter = -1;
            for(Order o : list) {
                counter++;
                if(o.getId() == Integer.parseInt(elems[1]) && o.getBook().equals(elems[0])) {
                    break;
                }
            }

            if(counter != -1) {
                books.get(elems[0]).remove(counter);
            }
        }
    }
}
