package com.luxoft.utils;

import com.luxoft.model.VowelCount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 The WriteFile class provides a static method that writes the given Map of vowel counts to an output file.
 */
public class WriteFile {
    private static final Logger logger = LogManager.getLogger(WriteFile.class);
    /**
     Writes the given Map of vowel counts to an output file.
     @param counts a Map of vowel counts, where the keys are sets of characters and the values are submaps of integer lengths and VowelCount objects
     @param outputFile the path of the file to write the output to
     */
    public static void writeToFile(Map<Set<Character>, Map<Integer, VowelCount>> counts, String outputFile){
        logger.info("Writing result to output file: {}", outputFile);

        // Write the result to the output file
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            counts.forEach((key, subMap) -> subMap.forEach((length, vowelCount) -> {
                double avg = vowelCount.getAverage();
                writer.printf("(%s, %d) -> %.1f%n", key.toString().replaceAll("\\[", "{").replaceAll("]", "}"), length, avg);
            }));
        } catch (FileNotFoundException e) {
            logger.error("Error writing to output file: {}", e.getMessage());
        } finally {
            logger.info("Finished writing to file");
        }
    }
}
