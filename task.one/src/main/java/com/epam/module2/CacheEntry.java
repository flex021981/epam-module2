package com.epam.module2;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents an entry in the cache.
 * Contains the value, last access time, and access frequency.
 */
@Getter
@ToString
public class CacheEntry {
    private final String value;
    private long lastAccessTime;
    private int frequency;

    /**
     * Constructs a new CacheEntry with the specified value.
     * Initializes the last access time to the current system time and the frequency to 1.
     *
     * @param value the value to be stored in the cache entry
     */
    public CacheEntry(String value) {
        this.value = value;
        this.lastAccessTime = System.currentTimeMillis();
        this.frequency = 1;
    }

    /**
     * Updates the last access time to the current system time and increments the access frequency.
     */
    public void updateAccess() {
        this.lastAccessTime = System.currentTimeMillis();
        this.frequency++;
    }
}