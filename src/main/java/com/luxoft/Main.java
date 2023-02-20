package com.luxoft;

import com.luxoft.model.VowelCount;
import com.luxoft.utils.ReadFile;
import com.luxoft.utils.WriteFile;
import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Reads the contents of the file "INPUT.TXT" and stores each word as a separate element in the List "words"
        List<String> words = ReadFile.readFile("INPUT.TXT");

        // Define the set of vowels and the input and output files
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        File outputFile = new File("OUTPUT.TXT");

        // Define a map to store the count of vowels per word
        Map<Set<Character>, Map<Integer, VowelCount>> counts = new HashMap<>();

        // Count the vowels in the word and get average
        Calculate.calculate(words, vowels, counts);

        // Write output to file
        WriteFile.writeToFile(counts, outputFile.toString());
    }
}
