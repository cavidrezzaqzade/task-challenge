package com.luxoft;

import com.luxoft.model.VowelCount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

/**
 The Calculate class provides a static method that takes a List of words, a Set of vowels, and a Map of vowel counts, and updates the count for each word in the list.
 It counts the number of vowels in each word and stores the count along with the unique set of vowels in the Map.
 This class uses the VowelCount class to store the count of vowels for each word length and set of vowels.
 */
public class Calculate {
    private static final Logger logger = LogManager.getLogger(Calculate.class);
    /**
     Calculates the count of vowels for each word in the given List, and updates the count in the given Map of vowel counts.
     @param words a List of Strings containing the words to count the vowels for
     @param vowels a Set of Characters representing the vowels to count
     @param counts a Map of vowel counts, where the keys are sets of characters and the values are submaps of integer lengths and VowelCount objects
     */
    public static void calculate(List<String> words, Set<Character> vowels, Map<Set<Character>, Map<Integer, VowelCount>> counts){
        logger.info("Calculating vowel counts for words");
        words.forEach(word -> {
            // Count the vowels in the word
            int vowelCount = 0;
            Set<Character> uniqueVowels = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (vowels.contains(c)) {
                    vowelCount++;
                    uniqueVowels.add(c);
                }
            }
            // Update the count for the current set of vowels and word length
            int length = word.length();
            counts.putIfAbsent(uniqueVowels, new HashMap<>());
            Map<Integer, VowelCount> subMap = counts.get(uniqueVowels);
            subMap.putIfAbsent(length, new VowelCount());
            subMap.get(length).addCount(vowelCount);
        });
        logger.info("Finished calculating vowel counts for words");
    }
}