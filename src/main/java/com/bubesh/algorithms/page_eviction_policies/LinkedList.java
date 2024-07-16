package com.bubesh.algorithms.page_eviction_policies;

public interface LinkedList<V> {


    void addFist(Node<V> node);

    void addLast(Node<V> node);

    Node<V> getFirst();

    Node<V> getLast();

    int getSize();

    void deleteFirst();

    void deleteLast();

    void delete(Node<V> node);

    void delete(V data);

    void print();
}
