package binarytree;

import java.util.*;

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> root;
    private Comparator<T> comparator;

    public BinaryTree() {
        root = null;
        comparator = null;
    }

    public BinaryTree(Comparator<T> comp) {
        root = null;
        comparator = comp;
    }

    private int compare(T x, T y) {
        if (comparator == null) return x.compareTo(y);
        else
            return comparator.compare(x, y);
    }

    //insert
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> fakeRoot, T value) {
        if (fakeRoot == null)
            return new Node<T>(value);

        if (compare(value, fakeRoot.data) == 0)
            return fakeRoot;

        if (compare(value, fakeRoot.data) < 0)
            fakeRoot.left = insert(fakeRoot.left, value);
        else
            fakeRoot.right = insert(fakeRoot.right, value);

        return fakeRoot;
    }

    //search
    public boolean search(T toSearch) {
        return search(root, toSearch);
    }

    private boolean search(Node<T> fakeRoot, T value) {
        if (fakeRoot == null)
            return false;

        if (compare(value, fakeRoot.data) == 0)
            return true;

        if (compare(value, fakeRoot.data) < 0)
            return search(fakeRoot.left, value);

        else
            return search(fakeRoot.right, value);
    }

    //delete
    public void delete(T toDelete) {
        root = delete(root, toDelete);
    }

    private Node<T> delete(Node<T> fakeRoot, T valueToDelete) {
        if (fakeRoot == null)
            throw new RuntimeException("Cannot delete!");

        if (compare(valueToDelete, fakeRoot.data) < 0)
            fakeRoot.left = delete(fakeRoot.left, valueToDelete);

        if (compare(valueToDelete, fakeRoot.data) > 0)
            fakeRoot.right = delete(fakeRoot.right, valueToDelete);

        else {
            if (fakeRoot.left == null)
                return fakeRoot.right;

            if (fakeRoot.right == null)
                return fakeRoot.left;

            else {
                // get data from the rightmost node in the left subtree
                fakeRoot.data = retrieveData(fakeRoot.left);
                // delete the rightmost node in the left subtree
                fakeRoot.left = delete(fakeRoot.left, fakeRoot.data);
            }
        }
        return fakeRoot;
    }

    private T retrieveData(Node<T> fakeRoot) {
        while (fakeRoot.right != null) {
            fakeRoot = fakeRoot.right;
        }
        return fakeRoot.data;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (T data : this) {
            sb.append(data.toString()).append(" ");
        }
        return sb.toString();
    }


    public Iterator<T> iterator() {
        return new MyIterator();
    }

    //pre-order
    private class MyIterator implements Iterator<T> {
        Stack<Node<T>> stk = new Stack<>();

        public MyIterator() {
            if (root != null)
                stk.push(root);
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }

        public T next() {
            Node<T> cur = stk.peek();
            if (cur.left != null) {
                stk.push(cur.left);
            } else {
                Node<T> tmp = stk.pop();
                while (tmp.right == null) {
                    if (stk.isEmpty()) return cur.data;
                    tmp = stk.pop();
                }
                stk.push(tmp.right);
            }

            return cur.data;
        }

        public void remove() {

        }
    }
    //Node
    private class Node<T> {
        private T data;
        private Node<T> left, right;

        public Node(T data, Node<T> l, Node<T> r) {
            left = l;
            right = r;
            this.data = data;
        }

        public Node(T data) {
            this(data, null, null);
        }

        public String toString() {
            return data.toString();
        }
    }
}

class MyComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
        return y - x;
    }
}