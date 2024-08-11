package com.epam.module2;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class SortConfig {
    static Stream<Arguments> provideArraysForSort() {
        return Stream.of(
                Arguments.of(new int[]{5, 1, 6, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{4, 1, 3, 2, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3, 3, 4, 4}),
                Arguments.of(new int[]{1}, new int[]{1})
        );
    }
}
