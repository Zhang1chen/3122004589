package com.example;


import com.example.test.SimilarityChecker;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java Main <originalFilePath> <plagiarizedFilePath> <outputFilePath>");
            System.exit(1);
        }

        String originalFilePath = args[0];
        String plagiarizedFilePath = args[1];
        String outputFilePath = args[2];

        try {
            // 记录性能数据 - 文件读取时间
            long startTime = System.nanoTime();
            String originalText = new String(Files.readAllBytes(Paths.get(originalFilePath)));
            String plagiarizedText = new String(Files.readAllBytes(Paths.get(plagiarizedFilePath)));
            long endTime = System.nanoTime();
            System.out.println("File reading time: " + (endTime - startTime) + " nanoseconds");

            // 处理文本
            com.example.TextProcessor processor = new com.example.TextProcessor();
            SimilarityChecker checker = new SimilarityChecker();

            startTime = System.nanoTime();
            Set<String> wordsOriginal = processor.tokenize(originalText);
            Set<String> wordsPlagiarized = processor.tokenize(plagiarizedText);
            endTime = System.nanoTime();
            System.out.println("Text processing time: " + (endTime - startTime) + " nanoseconds");

            // 计算相似度
            startTime = System.nanoTime();
            double similarity = checker.calculateSimilarity(wordsOriginal, wordsPlagiarized);
            endTime = System.nanoTime();
            System.out.println("Similarity calculation time: " + (endTime - startTime) + " nanoseconds");

            // 输出结果
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write(String.format("The similarity between the documents is: %.2f%%", similarity));
            }

            System.out.println("Similarity result has been written to " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error processing files.");
        }
    }
}






