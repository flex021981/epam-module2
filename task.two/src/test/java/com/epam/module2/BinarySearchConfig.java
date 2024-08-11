package com.epam.module2;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Optional;
import java.util.stream.Stream;

public class BinarySearchConfig {
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3, Optional.of(2)),   // Target in the middle
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, Optional.of(0)),   // Target at the start
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5, Optional.of(4)),   // Target at the end
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 6, Optional.empty()), // Target not found
                Arguments.of(new int[]{}, 1, Optional.empty()),              // Empty array
                Arguments.of(new int[]{1}, 1, Optional.of(0)),               // Single element array, target found
                Arguments.of(new int[]{1}, 2, Optional.empty())              // Single element array, target not found
        );
    }
}
