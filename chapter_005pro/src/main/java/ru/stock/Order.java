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

    public void setBook(String book) {
        this.book = book;
    }

    public Type getOperation() {
        return operation;
    }

    public void setOperation(Type operation) {
        this.operation = operation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public void setId(int id) {
        this.id = id;
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
        return (int)(this.getPrice() - o.getPrice());
    }
}
