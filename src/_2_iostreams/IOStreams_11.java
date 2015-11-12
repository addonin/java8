package _2_iostreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Dmitry Adonin
 * @since 11/12/2015
 */
public class IOStreams_11 {
    public static void main(String[] args) {

        List<ArrayList<String>> in = new ArrayList<>();
        in.add(new ArrayList<>(Arrays.asList("01", "02", "03")));
        in.add(new ArrayList<>(Arrays.asList("04", "05")));
        in.add(new ArrayList<>(Arrays.asList("06", "07", "08", "09", "10")));

        String[] strings = in.stream().flatMap(Collection::stream).toArray(String[]::new);
        int capacity = strings.length;
        List<String> list = new ArrayList<>(Arrays.asList(new String[capacity]));
        IntStream intStream = IntStream.rangeClosed(0, capacity - 1); // excluding last index in range
        intStream.parallel().forEach(e -> list.set(e, strings[e]));
        list.forEach(System.out::println);
    }
}
