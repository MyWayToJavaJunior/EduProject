package ru.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 4/28/2017.
 * @param <E> type of elements.
 */
public class SimpleTree<E extends Comparable> {
    /**
     * Tree node class.
     */
    class TreeNode {
        /**
         * Value of node.
         */
        private E value;
        /**
         * Right child.
         */
        private TreeNode rightNode;
        /**
         * Left child.
         */
        private TreeNode leftNode;
        /**
         * Constructor.
         * @param value - value of node.
         */
        private TreeNode(E value) {
            this.value = value;
        }
    }

    /**
     * Root of the tree.
     */
    private TreeNode root = null;

    /**
     * Add child to tree.
     * @param value - value to add.
     */
    public void addChild(E value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        } else {
            addChild(root, value);
        }
    }
    /**
     * Add child to tree.
     * @param value - value to add.
     * @param node - root node to add.
     */
    private void addChild(TreeNode node, E value) {
        if (node.value.compareTo(value) < 0) {
            if (node.leftNode == null) {
                node.leftNode = new TreeNode(value);
            } else {
                addChild(node.leftNode, value);
            }
        } else {
            if (node.rightNode == null) {
                node.rightNode = new TreeNode(value);
            } else {
                addChild(node.rightNode, value);
            }
        }
    }

    /**
     * Print all elements of the tree.
     */
    public void print() {
        if (root != null) {
            print(root);
        } else {
            System.out.println("Tree is empty.");
        }
    }
    /**
     * Print all elements of the tree.
     * @param node - root node.
     */
    private void print(TreeNode node) {
        if (node.leftNode != null) {
            print(node.leftNode);
        }
        System.out.println(node.value);
        if (node.rightNode != null) {
            print(node.rightNode);
        }
    }

    /**
     * Search element in the tree.
     * @param value - value to search.
     * @return - result of search.
     */
    public boolean search(E value) {
        if (root != null) {
            return search(root, value);
        } else {
            return false;
        }

    }

    /**
     * Search element in the tree.
     * @param value - value to search.
     * @param node - root node.
     * @return - result of search.
     */
    private boolean search(TreeNode node, E value) {
        if (node.value.compareTo(value) == 0) {
            return true;
        }

        if (node.value.compareTo(value) < 0 && node.leftNode != null) {
            return search(node.leftNode, value);

        }

        if (node.value.compareTo(value) > 0 && node.rightNode != null) {
            return search(node.rightNode, value);
        }

        return false;
    }

    /**
     * Get child of element.
     * @param value - value to search.
     * @return - result of search.
     */
    public List<E> getChildren(E value) {
        return getChildren(root, value);
    }

    /**
     * Get child of element.
     * @param value - value to search.
     * @param node - root node.
     * @return - result of search.
     */
    private List<E> getChildren(TreeNode node, E value) {
        List<E> list = new ArrayList<>();

        if (node.value.compareTo(value) == 0) {
            if (node.leftNode != null) {
                list.add(node.leftNode.value);
            }
            if (node.rightNode != null) {
                list.add(node.rightNode.value);
            }
            return list;
        }

        if (node.value.compareTo(value) < 0 && node.leftNode != null) {
            search(node.leftNode, value);
        }

        if (node.value.compareTo(value) > 0 && node.rightNode != null) {
            search(node.rightNode, value);
        }

        return list;
    }
}
