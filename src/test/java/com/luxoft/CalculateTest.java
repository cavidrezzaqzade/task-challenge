package com.luxoft;

import com.luxoft.model.VowelCount;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateTest {

    @Test
    public void calculate_WithValidData_CorrectlyUpdatesCountsMap() {
        // given
        // create test data
        List<String> words = Arrays.asList("luxoft", "java", "programming");
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Set<Character>, Map<Integer, VowelCount>> counts = new HashMap<>();

        // when
        // call the method being tested
        Calculate.calculate(words, vowels, counts);

        //then
        // verify the results
        // first, check that the counts map has the expected keys and values
        assertEquals(3, counts.size());
        assertTrue(counts.containsKey(new HashSet<>(Arrays.asList('u', 'o'))));
        assertTrue(counts.containsKey(new HashSet<>(List.of('a'))));
        assertTrue(counts.containsKey(new HashSet<>(Arrays.asList('o', 'a', 'i'))));
        assertEquals(1, counts.get(new HashSet<>(Arrays.asList('u', 'o'))).size());
        assertEquals(1, counts.get(new HashSet<>(Arrays.asList('o', 'a', 'i'))).size());
        assertEquals(1, counts.get(new HashSet<>(List.of('a'))).size());

        // second, check that the method didn't modify the input data
        assertEquals(Arrays.asList("luxoft", "java", "programming"), words);
        assertEquals(new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u')), vowels);
    }
}