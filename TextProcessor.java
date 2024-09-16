package com.example;

import java.util.HashSet;
import java.util.Set;

public class TextProcessor {

    /**
     * Tokenizes the given text into a set of words.
     
     * @param text The text to be tokenized.
     * @return A set of words extracted from the text.
     */
    public Set<String> tokenize(String text) {
        // 将文本转换为小写并保留所有字符（对于中文，直接处理）
        String cleanedText = text.toLowerCase();  // 不进行复杂的清理
        Set<String> wordSet = new HashSet<>();

        // 将每个字符作为一个“词”添加到集合中
        for (char ch : cleanedText.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                wordSet.add(String.valueOf(ch));
            }
        }

        // 输出分词结果
        System.out.println("Tokenized words: " + wordSet);
        return wordSet;
    }
}


