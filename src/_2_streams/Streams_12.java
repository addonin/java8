package _2_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author Dmitry Adonin
 * @since 11/12/2015
 */
public class Streams_12 {
    public static void main(String[] args) throws IOException {
        int shortWordLength = 4;
        String book = new String(
                Files.readAllBytes(
                        Paths.get("C:\\Users\\dmytro_adonin\\Downloads\\tolstoi.txt")));
        List<String> words = Arrays.asList(book.split("[\\P{L}]+"));
        AtomicIntegerArray counters = new AtomicIntegerArray(shortWordLength);
        words.parallelStream()
                .forEach(word -> {
                    int length = word.length();
                    if (length <= shortWordLength) counters.getAndIncrement(length - 1);
                });
        Collections.singletonList(counters).forEach(System.out::println);
    }
}
