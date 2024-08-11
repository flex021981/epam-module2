package com.epam.module2;

import java.util.Optional;

/**
 * Interface representing a binary search algorithm.
 * Provides a method to search for a target value within an array.
 */
public interface BinarySearch {

    /**
     * Searches for a target value within the specified array.
     *
     * @param arr    the array to search within
     * @param target the value to search for
     * @return an Optional containing the index of the target value if found, or an empty Optional if not found
     */
    Optional<Integer> search(int[] arr, int target);
}
