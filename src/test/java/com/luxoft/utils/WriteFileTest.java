package com.luxoft.utils;

import com.luxoft.model.VowelCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WriteFileTest {
    private final String outputFile = "src/test/resources/TEST_OUTPUT.TXT";
    private final String invalidDirectory = "invalid_directory/TEST_OUTPUT.TXT";

    @Test
    public void writeToFile_WithEmptyMap_ShouldCreateEmptyFile() throws IOException {
        //given
        Map<Set<Character>, Map<Integer, VowelCount>> counts = new HashMap<>();
        //when
        WriteFile.writeToFile(counts, outputFile);
        //then
        Assertions.assertTrue(new File(outputFile).exists());
        Assertions.assertEquals("", Files.readString(Paths.get(outputFile)));
    }

    @Test
    public void writeToFile_WithNonEmptyMap_ShouldWriteToFile() throws IOException {
        // given
        Map<Set<Character>, Map<Integer, VowelCount>> counts = new HashMap<>();
        Set<Character> key = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Integer, VowelCount> subMap = new HashMap<>();
        VowelCount vowelCount = new VowelCount();
        vowelCount.setCount(1);
        vowelCount.setTotal(2);
        subMap.put(5, vowelCount);
        counts.put(key, subMap);
        // when
        WriteFile.writeToFile(counts, outputFile);
        // then
        String expectedOutput = "({a, e, u, i, o}, 5) -> 2.0\r\n";
        Assertions.assertTrue(new File(outputFile).exists());
        Assertions.assertEquals(expectedOutput, Files.readString(Paths.get(outputFile)));
    }

    @Test
    public void writeToFile_WithNonExistingDirectory_ShouldThrowRuntimeException() {
        // given
        Map<Set<Character>, Map<Integer, VowelCount>> counts = new HashMap<>();
        // when & then
        Assertions.assertThrows(RuntimeException.class, () -> WriteFile.writeToFile(counts, invalidDirectory));
    }
}