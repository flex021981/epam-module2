package com.epam.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @ParameterizedTest
    @MethodSource("provideInsertTestCases")
    void insert_testCases(int[] valuesToInsert, int expectedRootValue, Integer expectedLeftValue, Integer expectedRightValue) {
        BinaryTree tree = new BinaryTree();
        for (int value : valuesToInsert) {
            tree.insert(value);
        }

        assertNotNull(tree.getRoot());
        assertEquals(expectedRootValue, tree.getRoot().getValue());

        if (expectedLeftValue != null) {
            assertEquals(expectedLeftValue, tree.getRoot().getLeft().getValue());
        }

        if (expectedRightValue != null) {
            assertEquals(expectedRightValue, tree.getRoot().getRight().getValue());
        }
    }

    static Stream<Arguments> provideInsertTestCases() {
        return Stream.of(
                Arguments.of(new int[]{5}, 5, null, null),                     // Single insert
                Arguments.of(new int[]{5, 3, 7}, 5, 3, 7),                     // Multiple inserts
                Arguments.of(new int[]{5, 7}, 5, null, 7),                     // Insert right only
                Arguments.of(new int[]{5, 3}, 5, 3, null)                      // Insert left only
        );
    }
}