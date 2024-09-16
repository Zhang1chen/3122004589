package com.example;

package com.example;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessorTest {
    @Test
    public void testTokenize() {
        TextProcessor processor = new TextProcessor();

        String input = "Hello, World!";
        Set<String> result = processor.tokenize(input);

        // 预期结果应为字符集合
        Set<String> expected = Set.of("h", "e", "l", "o", ",", " ", "w", "r", "d", "!");
        assertEquals(expected, result, "Tokenized words do not match expected results.");
    }
}

