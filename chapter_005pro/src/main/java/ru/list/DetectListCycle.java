package ru.list;

/**
 * Created by nik on 4/21/2017.
 */
public class DetectListCycle {
    /**
     * Node.
     * @param <T> - tyle of item in node.
     */
    public static class Node<T> {
        /**
         * Constructor.
         * @param value - item.
         */
        public Node(T value) {
            this.value = value;
        }
        /**
         * Value.
         */
        private T value;
        /**
         * Next value.
         */
        private Node<T> next;
        /**
         * Node getter.
         * @return - next node.
         */
        public Node<T> getNext() {
            return next;
        }
        /**
         * Node setter.
         * @param next - set next node.
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    /**
     * Check for cycles.
     * @param first - first node in list.
     * @return - is cyrcle?
     */
    public boolean hasCycle(Node first) {
        Node tmp = first;
        while (true) {
            tmp = tmp.next;
            if (tmp == first) {
                return true;
            } else if (tmp == null) {
                return false;
            }
        }
    }
}
