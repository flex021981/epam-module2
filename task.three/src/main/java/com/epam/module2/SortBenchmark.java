package com.epam.module2;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class SortBenchmark {
    public static void main(String[] args) {

        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }

        Stream.of(new InsertionSort(), new MergeSort()).forEach(sort -> {
            final String sortType = sort.getClass().getSimpleName();
            long start = System.currentTimeMillis();
            sort.sort(arr.clone());
            long end = System.currentTimeMillis() - start;
            log.info("Sort type {}: Time taken {}", sortType, end);
        });
    }
}