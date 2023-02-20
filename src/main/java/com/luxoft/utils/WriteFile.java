package com.luxoft.utils;

import com.luxoft.model.VowelCount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 The WriteFile class provides a static method to write the vowel count results to an output file.
 The class uses a map of sets of characters and maps of integer and vowel count to write the average vowel count
 for each set of characters and length to the output file. The output file path is provided as a string parameter
 to the writeToFile method.
 */
public class WriteFile {
    private static final Logger logger = LogManager.getLogger(WriteFile.class);
    /**
     Writes the vowel count results to the specified output file.
     @param counts a map of sets of characters and maps of integer and vowel count
     @param outputFile the output file path
     @throws RuntimeException if an error occurs while writing to the output file
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
            throw new RuntimeException("Error writing to output file: " + e.getMessage());
        } finally {
            logger.info("Finished writing to file");
        }
    }
}
