package com.epam.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchRecursiveTest extends BinarySearchConfig {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void search_testCases(int[] arr, int target, Optional<Integer> expectedResult) {
        BinarySearchRecursive binarySearch = new BinarySearchRecursive();
        Optional<Integer> result = binarySearch.search(arr, target);
        assertEquals(expectedResult, result);
    }
}