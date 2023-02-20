package com.luxoft.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 The ReadFile class provides a method to read a file and return a list of strings containing all the words in the file.
 */
public class ReadFile {
    private static final Logger logger = LogManager.getLogger(ReadFile.class);
    /**
     Reads a file from the specified path and returns a list of strings containing all the words in the file.
     @param filePath the path of the file to be read
     @return a list of strings containing all the words in the file
     @throws RuntimeException if there is an error processing the file during reading
     */
    public static List<String> readFile(String filePath) {
        logger.info("Reading file from path: {}", filePath);

        List<String> words;

        // Read all words from input file by Files.lines as Stream<String>, then convert to List<String>
        try (Stream<String> wordsStream = Files.lines(Paths.get(filePath))) {
            words = wordsStream
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error processing file during reading: {}", e.getMessage());
            throw new RuntimeException("Error processing file during reading: " + e.getMessage());
        } finally {
            logger.info("Finished reading file");
        }

        return words;
    }
}
