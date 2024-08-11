package com.epam.module2;

import java.util.Optional;

/**
 * Implements the BinarySearch interface using a recursive approach.
 */
public class BinarySearchRecursive implements BinarySearch {

    /**
     * Searches for a target value within the specified array using binary search.
     *
     * @param arr    the array to search within
     * @param target the value to search for
     * @return an Optional containing the index of the target value if found, or an empty Optional if not found
     */
    @Override
    public Optional<Integer> search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    /**
     * Recursively searches for a target value within the specified range of the array.
     *
     * @param arr    the array to search within
     * @param target the value to search for
     * @param low    the lower bound of the range to search
     * @param high   the upper bound of the range to search
     * @return an Optional containing the index of the target value if found, or an empty Optional if not found
     */
    private Optional<Integer> search(int[] arr, int target, int low, int high) {
        if (low > high) {
            return Optional.empty(); // Target not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return Optional.of(mid);
        } else if (arr[mid] > target) {
            return search(arr, target, low, mid - 1);
        } else {
            return search(arr, target, mid + 1, high);
        }
    }
}
