package com.epam.module2;

/**
 * Interface representing a cache service.
 * Provides methods to put and get values from the cache,
 * as well as retrieve statistics about cache operations.
 */
public interface CacheService {

    /**
     * Puts a key-value pair into the cache.
     *
     * @param key   the key to be associated with the value
     * @param value the value to be cached
     */
    void put(String key, String value);

    /**
     * Retrieves a value from the cache by its key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if the key does not exist
     */
    String get(String key);

    /**
     * Gets the average time taken to put a key-value pair into the cache.
     *
     * @return the average put time in milliseconds
     */
    double getAveragePutTime();

    /**
     * Gets the count of evictions that have occurred in the cache.
     *
     * @return the number of evictions
     */
    int getEvictionCount();
}
