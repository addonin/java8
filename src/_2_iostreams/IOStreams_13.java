package _2_iostreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Dmitry Adonin
 * @since 11/12/2015
 */
public class IOStreams_13 {
    public static void main(String[] args) throws IOException {

        int shortWordLength = 4;
        String book = new String(
                Files.readAllBytes(
                        Paths.get("C:\\Users\\dmytro_adonin\\Downloads\\tolstoi.txt")));
        List<String> words = Arrays.asList(book.split("[\\P{L}]+"));

        /*Map<Integer, Long> stats = */words.parallelStream().filter(word -> word.length() <= shortWordLength)
                .collect(groupingBy(String::length, counting()))
                .forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
