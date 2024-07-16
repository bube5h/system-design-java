package com.bubesh.algorithms.page_eviction_policies;

import java.util.HashMap;
import java.util.Map;


/**
 * LRU solver: https://solver.assistedcoding.eu/page_replacement
 */
public class LruCache<K, V> implements Cache<K, V> {

    private final int capacity;
    private final LinkedList<V> list;
    private final Map<K, Node<V>> mp;

    public LruCache(int capacity) {
        super();
        this.capacity = capacity;
        this.list = new LinkedListImpl<>();
        this.mp = new HashMap<>();
    }


    public static void main(String[] args) {
        LruCache<Integer, Integer> cache = new LruCache<>(4);
        Integer[] pageIds = new Integer[]{1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6};
        for (Integer pageId : pageIds) {
            cache.get(pageId);
            cache.print();
        }
    }

    @Override
    public V get(K key) {

        if (mp.containsKey(key)) {
            Node<V> node = mp.get(key);
            moveTheNodeToEnd(node);
            return node.data;
        }

        if (list.getSize() == capacity) {
            list.deleteFirst();
        }
        V value = (V) key; // get it from somewhere
        Node<V> node = new Node<>(value);
        list.addLast(node);
        return value;
    }

    private void moveTheNodeToEnd(Node<V> node) {
        list.delete(node);
        list.addLast(node);
    }

    public void print() {
        list.print();
    }
}
