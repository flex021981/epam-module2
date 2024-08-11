package com.epam.module2;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class BinarySearchBenchmark {
    public static void main(String[] args) {
        int[] arr = new int[1_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        final int target = 999_999;

        Stream.of(new BinarySearchIterative(), new BinarySearchRecursive())
                .forEach(s -> {
                    final String searchType = s.getClass().getSimpleName();
                    long start = System.currentTimeMillis();
                    s.search(arr, target)
                            .ifPresentOrElse(index -> {
                                        log.info("Search type {}: found at index {}", searchType, index);
                                        final long end = System.currentTimeMillis() - start;
                                        log.info("Search type {}: Time taken {}", searchType, end);
                                    },
                                    () -> log.info("Search type {}: Not found", searchType));
                });

    }
}