package com.bubesh.algorithms.page_eviction_policies;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FifoCache<K, V> implements Cache<K, V> {

    private final int capacity;
    private final Queue<K> cache;
    private final HashMap<K, V> mp;

    public FifoCache(int capacity) {
        super();
        this.capacity = capacity;
        this.cache = new LinkedList<>();
        mp = new HashMap<>(capacity);
    }

    public static void main(String[] args) {
        FifoCache<Integer, Integer> page_cache = new FifoCache<>(4);
        Integer[] pageIds = new Integer[]{4, 8, 3, 6, 2, 7, 3, 6, 2, 6, 2, 6, 8, 5, 2, 4, 7, 8, 2};
        for (Integer pageId : pageIds) {
            page_cache.get(pageId);
        }
    }

    @Override
    public V get(K key) {

        if (mp.containsKey(key)) {
            return mp.get(key);
        }

        if (capacity == cache.size()) {
            evictAPage();
        }

        V page = (V) new Object();
        addPageToCache(key, page);
        return page;
    }

    private void evictAPage() {
        K removed = cache.remove();
        mp.remove(removed);
        printedEvictedKey(removed);
    }

    private void addPageToCache(K key, V page) {
        cache.add(key);
        mp.put(key, page);
        printCachedKey(key);
    }

}
