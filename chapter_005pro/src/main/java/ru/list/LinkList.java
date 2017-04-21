package ru.list;

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
        /**
         * get value of node.
         * @return value.
         */
        public T getValue() {
            return (T) this.value;
        }
        /**
         * set value of node.
         * @param value - value to set.
         */
        public void setValue(Object value) {
            this.value = value;
        }
    }

    /**
     * head of the list.
     */
    private Node<T> head;
    /**
     * tail of the list.
     */
    private Node<T> tail;

    @Override
    public void add(Object value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public T get(int index) {
        Node<T> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return (T) result.getValue();
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
}
