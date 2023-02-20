package com.luxoft.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 The ReadFile class provides a static method that reads all words from a given file path and returns them as a List of Strings.
 It uses the Java NIO library to read the file and handle any errors that may occur during the process.
 The words are converted to lowercase and stored in the list in the order they appear in the file.
 */
public class ReadFile {
    private static final Logger logger = LogManager.getLogger(ReadFile.class);
    /**
     Reads all words from a file and returns them as a List of Strings.
     @param filePath the path of the file to be read
     @return a List of Strings containing all words in the file in the order they appear
     */
    public static List<String> readFile(String filePath) {
        logger.info("Reading file from path: {}", filePath);

        List<String> words = new ArrayList<>();

        // Read all words from input file by Files.lines as Stream<String>, then convert to List<String>
        try (Stream<String> wordsStream = Files.lines(Paths.get(filePath))) {
            words = wordsStream
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error processing file during reading: {}", e.getMessage());
        } finally {
            logger.info("Finished reading file");
        }

        return words;
    }
}
