package com.example;


import org.junit.jupiter.api.Test;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimilarityCheckerTest {

    @Test
    public void testCalculateSimilarity() {
        SimilarityChecker checker = new SimilarityChecker();

        Set<String> set1 = Set.of("hello", "world");
        Set<String> set2 = Set.of("hello", "java");

        double similarity = checker.calculateSimilarity(set1, set2);

        assertEquals(50.0, similarity, 0.01, "Similarity calculation is incorrect.");
    }
}
