package com.epam.module2;

/**
 * Implements the Sort interface using the Insertion Sort algorithm.
 */
public class InsertionSort implements Sort {

    /**
     * Sorts the specified array of integers using the Insertion Sort algorithm.
     *
     * @param array the array to be sorted
     */
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
