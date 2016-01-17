package _2_streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Dmitry Adonin
 * @since 11/11/2015
 */
public class Streams_4 {
    public static void main(String[] args) {
        int[] values = {1,2,3,4,5};
        Stream objStream = Stream.of(values); // stream of objects
        IntStream  intStream = IntStream.of(values); // stream of int's, fits better for primitives
    }
}
