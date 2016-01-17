package _2_streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Dmitry Adonin
 * @since 11/11/2015
 */
public class Streams_6 {
    public static void main(String[] args) {
        Stream<Character> stream = characterStream("Hello");
        stream.forEach(System.out::println);
    }

    public static Stream<Character> characterStream(String s) {
       return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
}
