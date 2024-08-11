package com.epam.module2;

import java.util.Optional;

/**
 * Implements the BinarySearch interface using an iterative approach.
 */
public class BinarySearchIterative implements BinarySearch {

    /**
     * Searches for a target value within the specified array using binary search.
     *
     * @param arr    the array to search within
     * @param target the value to search for
     * @return an Optional containing the index of the target value if found, or an empty Optional if not found
     */
    @Override
    public Optional<Integer> search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return Optional.of(mid);
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return Optional.empty(); // Target not found
    }
}
