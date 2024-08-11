package com.epam.module2;

/**
 * Implements the Sort interface using the Merge Sort algorithm.
 */
public class MergeSort implements Sort {

    /**
     * Sorts the specified array using the Merge Sort algorithm.
     *
     * @param arr the array to be sorted
     */
    public void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

