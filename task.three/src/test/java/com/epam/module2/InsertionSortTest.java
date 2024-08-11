package com.epam.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest extends SortConfig {

    @ParameterizedTest
    @MethodSource("provideArraysForSort")
    void testInsertionSort(int[] arr, int[] expected) {
        InsertionSort sorter = new InsertionSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }
}