package com.epam.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest extends SortConfig {

    @ParameterizedTest
    @MethodSource("provideArraysForSort")
    void testMergeSort(int[] arr, int[] expected) {
        MergeSort sorter = new MergeSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }
}