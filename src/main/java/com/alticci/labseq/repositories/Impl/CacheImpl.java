package com.alticci.labseq.repositories.Impl;

import com.alticci.labseq.repositories.CacheRepo;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentMap;

@Component
public class CacheImpl implements CacheRepo<Long, Long> {

    private static final ConcurrentMap<Long, Long> CACHE = CacheServiceEnum.INSTANCE.cache();

    @Override
    public Long get(Object key) {
        return CACHE.get(key);
    }

    @Override
    public void put(final Long id, final Long entity) {
        CACHE.put(id, entity);
    }

    @Override
    public boolean containsValue(Object value) {
        return CACHE.containsValue(value);
    }

    @Override
    public boolean containsKey(Object key) {
        return this.get(key) != null;
    }
}
