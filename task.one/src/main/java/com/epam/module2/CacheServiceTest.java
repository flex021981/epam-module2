package com.epam.module2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheServiceTest {
    public static void main(String[] args) throws InterruptedException {
        CacheService lfuCache = new LFUCacheService();
        CacheService guavaCache = new GuavaCacheService();

        // Test LFU Cache
        for (int i = 0; i < 150_000; i++) {
            lfuCache.put("key" + i, "value" + i);
            log.info("{}", lfuCache.get("key" + i));
            if (i % 1000 == 0) {
                Thread.sleep(1); // simulate some delay
            }
        }
        log.info("LFU Cache Average Put Time: {}", lfuCache.getAveragePutTime());
        log.info("LFU Cache Eviction Count: {}", lfuCache.getEvictionCount());

        // Test Guava Cache
        for (int i = 0; i < 150000; i++) {
            guavaCache.put("key" + i, "value" + i);
            log.info("{}", guavaCache.get("key" + i));
            if (i % 1000 == 0) {
                Thread.sleep(1); // simulate some delay
            }
        }
        log.info("Guava Cache Average Put Time: {}", guavaCache.getAveragePutTime());
        log.info("Guava Cache Eviction Count: {}", guavaCache.getEvictionCount());
    }
}
