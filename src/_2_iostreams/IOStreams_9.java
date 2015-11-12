package _2_iostreams;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author Dmitry Adonin
 * @since 11/11/2015
 */
public class IOStreams_9 {
    public static void main(String[] args) {

        // 1
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("qwe");
        a1.add("asd");

        ArrayList<String> a2 = new ArrayList<>();
        a2.add("wer");
        a2.add("sdf");

        Stream<ArrayList<String>> stream = Stream.of(a1, a2);
        ArrayList<String> list = stream.reduce((l1, l2) -> {
            l1.addAll(l2);
            return l1;
        }).orElse(new ArrayList<>());
        System.out.println(list);

        // 2
        a1 = new ArrayList<>();
        a1.add("qwe");
        a1.add("asd");
        a2 = new ArrayList<>();
        a2.add("wer");
        a2.add("sdf");

        Stream<ArrayList<String>> stream1 = Stream.of(a1, a2);
        ArrayList<String> identity = new ArrayList<>();
        identity.add("_");

        ArrayList<String> list1 = stream1.reduce(identity, (l1, l2) -> {
            ArrayList<String> temp = new ArrayList<String>(l1);
            temp.addAll(l2);
            return temp;
        });
        //list1.forEach(System.out::println);
        System.out.println(list1);

        // 3
        a1 = new ArrayList<>();
        a1.add("qwe");
        a1.add("asd");
        a2 = new ArrayList<>();
        a2.add("wer");
        a2.add("sdf");

        Stream<ArrayList<String>> stream2 = Stream.of(a1, a2);
        int result = stream2.reduce(0, (total, arrayList) -> total + arrayList.size(), (total1, total2) -> total1 + total2);
        System.out.println(result);
    }
}
