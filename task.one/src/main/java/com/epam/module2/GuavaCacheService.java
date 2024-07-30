package com.epam.module2;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class GuavaCacheService implements CacheService {
    private final LoadingCache<String, String> cache;
    private long totalPutTime = 0;
    private int putCount = 0;
    private int evictionCount = 0;

    public GuavaCacheService() {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(100_000)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .removalListener((RemovalListener<String, String>) notification -> {
                    log.info("Removed entry: {}", notification.getValue());
                    evictionCount++;
                })
                .build(new CacheLoader<>() {
                    @Override
                    public String load(String key) {
                        return null;
                    }
                });
    }

    @Override
    public void put(String key, String value) {
        long startTime = System.nanoTime();
        cache.put(key, value);
        totalPutTime += System.nanoTime() - startTime;
        putCount++;
    }

    @Override
    public String get(String key) {
        return cache.getIfPresent(key);
    }

    @Override
    public double getAveragePutTime() {
        return putCount == 0 ? 0 : (double) totalPutTime / putCount;
    }

    @Override
    public int getEvictionCount() {
        return evictionCount;
    }
}
