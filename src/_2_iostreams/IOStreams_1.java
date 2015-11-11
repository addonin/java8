package _2_iostreams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dmitry Adonin
 * @since 11/10/2015
 */
public class IOStreams_1 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("wsfe", "gnrg", "oiyi", "huguy", "qdasd", "hih");
        System.out.println(list
                .parallelStream()
                .map(String::length)
                .reduce(((integer, integer2) -> integer + integer2))
                .get());
    }
}
