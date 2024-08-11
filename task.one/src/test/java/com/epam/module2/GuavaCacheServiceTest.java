package com.epam.module2;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class GuavaCacheServiceTest {

    @Test
    void put_increasesPutCount() {
        GuavaCacheService cacheService = new GuavaCacheService();
        cacheService.put("key1", "value1");
        assertEquals(1, cacheService.getCacheSize());
    }

    @Test
    void put_updatesAveragePutTime() {
        GuavaCacheService cacheService = new GuavaCacheService();
        cacheService.put("key1", "value1");
        assertTrue(cacheService.getAveragePutTime() > 0);
    }

    @Test
    void get_returnsValueIfExists() {
        GuavaCacheService cacheService = new GuavaCacheService();
        cacheService.put("key1", "value1");
        assertEquals("value1", cacheService.get("key1"));
    }

    @Test
    void get_returnsNullIfNotExists() {
        GuavaCacheService cacheService = new GuavaCacheService();
        assertNull(cacheService.get("key1"));
    }

    @Test
    void getAveragePutTime_returnsZeroIfNoPuts() {
        GuavaCacheService cacheService = new GuavaCacheService();
        assertEquals(0, cacheService.getAveragePutTime(), 0.001);
    }

    @Test
    void getEvictionCount_increasesOnEviction() throws InterruptedException {
        GuavaCacheService cacheService = new GuavaCacheService();
        cacheService.put("key1", "value1");
        TimeUnit.SECONDS.sleep(6);
        cacheService.put("key2", "value2");
        assertEquals(1, cacheService.getEvictionCount());
    }
}