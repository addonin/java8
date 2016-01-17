package _2_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dmitry Adonin
 * @since 11/11/2015
 */
public class Streams_3 {
    public static void main(String[] args) throws IOException {

        String book = new String(
                Files.readAllBytes(
                        Paths.get("C:\\Users\\dmytro_adonin\\Downloads\\tolstoi.txt")));
        List<String> words = Arrays.asList(book.split("[\\P{L}]+"));

        long start = System.nanoTime();
        words.stream().filter(word -> word.length() > 10);
        long finish = System.nanoTime();
        System.out.println("Serial handling duration, millisecond: " + (finish - start)/1000000F);


        long startParallel = System.nanoTime();
        words.parallelStream().filter(word -> word.length() > 10);
        long finishParallel = System.nanoTime();
        System.out.println("Parallel handling duration, millisecond: " + (finishParallel - startParallel)/1000000F);
    }
}
