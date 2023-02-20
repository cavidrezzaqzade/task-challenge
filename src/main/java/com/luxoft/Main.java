package com.luxoft;

import com.luxoft.model.VowelCount;
import com.luxoft.utils.ReadFile;
import com.luxoft.utils.WriteFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.util.*;

/**
 * The Main class reads input from a file named "INPUT.TXT", stores each word as a separate element in a List, and counts the vowels in each word.
 * The class then writes the output to a file named "OUTPUT.TXT".
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(WriteFile.class);

    public static void main(String[] args) {
        logger.info("Starting main method");

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

        logger.info("The program has completed successfully.");
    }
}
