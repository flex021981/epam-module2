package com.epam.module2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheServiceTest {
    @Test
    void put_increasesPutCount() {
        LFUCacheService cacheService = new LFUCacheService();
        cacheService.put("key1", "value1");
        assertEquals(1, cacheService.getCacheSize());
    }

    @Test
    void put_updatesAveragePutTime() {
        LFUCacheService cacheService = new LFUCacheService();
        cacheService.put("key1", "value1");
        assertTrue(cacheService.getAveragePutTime() > 0);
    }

    @Test
    void get_returnsValueIfExists() {
        LFUCacheService cacheService = new LFUCacheService();
        cacheService.put("key1", "value1");
        assertEquals("value1", cacheService.get("key1"));
    }

    @Test
    void get_returnsNullIfNotExists() {
        LFUCacheService cacheService = new LFUCacheService();
        assertNull(cacheService.get("key1"));
    }

    @Test
    void getAveragePutTime_returnsZeroIfNoPuts() {
        LFUCacheService cacheService = new LFUCacheService();
        assertEquals(0, cacheService.getAveragePutTime(), 0.001);
    }

    @Test
    void put_evictsLFUWhenMaxSizeExceeded() {
        LFUCacheService cacheService = new LFUCacheService();
        for (int i = 0; i < 100_000; i++) {
            cacheService.put("key" + i, "value" + i);
        }
        cacheService.put("key100000", "value100000");
        assertNull(cacheService.get("key0"));
        assertEquals(100_000, cacheService.getCacheSize());
    }

    @Test
    void get_updatesAccessFrequency() {
        LFUCacheService cacheService = new LFUCacheService();
        cacheService.put("key1", "value1");
        cacheService.get("key1");
        cacheService.get("key1");
        assertEquals("value1", cacheService.get("key1"));
    }

    @Test
    void put_doesNotEvictIfBelowMaxSize() {
        LFUCacheService cacheService = new LFUCacheService();
        cacheService.put("key1", "value1");
        cacheService.put("key2", "value2");
        assertEquals("value1", cacheService.get("key1"));
        assertEquals("value2", cacheService.get("key2"));
    }

}