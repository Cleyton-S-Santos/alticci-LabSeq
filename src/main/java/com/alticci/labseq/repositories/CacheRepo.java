package com.alticci.labseq.repositories;

public interface CacheRepo<K, V> {

    void put(K id, V entity);

    V get(Object key);

    boolean containsValue(Object value);

    boolean containsKey(Object value);
}
