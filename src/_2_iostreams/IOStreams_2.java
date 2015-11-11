package _2_iostreams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dmitry Adonin
 * @since 11/11/2015
 */
public class IOStreams_2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("wsfe", "gnrg", "oiyi", "huguy", "qdasd", "hih", "sdcwe", "dfsrtt", "dfvrtv", "dfver");
        list.parallelStream().filter(e -> e.length() > 4).limit(3).forEach(System.out::println);
    }
}
