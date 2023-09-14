package com.alticci.labseq.service;

import com.alticci.labseq.repositories.CacheRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LabseqService {

    @Autowired private CacheRepo<Long, Long> cache;

    public long calculateLabSeq(final long index) {

        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index == 0L) {
            return 0L;
        }
        if (index == 1L || index == 2L) {
            return 1L;
        }
        long result = calculateLabSeq(index - 3L) + calculateLabSeq(index - 2L);
        cache.put(index, result);

        return result;
    }
}
