package com.bubesh.algorithms.page_eviction_policies;

public class LinkedListImpl<V> implements LinkedList<V> {

    private int size;
    private Node<V> tail;
    private Node<V> head;

    public LinkedListImpl() {
        super();
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public void addFist(Node<V> node) {

        size++;
        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        node.prev = head.prev;
        head.prev = node;
        head = node;
    }

    @Override
    public void addLast(Node<V> node) {

        size++;
        if (head == null) {
            head = tail = node;
            return;
        }

        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }

    @Override
    public Node<V> getFirst() {
        return head;
    }

    @Override
    public Node<V> getLast() {
        return tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void deleteFirst() {
        size--;
        Node<V> temp = head;
        head = head.next;
        head.prev = null;
        temp.next = temp.prev = null;
    }

    @Override
    public void deleteLast() {
        size--;
        Node<V> temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.next = temp.prev = null;
    }

    @Override
    public void delete(Node<V> node) {
        size--;
        Node<V> prev = node.prev;
        Node<V> next = node.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        node.next = node.prev = null;
    }

    @Override
    public void delete(V data) {

        Node<V> temp = head;

        if (temp == null) {
            return;
        }

        while (temp != null) {
            if (temp.data == data) {
                if (temp == head) {
                    deleteFirst();
                    return;
                }
                if (temp == tail) {
                    deleteLast();
                    return;
                }

                Node<V> prev = temp.prev;
                Node<V> next = temp.next;

                prev.next = next;
                next.prev = prev;
                temp.next = temp.prev = null;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    public void print() {
        Node<V> temp = head;
        while (temp != null) {
            System.out.printf(temp.data.toString() + ", ");
            temp = temp.next;
        }
        System.out.println();
    }
}
