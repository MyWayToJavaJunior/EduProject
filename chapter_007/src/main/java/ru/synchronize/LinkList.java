package ru.synchronize;

import java.util.Iterator;

/**
 * Created by nik on 4/20/2017.
 * @param <T> - type.
 */
public class LinkList<T> implements SimpleContainer {
    /**
     * Node of linkedList.
     * @param <T> - type.
     */
    public class Node<T> {
        /**
         * value of node.
         */
        private Object value;
        /**
         * link to next node in list.
         */
        private Node<T> next;
    }
    /**
     * head of the list.
     */
    private Node<T> head;
    /**
     * tail of the list.
     */
    private Node<T> tail;

    /**
     * Remove item from list.
     * @param index - index of item.
     */
    public synchronized void remove(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        Node<T> result = this.head;
        index--;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        if (result.next.next == null) {
            result.next = null;
            tail = result;
        } else {
            result.next = result.next.next;
        }
    }

    @Override
    public synchronized void add(Object value) {
        Node<T> node = new Node<>();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public synchronized T get(int index) {
        Node<T> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return (T) result.value;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return head.next != null;
            }

            @Override
            public Object next() {
                Node<T> result = current;
                current = current.next;
                return result;
            }
        };
    }
    /**
     * Main met for controller.
     * @param args - .
     */
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();

        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
