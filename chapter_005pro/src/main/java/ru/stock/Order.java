package ru.stock;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by nik on 5/11/2017.
 */
public class Order implements Comparable<Order> {
    enum Type {
        SELL, BUY;
    }
    private String book;
    private Type operation;
    private double price;
    private int volume;
    private int id;

    public Order(String book, Type operation, float price, int volume, int id) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public Type getOperation() {
        return operation;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        if (id != order.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Order o) {
        if (this.getPrice() - o.getPrice() < 0) {
            return -1;
        }
        if (this.getPrice() - o.getPrice() > 0) {
            return 1;
        }

        return 0;

    }
}
