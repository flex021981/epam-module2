package com.epam.module2;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * LFU (Least Frequently Used) Cache Service implementation.
 * This class provides methods to put and get values from the cache,
 * and handles eviction of the least frequently used entries.
 */
@Slf4j
public class LFUCacheService implements CacheService {
    private static final int MAX_SIZE = 100_000;
    private static final long EXPIRATION_TIME = 5_000; // 5 seconds
    private final Map<String, CacheEntry> cache;
    private final PriorityQueue<CacheEntry> evictionQueue;
    private final ScheduledExecutorService scheduler;
    private long totalPutTime;
    private int putCount;
    private int evictionCount;

    public LFUCacheService() {
        this.cache = new ConcurrentHashMap<>();
        this.evictionQueue = new PriorityQueue<>(Comparator.comparingInt(CacheEntry::getFrequency));
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.totalPutTime = 0;
        this.putCount = 0;
        this.evictionCount = 0;
        startEvictionScheduler();
    }

    /**
     * Starts the eviction scheduler to periodically remove expired entries.
     */
    private void startEvictionScheduler() {
        scheduler.scheduleAtFixedRate(() -> {
            long now = System.currentTimeMillis();
            cache.values().removeIf(entry -> now - entry.getLastAccessTime() > EXPIRATION_TIME);
        }, 1, 1, TimeUnit.SECONDS);
    }

    /**
     * Puts a key-value pair into the cache.
     * If the cache size exceeds the maximum size, evicts the least frequently used entry.
     *
     * @param key   the key to be associated with the value
     * @param value the value to be cached
     */
    @Override
    public synchronized void put(String key, String value) {
        long startTime = System.nanoTime();
        if (cache.size() >= MAX_SIZE) {
            evictLFU();
        }
        CacheEntry entry = new CacheEntry(value);
        cache.put(key, entry);
        evictionQueue.offer(entry);
        totalPutTime += System.nanoTime() - startTime;
        putCount++;
    }

    /**
     * Retrieves a value from the cache by its key.
     * Updates the access time and frequency of the cache entry.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if the key does not exist
     */
    @Override
    public synchronized String get(String key) {
        CacheEntry entry = cache.get(key);
        if (entry == null) {
            return null;
        }
        entry.updateAccess();
        evictionQueue.remove(entry);
        evictionQueue.offer(entry);
        return entry.getValue();
    }

    /**
     * Gets the average time taken to put a key-value pair into the cache.
     *
     * @return the average put time in nanoseconds
     */
    @Override
    public double getAveragePutTime() {
        return putCount == 0 ? 0 : (double) totalPutTime / putCount;
    }

    /**
     * Gets the count of evictions that have occurred in the cache.
     *
     * @return the number of evictions
     */
    @Override
    public int getEvictionCount() {
        return evictionCount;
    }

    private synchronized void evictLFU() {
        CacheEntry entry = evictionQueue.poll();
        if (entry != null) {
            cache.values().remove(entry);
            log.info("Removed entry: {}", entry.getValue());
            evictionCount++;
        }
    }
}
