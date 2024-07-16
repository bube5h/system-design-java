package com.bubesh.algorithms.page_eviction_policies;

public class Node<V> {

    public Node<V> prev;
    public Node<V> next;
    public V data;

    public Node(V data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public Node(V data, Node<V> prev, Node<V> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
