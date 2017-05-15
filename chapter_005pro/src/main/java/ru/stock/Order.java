package ru.stock;

/**
 * Created by nik on 5/11/2017.
 */
public class Order implements Comparable<Order> {
    /**
     * Перечисление типов заявок.
     */
    enum Type {
        /**
         * Типов заявок.
         */
        SELL, BUY;
    }
    /**
     * Имя инструмента.
     */
    private String book;
    /**
     * Тип операции.
     */
    private Type operation;
    /**
     * Цена.
     */
    private double price;
    /**
     * Объем лота.
     */
    private int volume;
    /**
     * Идентификатор заявки.
     */
    private int id;

    /**
     * Конструктор.
     * @param book -
     * @param operation -
     * @param price -
     * @param volume -
     * @param id -
     */
    public Order(String book, Type operation, float price, int volume, int id) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }
    /**
     * Геттер.
     * @return -
     */
    public String getBook() {
        return book;
    }
    /**
     * Геттер.
     * @return -
     */
    public Type getOperation() {
        return operation;
    }
    /**
     * Геттер.
     * @return -
     */
    public double getPrice() {
        return price;
    }
    /**
     * Геттер.
     * @return -
     */
    public int getVolume() {
        return volume;
    }
    /**
     * Сеттер.
     * @param volume -
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
    /**
     * Геттер.
     * @return -
     */
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
