package com.bubesh.algorithms.page_eviction_policies;

public interface Cache<K, V> {

    V get(K key);

    default void printedEvictedKey(K key) {
        System.out.println(key.toString() + " got evicted");
    }

    default void printCachedKey(K key) {
        System.out.println(key.toString() + " got cached");
    }

}
