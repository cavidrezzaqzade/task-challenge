package com.luxoft.utils;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReadFileTest {

    @Test
    public void readFile_InputFileExists_ReturnsListOfWords() {
        // given
        String filePath = "src/test/resources/INPUT.TXT";
        List<String> expectedWords = List.of("this", "is", "a", "test", "file", "for", "unit", "testing");
        // when
        List<String> words = ReadFile.readFile(filePath);
        // then
        assertEquals(expectedWords, words);
    }

    @Test
    public void readFile_InputFileDoesNotExist_ThrowsRuntimeException() {
        // given
        String filePath = "src/test/resources/INPUT2.TXT";
        // when & then
        assertThrows(RuntimeException.class, () -> ReadFile.readFile(filePath));
    }

    @Test
    public void readFile_InputFileIsEmpty_ReturnsEmptyList() {
        // given
        String filePath = "src/test/resources/EMPTY-FILE.TXT";
        List<String> expectedWords = List.of();
        // when
        List<String> words = ReadFile.readFile(filePath);
        // then
        assertEquals(expectedWords, words);
    }

}