package com.example.test;

import java.util.HashSet;
import java.util.Set;

public class SimilarityChecker {

    /**
     * Calculates the similarity between two sets of words.
     * @param wordsOriginal The set of words from the original text.
     * @param wordsPlagiarized The set of words from the plagiarized text.
     * @return The similarity percentage between the two sets of words.
     */
    public double calculateSimilarity(Set<String> wordsOriginal, Set<String> wordsPlagiarized) {
        // 计算交集和并集
        Set<String> intersection = new HashSet<>(wordsOriginal);
        intersection.retainAll(wordsPlagiarized);

        Set<String> union = new HashSet<>(wordsOriginal);
        union.addAll(wordsPlagiarized);

        // 输出交集和并集的大小
        System.out.println("Intersection size: " + intersection.size());
        System.out.println("Union size: " + union.size());

        // 计算相似度
        double similarity = 0.0;
        if (!union.isEmpty()) {
            similarity = (double) intersection.size() / union.size() * 100;
        }

        return similarity;
    }
}
