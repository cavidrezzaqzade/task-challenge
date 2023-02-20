package com.luxoft;

import com.luxoft.model.VowelCount;
import java.util.*;


public class Calculate {

    public static void calculate(List<String> words, Set<Character> vowels, Map<Set<Character>, Map<Integer, VowelCount>> counts){
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
    }
}